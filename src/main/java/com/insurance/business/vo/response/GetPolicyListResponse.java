package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.util.Date;

@Data
public class GetPolicyListResponse {
    @JsonSerialize(using = ToStringSerializer.class)
    private Long accessKey;
    private String policyName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long insureUserAccessKey;
    private String insureUserName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long benefitUserAccessKey;
    private String benefitUserName;
    @JsonSerialize(using = ToStringSerializer.class)
    private Long insuranceAccessKey;
    private String insuranceName;
    private Date inputTime;
    private Integer duration;
}
