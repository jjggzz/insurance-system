package com.insurance.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.business.constant.RuleEnum;
import com.insurance.business.mapper.UserModelMapper;
import com.insurance.business.model.UserModel;
import com.insurance.business.model.UserModelExample;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.insurance.utils.IdUtils;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import com.springboot.simple.res.ResultEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
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
        UserModel userModel = newModel();
        BeanUtils.copyProperties(addUserRequest,userModel);
        userModel.setAccessKey(IdUtils.getInstance().nextId());
        insert(userModel);
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
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> deleteUserByAccessKey(Long accessKey) {
        UserModelExample userModelExample = newExample();
        userModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andAccessKeyEqualTo(accessKey);
        List<UserModel> userModels = selectByExample(userModelExample);
        if (CollectionUtils.isEmpty(userModels)) {
            return ResultEntity.failure("该用户不存在");
        }

        UserModel userModel = userModels.get(0);
        userModel.setDeleted(true);
        update(userModel);
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
        selectByExample(userModelExample);
        List<GetUserListResponse> list = userModels.stream().map(userModel -> {
            GetUserListResponse getUserListResponse = new GetUserListResponse();
            BeanUtils.copyProperties(userModel,getUserListResponse,"rule");
            getUserListResponse.setRule(RuleEnum.getNameByCode(userModel.getRule()));
            return getUserListResponse;
        }).collect(Collectors.toList());

        PageInfo<GetUserListResponse> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(userModels.getPageNum());
        pageInfo.setPageSize(userModels.getPageSize());
        pageInfo.setTotal(userModels.getTotal());
        return ResultEntity.success(pageInfo);
    }
}
