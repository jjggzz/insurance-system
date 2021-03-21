package com.insurance.business.service;

import com.github.pagehelper.PageInfo;
import com.insurance.business.model.PolicyModel;
import com.insurance.business.model.PolicyModelExample;
import com.insurance.business.vo.request.AddPolicyRequest;
import com.insurance.business.vo.request.GetPolicyListRequest;
import com.insurance.business.vo.request.UpdatePolicyRequest;
import com.insurance.business.vo.response.GetPolicyListResponse;
import com.springboot.simple.jdbc.service.BaseService;
import com.springboot.simple.res.ResultEntity;

public interface PolicyService extends BaseService<PolicyModel, PolicyModelExample> {


    ResultEntity<PageInfo<GetPolicyListResponse>> getPolicyList(GetPolicyListRequest getPolicyListRequest);

    ResultEntity<Void> addPolicy(AddPolicyRequest addPolicyRequest);

    ResultEntity<Void> deletePolicyByAccessKey(Long accessKey);

    ResultEntity<Void> updatePolicy(UpdatePolicyRequest updatePolicyRequest);

    PolicyModel selectByAccessKey(Long accessKey);
}
