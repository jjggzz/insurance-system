package com.insurance.business.vo.response;

import lombok.Data;

@Data
public class GetUserListResponse {
    private Long accessKey;
    private String userName;
    private String loginName;
    private String password;
    private Integer rule;
}
