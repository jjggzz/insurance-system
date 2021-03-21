package com.insurance.business.vo.request;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private Long accessKey;
    private String userName;
    private String phone;
    private String password;
    private Integer rule;
    private String identityNumber;
    private String address;
    private Integer age;
}
