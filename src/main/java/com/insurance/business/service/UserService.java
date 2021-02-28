package com.insurance.business.service;

import com.github.pagehelper.PageInfo;
import com.insurance.business.model.UserModel;
import com.insurance.business.model.UserModelExample;
import com.insurance.business.vo.request.AddUserRequest;
import com.insurance.business.vo.request.GetUserListRequest;
import com.insurance.business.vo.request.UpdateUserRequest;
import com.insurance.business.vo.response.GetUserListResponse;
import com.springboot.simple.jdbc.service.BaseService;
import com.springboot.simple.res.ResultEntity;

public interface UserService extends BaseService<UserModel, UserModelExample> {

    ResultEntity<Void> addUser(AddUserRequest addUserRequest);

    ResultEntity<Void> updateUser(UpdateUserRequest updateUserRequest);

    ResultEntity<Void> deleteUserByAccessKey(Long accessKey);

     ResultEntity<PageInfo<GetUserListResponse>> getUserList(GetUserListRequest getUserListRequest);
}
