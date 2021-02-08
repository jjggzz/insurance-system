package com.insurance.business.service.impl;

import com.insurance.business.mapper.CustomerModelMapper;
import com.insurance.business.model.CustomerModel;
import com.insurance.business.model.CustomerModelExample;
import com.insurance.business.service.CustomerService;
import com.insurance.utils.IdUtils;
import com.springboot.simple.exception.BusinessException;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl
        extends BaseServiceImpl<CustomerModel, CustomerModelMapper, CustomerModelExample>
        implements CustomerService {

    @Resource
    @Override
    public void setMapper(CustomerModelMapper mapper) {
        super.setMapper(mapper);
    }

    @Override
    public CustomerModel selectByLoginName(String loginName) {
        CustomerModelExample customerModelExample = new CustomerModelExample();
        customerModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andLoginNameEqualTo(loginName);
        List<CustomerModel> customerModels = this.mapper.selectByExample(customerModelExample);
        return CollectionUtils.isEmpty(customerModels) ? null : customerModels.get(0);
    }

    @Override
    public void register(String loginName, String password, String phone) {
        CustomerModel customerModel = new CustomerModel();
        customerModel.setAccessKey(IdUtils.getInstance().nextId());
        customerModel.setLoginName(loginName);
        customerModel.setCustomerName(loginName);
        customerModel.setPassword(password);
        customerModel.setPhone(phone);
        insert(customerModel);
    }

    @Override
    public CustomerModel login(String loginName, String password) {
        CustomerModel customerModel = selectByLoginName(loginName);
        if (Objects.isNull(customerModel)) {
            throw new BusinessException(-1,"用户不存在");
        }
        if (!customerModel.getPassword().equals(password)) {
            throw new BusinessException(-1,"密码错误");
        }
        return customerModel;
    }
}
