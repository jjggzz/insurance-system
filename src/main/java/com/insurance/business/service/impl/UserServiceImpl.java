package com.insurance.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.business.constant.UserConstant;
import com.insurance.business.mapper.UserModelMapper;
import com.insurance.business.model.UserModel;
import com.insurance.business.model.UserModelExample;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.LoginRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.insurance.business.vo.response.LoginResponse;
import com.insurance.utils.IdUtils;
import com.insurance.utils.SessionUtils;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import com.springboot.simple.res.ResultEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl
        extends BaseServiceImpl<UserModel, UserModelMapper, UserModelExample>
        implements UserService {

    @Resource
    @Override
    public void setMapper(UserModelMapper mapper) {
        super.setMapper(mapper);
        super.setModelSupplier(UserModel::new);
        super.setExampleSupplier(UserModelExample::new);
    }

    @Override
    public ResultEntity<Void> addUser(AddUserRequest addUserRequest) {
        UserModelExample userModelExample = newExample();
        userModelExample.createCriteria().andLoginNameEqualTo(addUserRequest.getLoginName());
        List<UserModel> userModels = selectByExample(userModelExample);
        if (CollectionUtils.isNotEmpty(userModels)) {
            return ResultEntity.failure("用户已存在");
        }

        UserModel userModel = newModel();
        BeanUtils.copyProperties(addUserRequest,userModel);
        userModel.setAccessKey(IdUtils.getInstance().nextId());
        userModel.setInputTime(new Date());
        insert(userModel);
        LOGGER.warn("{} 添加用户,loginName = {}","addUser",addUserRequest.getLoginName());
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> updateUser(UpdateUserRequest updateUserRequest) {
        UserModelExample userModelExample = newExample();
        userModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andAccessKeyEqualTo(updateUserRequest.getAccessKey());
        List<UserModel> userModels = selectByExample(userModelExample);
        if (CollectionUtils.isEmpty(userModels)) {
            return ResultEntity.failure("该用户不存在");
        }

        UserModel userModel = userModels.get(0);
        BeanUtils.copyProperties(updateUserRequest,userModel);
        update(userModel);
        LOGGER.warn("{} 修改用户,accessKey = {}","updateUser",userModel.getAccessKey());
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> deleteUserByAccessKey(Long accessKey) {
        UserModelExample userModelExample = newExample();
        userModelExample.createCriteria()
                .andAccessKeyEqualTo(accessKey);
        List<UserModel> userModels = selectByExample(userModelExample);
        if (CollectionUtils.isEmpty(userModels)) {
            return ResultEntity.failure("该用户不存在");
        }

        UserModel userModel = userModels.get(0);
        delete(userModel.getId());
        LOGGER.warn("{} 删除用户,accessKey = {}","deleteUserByAccessKey",userModel.getAccessKey());
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<PageInfo<GetUserListResponse>> getUserList(GetUserListRequest getUserListRequest) {
        Page<UserModel> userModels = PageHelper.startPage(getUserListRequest.getPageNum(), getUserListRequest.getPageSize());
        UserModelExample userModelExample = newExample();
        UserModelExample.Criteria criteria = userModelExample.createCriteria()
                .andDeletedEqualTo(false);

        if (Objects.nonNull(getUserListRequest.getRule())) {
            criteria.andRuleEqualTo(getUserListRequest.getRule());
        }
        if (StringUtils.isNotBlank(getUserListRequest.getUserName())) {
            criteria.andUserNameLike("%" + getUserListRequest.getUserName() + "%");
        }
        if (Objects.nonNull(getUserListRequest.getStartTime())) {
            criteria.andInputTimeGreaterThanOrEqualTo(getUserListRequest.getStartTime());
        }
        if (Objects.nonNull(getUserListRequest.getEndTime())) {
            criteria.andInputTimeLessThanOrEqualTo(getUserListRequest.getEndTime());
        }

        selectByExample(userModelExample);
        List<GetUserListResponse> list = userModels.stream().map(userModel -> {
            GetUserListResponse getUserListResponse = new GetUserListResponse();
            BeanUtils.copyProperties(userModel,getUserListResponse);
            return getUserListResponse;
        }).collect(Collectors.toList());

        PageInfo<GetUserListResponse> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(userModels.getPageNum());
        pageInfo.setPageSize(userModels.getPageSize());
        pageInfo.setTotal(userModels.getTotal());
        return ResultEntity.success(pageInfo);
    }

    @Override
    public ResultEntity<LoginResponse> login(LoginRequest loginRequest, HttpServletRequest request) {
        UserModelExample userModelExample = newExample();
        userModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andLoginNameEqualTo(loginRequest.getLoginName());
        List<UserModel> userModels = selectByExample(userModelExample);
        if (CollectionUtils.isEmpty(userModels)) {
            return ResultEntity.failure("用户名或密码错误");
        }
        UserModel userModel = userModels.get(0);
        if (!userModel.getPassword().equals(loginRequest.getPassword())) {
            return ResultEntity.failure("用户名或密码错误");
        }

        // 登录成功
        LoginResponse loginResponse = new LoginResponse();
        BeanUtils.copyProperties(userModel,loginResponse);
        SessionUtils.setValue(request, UserConstant.USER_INFO,userModel);
        LOGGER.warn("{} 用户登录成功,accessKey = {}","login",userModel.getAccessKey());
        return ResultEntity.success(loginResponse);
    }
}
