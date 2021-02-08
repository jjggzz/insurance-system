package com.insurance.business.mapper;

import com.insurance.business.model.CustomerCertificationInfoModel;
import com.insurance.business.model.CustomerCertificationInfoModelExample;
import com.springboot.simple.jdbc.mapper.BaseModelMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerCertificationInfoModelMapper extends BaseModelMapper<CustomerCertificationInfoModel, CustomerCertificationInfoModelExample> {

}