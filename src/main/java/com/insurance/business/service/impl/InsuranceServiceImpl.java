package com.insurance.business.service.impl;

import com.insurance.business.mapper.InsuranceModelMapper;
import com.insurance.business.model.InsuranceModel;
import com.insurance.business.model.InsuranceModelExample;
import com.insurance.business.service.InsuranceService;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class InsuranceServiceImpl
        extends BaseServiceImpl<InsuranceModel, InsuranceModelMapper, InsuranceModelExample>
        implements InsuranceService {

    @Resource
    @Override
    public void setMapper(InsuranceModelMapper mapper) {
        super.setMapper(mapper);
        super.setModelSupplier(InsuranceModel::new);
        super.setExampleSupplier(InsuranceModelExample::new);
    }





}
