package com.insurance.business.service.impl;

import com.insurance.business.mapper.CustomerModelMapper;
import com.insurance.business.model.CustomerModel;
import com.insurance.business.model.CustomerModelExample;
import com.insurance.business.service.CustomerService;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CustomerServiceImpl
        extends BaseServiceImpl<CustomerModel, CustomerModelMapper, CustomerModelExample>
        implements CustomerService {

    @Resource
    @Override
    public void setMapper(CustomerModelMapper mapper) {
        super.setMapper(mapper);
    }

}
