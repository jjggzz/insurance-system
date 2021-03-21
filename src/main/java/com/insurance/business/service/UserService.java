package com.insurance.business.service;

import com.github.pagehelper.PageInfo;
import com.insurance.business.model.UserModel;
import com.insurance.business.model.UserModelExample;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.LoginRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.insurance.business.vo.response.LoginResponse;
import com.insurance.business.vo.response.UserAccessKeyAndNameListResponse;
import com.springboot.simple.jdbc.service.BaseService;
import com.springboot.simple.res.ResultEntity;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface UserService extends BaseService<UserModel, UserModelExample> {

    ResultEntity<Void> addUser(AddUserRequest addUserRequest);

    ResultEntity<Void> updateUser(UpdateUserRequest updateUserRequest);

    ResultEntity<Void> deleteUserByAccessKey(Long accessKey);

     ResultEntity<PageInfo<GetUserListResponse>> getUserList(GetUserListRequest getUserListRequest);

    ResultEntity<LoginResponse> login(LoginRequest loginRequest, HttpServletRequest request);

    UserModel selectByAccessKey(Long accessKey);

    List<UserAccessKeyAndNameListResponse> getAccessKeyAndNameList();

}
