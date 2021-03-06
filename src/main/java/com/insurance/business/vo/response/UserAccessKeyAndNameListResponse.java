package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

@Data
public class UserAccessKeyAndNameListResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accessKey;
    private String userName;

}
