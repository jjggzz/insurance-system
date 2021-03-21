package com.insurance.business.vo.request;

import lombok.Data;

@Data
public class AddUserRequest {
    private String userName;
    private String loginName;
    private String password;
    private String phone;
    private Integer rule;
    private String identityNumber;
    private String address;
    private Integer age;
}
