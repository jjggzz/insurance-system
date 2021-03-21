package com.insurance.business.mapper;

import com.insurance.business.model.PolicyModel;
import com.insurance.business.model.PolicyModelExample;
import com.springboot.simple.jdbc.mapper.BaseModelMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PolicyModelMapper extends BaseModelMapper<PolicyModel, PolicyModelExample> {

}