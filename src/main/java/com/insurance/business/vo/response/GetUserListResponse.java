package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class GetUserListResponse {
    @JsonSerialize(using = ToStringSerializer.class)
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
