package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.List;

@Data
public class UserInfoResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accessKey;
    private String userName;
    private String phone;
    private List<Integer> rule;
}
