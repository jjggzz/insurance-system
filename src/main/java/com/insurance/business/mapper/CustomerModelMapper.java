package com.insurance.business.mapper;

import com.insurance.business.model.CustomerModel;
import com.insurance.business.model.CustomerModelExample;
import com.springboot.simple.jdbc.mapper.BaseModelMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerModelMapper extends BaseModelMapper<CustomerModel,CustomerModelExample> {

}