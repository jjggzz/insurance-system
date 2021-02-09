package com.insurance.business.service;

import com.insurance.business.model.CustomerCertificationInfoModel;
import com.insurance.business.model.CustomerCertificationInfoModelExample;
import com.springboot.simple.jdbc.service.BaseService;

public interface CustomerCertificationInfoService extends BaseService<CustomerCertificationInfoModel, CustomerCertificationInfoModelExample> {

    /**
     * 通过用户id查询认证材料
     * @param customerId
     * @return
     */
    CustomerCertificationInfoModel selectByCustomerId(Long customerId);

}
