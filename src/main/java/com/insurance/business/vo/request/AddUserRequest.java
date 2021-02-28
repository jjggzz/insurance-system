package com.insurance.business.vo.request;

import lombok.Data;

@Data
public class AddUserRequest {
    private String userName;
    private String loginName;
    private String password;
    private Integer rule;
}
