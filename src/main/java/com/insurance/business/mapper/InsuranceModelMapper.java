package com.insurance.business.mapper;

import com.insurance.business.model.InsuranceModel;
import com.insurance.business.model.InsuranceModelExample;
import com.springboot.simple.jdbc.mapper.BaseModelMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface InsuranceModelMapper extends BaseModelMapper<InsuranceModel, InsuranceModelExample> {

}