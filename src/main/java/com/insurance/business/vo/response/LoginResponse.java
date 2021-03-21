package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

/**
 * 登陆响应体
 */
@Data
public class LoginResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accessKey;
}
