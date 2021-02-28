package com.insurance.business.controller;

import com.github.pagehelper.PageInfo;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 操作员管理
 */
@RequestMapping("user")
@RestController
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @PostMapping("/add")
    public ResultEntity<Void> addUser(@RequestBody AddUserRequest addUserRequest) throws Exception {
        return result(addUserRequest,userService::addUser);
    }

    @PostMapping("/update")
    public ResultEntity<Void> updateUser(@RequestBody UpdateUserRequest updateUserRequest) throws Exception {
        return result(updateUserRequest,userService::updateUser);
    }

    @DeleteMapping("/delete/{accessKey}")
    public ResultEntity<Void> deleteUser(@PathVariable("accessKey") Long accessKey) throws Exception {
        return result(accessKey,userService::deleteUserByAccessKey);
    }

    @GetMapping("/list")
    public ResultEntity<PageInfo<GetUserListResponse>> getUserList(@RequestBody GetUserListRequest getUserListRequest) throws Exception {
        return result(getUserListRequest,userService::getUserList);
    }

}
