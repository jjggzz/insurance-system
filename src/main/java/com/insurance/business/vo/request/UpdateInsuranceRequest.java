package com.insurance.business.vo.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateInsuranceRequest {
    private Long accessKey;
    private String insuranceName;
    private Integer insuranceType;
    private BigDecimal money;
    private String filePath;
}
