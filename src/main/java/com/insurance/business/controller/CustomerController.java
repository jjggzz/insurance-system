package com.insurance.business.controller;

import com.insurance.business.service.CustomerService;
import com.springboot.simple.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    @GetMapping("test")
    public void test() {
        System.out.println(getRequest());
        System.out.println(customerService);
    }

}
