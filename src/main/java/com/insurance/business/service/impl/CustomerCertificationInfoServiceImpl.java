package com.insurance.business.service.impl;

import com.insurance.business.mapper.CustomerCertificationInfoModelMapper;
import com.insurance.business.model.CustomerCertificationInfoModel;
import com.insurance.business.model.CustomerCertificationInfoModelExample;
import com.insurance.business.service.CustomerCertificationInfoService;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerCertificationInfoServiceImpl
        extends BaseServiceImpl<CustomerCertificationInfoModel, CustomerCertificationInfoModelMapper, CustomerCertificationInfoModelExample>
        implements CustomerCertificationInfoService {

    @Resource
    @Override
    public void setMapper(CustomerCertificationInfoModelMapper mapper) {
        super.setMapper(mapper);
    }
}
