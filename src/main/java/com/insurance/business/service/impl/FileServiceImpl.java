package com.insurance.business.service.impl;

import com.insurance.business.constant.FileConstant;
import com.insurance.business.model.InsuranceModel;
import com.insurance.business.model.PolicyModel;
import com.insurance.business.service.FileService;
import com.insurance.business.service.InsuranceService;
import com.insurance.business.service.PolicyService;
import com.springboot.simple.exception.BusinessException;
import com.springboot.simple.res.ResultEntity;
import com.springboot.simple.support.util.RandomUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Service
public class FileServiceImpl implements FileService {

    @Resource
    private PolicyService policyService;

    @Resource
    private InsuranceService insuranceService;

    @Override
    public ResultEntity<String> upload(MultipartFile file) throws IOException {
        String filePath = FilenameUtils.concat(FileConstant.INSURANCE_FILE_PATH,
                RandomUtils.randomStr(16) + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
        file.transferTo(new File(filePath));
        return ResultEntity.success(filePath);
    }

    @Override
    public File downloadPolicyByAccessKey(Long accessKey) {
        PolicyModel policyModel = policyService.selectByAccessKey(accessKey);
        if (Objects.isNull(policyModel)) {
            throw new BusinessException(500,"文件不存在");
        }
        return FileUtils.getFile(policyModel.getFilePath());
    }

    @Override
    public File downloadInsuranceByAccessKey(Long accessKey) {
        InsuranceModel insuranceModel = insuranceService.selectByAccessKey(accessKey);
        if (Objects.isNull(insuranceModel)) {
            throw new BusinessException(500,"文件不存在");
        }
        return FileUtils.getFile(insuranceModel.getFilePath());
    }
}
