package com.insurance.business.vo.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AddInsuranceRequest {
    private String insuranceName;
    private Integer insuranceType;
    private BigDecimal money;
    private String filePath;
    private Long inputUserId;
}
