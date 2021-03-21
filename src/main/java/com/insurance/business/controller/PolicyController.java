package com.insurance.business.controller;

import com.insurance.business.service.PolicyService;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("policy")
public class PolicyController extends BaseController {

    @Resource
    private PolicyService policyService;


    @PostMapping("/list")
    public ResultEntity<?> getPolicyList() throws Exception {
        return null;
    }

}
