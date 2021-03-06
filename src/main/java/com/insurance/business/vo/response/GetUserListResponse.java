package com.insurance.business.vo.response;

import lombok.Data;

import java.util.Date;

@Data
public class GetUserListResponse {
    private Long accessKey;
    private String userName;
    private String loginName;
    private String phone;
    private Date inputTime;
    private Integer rule;
    private String identityNumber;
    private String address;
    private Integer age;
}
