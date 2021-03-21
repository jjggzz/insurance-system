package com.insurance.business.vo.request;

import com.insurance.utils.page.Page;
import lombok.Data;

import java.util.Date;

@Data
public class GetPolicyListRequest extends Page {
    private Integer rule;
    private String userName;
    private Date startTime;
    private Date endTime;
}
