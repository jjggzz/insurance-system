package com.insurance.business.mapper;

import com.insurance.business.model.UserModel;
import com.insurance.business.model.UserModelExample;
import com.springboot.simple.jdbc.mapper.BaseModelMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserModelMapper extends BaseModelMapper<UserModel, UserModelExample> {

}