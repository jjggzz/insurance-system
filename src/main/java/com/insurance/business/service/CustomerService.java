package com.insurance.business.service;

import com.insurance.business.dto.CertificationDto;
import com.insurance.business.model.CustomerModel;
import com.insurance.business.model.CustomerModelExample;
import com.springboot.simple.jdbc.service.BaseService;

import java.io.IOException;

public interface CustomerService extends BaseService<CustomerModel, CustomerModelExample> {

    /**
     * 通过的登陆名查询用户
     * @param loginName
     * @return
     */
    CustomerModel selectByLoginName(String loginName);

    /**
     * 用户注册
     * @param loginName
     * @param password
     * @param phone
     */
    void register(String loginName, String password, String phone);

    /**
     * 登陆
     * @param loginName
     * @param password
     * @return
     */
    CustomerModel login(String loginName, String password);

    /**
     * 提交认证材料
     * @param certificationDto
     */
    void certification(CertificationDto certificationDto) throws IOException;
}
