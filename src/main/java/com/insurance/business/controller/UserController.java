package com.insurance.business.controller;

import com.github.pagehelper.PageInfo;
import com.insurance.business.constant.UserConstant;
import com.insurance.business.model.UserModel;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.LoginRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.insurance.business.vo.response.LoginResponse;
import com.insurance.business.vo.response.UserAccessKeyAndNameListResponse;
import com.insurance.business.vo.response.UserInfoResponse;
import com.insurance.utils.SessionUtils;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.List;

/**
 * 人员员管理
 */
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    /**
     * 添加用户信息
     * @param addUserRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    public ResultEntity<Void> addUser(@RequestBody AddUserRequest addUserRequest) throws Exception {
        return result(addUserRequest,userService::addUser);
    }

    /**
     * 修改用户信息
     * @param updateUserRequest
     * @return
     * @throws Exception
     */
    @PutMapping("/update")
    public ResultEntity<Void> updateUser(@RequestBody UpdateUserRequest updateUserRequest) throws Exception {
        return result(updateUserRequest,userService::updateUser);
    }

    /**
     * 通过accesskey删除用户
     * @param accessKey
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delete/{accessKey}")
    public ResultEntity<Void> deleteUser(@PathVariable("accessKey") Long accessKey) throws Exception {
        return result(accessKey,userService::deleteUserByAccessKey);
    }

    /**
     * 获取用户列表
     * @param getUserListRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/list")
    public ResultEntity<PageInfo<GetUserListResponse>> getUserList(@RequestBody GetUserListRequest getUserListRequest) throws Exception {
        return result(getUserListRequest,userService::getUserList);
    }

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResultEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return userService.login(loginRequest,getRequest());
    }

    @GetMapping("/getInfo")
    public ResultEntity<UserInfoResponse> getInfo(Long accessKey) {
        System.out.println(accessKey);
        UserModel userInfo = (UserModel) SessionUtils.getValue(getRequest(), UserConstant.USER_INFO);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        userInfoResponse.setAccessKey(userInfo.getAccessKey());
        userInfoResponse.setPhone(userInfo.getPhone());
        userInfoResponse.setUserName(userInfo.getUserName());
        userInfoResponse.setRules(Collections.singletonList(userInfo.getRule()));
        return ResultEntity.success(userInfoResponse);
    }

    /**
     * 用户登出
     * @return
     */
    @PostMapping("/logout")
    public ResultEntity<Void> logout() {
        SessionUtils.removeValue(getRequest(), UserConstant.USER_INFO);
        return ResultEntity.success();
    }

    @GetMapping("/baseData")
    public ResultEntity<List<UserAccessKeyAndNameListResponse>> getAccessKeyAndNameList() {
        List<UserAccessKeyAndNameListResponse> list = userService.getAccessKeyAndNameList();
        return ResultEntity.success(list);
    }

}
