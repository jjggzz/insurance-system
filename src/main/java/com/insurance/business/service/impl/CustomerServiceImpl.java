package com.insurance.business.service.impl;

import com.insurance.business.constant.CustomerConstant;
import com.insurance.business.constant.FileConstant;
import com.insurance.business.dto.CertificationDto;
import com.insurance.business.mapper.CustomerModelMapper;
import com.insurance.business.model.CustomerCertificationInfoModel;
import com.insurance.business.model.CustomerModel;
import com.insurance.business.model.CustomerModelExample;
import com.insurance.business.service.CustomerCertificationInfoService;
import com.insurance.business.service.CustomerService;
import com.insurance.utils.IdUtils;
import com.springboot.simple.exception.BusinessException;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
public class CustomerServiceImpl
        extends BaseServiceImpl<CustomerModel, CustomerModelMapper, CustomerModelExample>
        implements CustomerService {

    @Resource
    private CustomerCertificationInfoService customerCertificationInfoService;

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

    @Transactional
    @Override
    public CustomerModel certification(CertificationDto certificationDto) throws IOException {
        // 身份证正面存储路径
        String identityPositivePath = FilenameUtils.concat(FileConstant.IDENTITY_POSITIVE_PATH,
                IdUtils.getInstance().nextId() + "." + FilenameUtils.getExtension(certificationDto.getIdentityPositive().getOriginalFilename()));
        // 身份证反面存储路径
        String identityReversePath = FilenameUtils.concat(FileConstant.IDENTITY_REVERSE_PATH,
                IdUtils.getInstance().nextId() + "." + FilenameUtils.getExtension(certificationDto.getIdentityReverse().getOriginalFilename()));
        // 手持身份证图片存储路径
        String takeIdentityImagePath = FilenameUtils.concat(FileConstant.TAKE_IDENTITY_IMAGE_PATH,
                IdUtils.getInstance().nextId() + "." + FilenameUtils.getExtension(certificationDto.getTakeIdentityImage().getOriginalFilename()));
        CustomerCertificationInfoModel dbCCI = customerCertificationInfoService.selectByCustomerId(certificationDto.getCustomerId());

        if (Objects.isNull(dbCCI)) {
            CustomerCertificationInfoModel customerCertificationInfoModel = new CustomerCertificationInfoModel();
            BeanUtils.copyProperties(certificationDto,customerCertificationInfoModel,"identityPositive","identityReverse","takeIdentityImage");
            customerCertificationInfoModel.setAccessKey(IdUtils.getInstance().nextId());
            customerCertificationInfoModel.setIdentityPositive(identityPositivePath);
            customerCertificationInfoModel.setIdentityReverse(identityReversePath);
            customerCertificationInfoModel.setTakeIdentityImage(takeIdentityImagePath);
            customerCertificationInfoService.insert(customerCertificationInfoModel);
        } else {
            BeanUtils.copyProperties(certificationDto,dbCCI,"identityPositive","identityReverse","takeIdentityImage");
            dbCCI.setIdentityPositive(identityPositivePath);
            dbCCI.setIdentityReverse(identityReversePath);
            dbCCI.setTakeIdentityImage(takeIdentityImagePath);
            customerCertificationInfoService.update(dbCCI);
        }
        CustomerModel customerModel = selectByPrimaryKey(certificationDto.getCustomerId());
        customerModel.setCertification(CustomerConstant.CERTIFICATION_1);
        update(customerModel);

        FileUtils.copyToFile(certificationDto.getIdentityPositive().getInputStream(),new File(identityPositivePath));
        FileUtils.copyToFile(certificationDto.getIdentityPositive().getInputStream(),new File(identityReversePath));
        FileUtils.copyToFile(certificationDto.getIdentityPositive().getInputStream(),new File(takeIdentityImagePath));
        return customerModel;
    }

}
