package com.insurance.business.service.impl;

import com.insurance.business.mapper.PolicyModelMapper;
import com.insurance.business.model.PolicyModel;
import com.insurance.business.model.PolicyModelExample;
import com.insurance.business.service.PolicyService;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PolicyServiceImpl
        extends BaseServiceImpl<PolicyModel, PolicyModelMapper, PolicyModelExample>
        implements PolicyService {

    @Resource
    @Override
    public void setMapper(PolicyModelMapper mapper) {
        super.setMapper(mapper);
        super.setModelSupplier(PolicyModel::new);
        super.setExampleSupplier(PolicyModelExample::new);
    }
}
