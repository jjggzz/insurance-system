package com.insurance.business.vo.request;

import lombok.Data;

/**
 * 注册请求体
 */
@Data
public class RegisterRequest {
    private String loginName;
    private String password;
    private String phone;
    private String verifyCode;
}
