package com.insurance.business.vo.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GetInsuranceListResponse {

    @JsonSerialize(using = ToStringSerializer.class)
    private Long accessKey;
    private String insuranceName;
    private Integer insuranceType;
    private BigDecimal money;
    private String inputUserName;
    private Date inputTime;
    private Integer status;
}
