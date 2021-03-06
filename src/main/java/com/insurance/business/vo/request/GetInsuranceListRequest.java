package com.insurance.business.vo.request;

import com.insurance.utils.page.Page;
import lombok.Data;

import java.util.Date;

@Data
public class GetInsuranceListRequest extends Page {
    private String insuranceName;
    private Integer insuranceType;
    private Integer status;
    private Date startTime;
    private Date endTime;
}
