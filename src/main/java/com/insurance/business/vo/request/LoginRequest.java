package com.insurance.business.vo.request;

import lombok.Data;

/**
 * 登陆请求体
 */
@Data
public class LoginRequest {
    private String loginName;
    private String password;
    private String verifyCode;
}
