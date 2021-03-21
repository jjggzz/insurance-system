package com.insurance.business.vo.request;

import lombok.Data;

@Data
public class AddPolicyRequest {
    private String policyName;
    private Long insureUserAccessKey;
    private Long benefitUserAccessKey;
    private Long insuranceAccessKey;
    private Integer duration;
    private String filePath;
}
