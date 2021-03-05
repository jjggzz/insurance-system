package com.insurance.business.vo.response;

import lombok.Data;

/**
 * 登陆响应体
 */
@Data
public class LoginResponse {
    private Long accessKey;
    private String userName;
    private String phone;
    private Integer rule;
}
