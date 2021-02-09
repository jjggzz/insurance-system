package com.insurance.business.service.impl;

import com.insurance.business.mapper.CustomerCertificationInfoModelMapper;
import com.insurance.business.model.CustomerCertificationInfoModel;
import com.insurance.business.model.CustomerCertificationInfoModelExample;
import com.insurance.business.service.CustomerCertificationInfoService;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CustomerCertificationInfoServiceImpl
        extends BaseServiceImpl<CustomerCertificationInfoModel, CustomerCertificationInfoModelMapper, CustomerCertificationInfoModelExample>
        implements CustomerCertificationInfoService {

    @Resource
    @Override
    public void setMapper(CustomerCertificationInfoModelMapper mapper) {
        super.setMapper(mapper);
    }

    @Override
    public CustomerCertificationInfoModel selectByCustomerId(Long customerId) {
        CustomerCertificationInfoModelExample customerCertificationInfoModelExample = new CustomerCertificationInfoModelExample();
        customerCertificationInfoModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andCustomerIdEqualTo(customerId);
        List<CustomerCertificationInfoModel> list = this.mapper.selectByExample(customerCertificationInfoModelExample);
        return CollectionUtils.isEmpty(list) ? null : list.get(0);
    }
}
