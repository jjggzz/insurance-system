package com.insurance.business.vo.response;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class GetInsuranceListResponse {
    private String insuranceName;
    private Integer insuranceType;
    private BigDecimal money;
    private String inputUserName;
    private Date inputTime;
    private Integer status;
}
