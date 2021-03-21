package com.insurance.business.controller;

import com.github.pagehelper.PageInfo;
import com.insurance.business.service.PolicyService;
import com.insurance.business.vo.request.AddPolicyRequest;
import com.insurance.business.vo.request.GetPolicyListRequest;
import com.insurance.business.vo.request.UpdatePolicyRequest;
import com.insurance.business.vo.response.GetPolicyListResponse;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("policy")
public class PolicyController extends BaseController {

    @Resource
    private PolicyService policyService;

    @PostMapping("/add")
    public ResultEntity<Void> addPolicy(@RequestBody AddPolicyRequest addPolicyRequest) throws Exception {
        return result(addPolicyRequest,policyService::addPolicy);
    }

    @PostMapping("/delete/{accessKey}")
    public ResultEntity<Void> deletePolicy(@PathVariable("accessKey") Long accessKey) throws Exception {
        return result(accessKey,policyService::deletePolicyByAccessKey);
    }

    @PutMapping("/update")
    public ResultEntity<Void> updatePolicy(@RequestBody UpdatePolicyRequest updatePolicyRequest) throws Exception {
        return result(updatePolicyRequest,policyService::updatePolicy);
    }


    @PostMapping("/list")
    public ResultEntity<PageInfo<GetPolicyListResponse>> getPolicyList(@RequestBody GetPolicyListRequest getPolicyListRequest) throws Exception {
        return result(getPolicyListRequest,policyService::getPolicyList);
    }



}
