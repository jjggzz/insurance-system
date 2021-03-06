package com.insurance.business.service.impl;

import com.insurance.business.constant.FileConstant;
import com.insurance.business.service.FileService;
import com.springboot.simple.res.ResultEntity;
import com.springboot.simple.support.util.RandomUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileServiceImpl implements FileService {


    @Override
    public ResultEntity<String> upload(MultipartFile file) throws IOException {
        String filePath = FilenameUtils.concat(FileConstant.INSURANCE_FILE_PATH,
                RandomUtils.randomStr(16) + "." + FilenameUtils.getExtension(file.getOriginalFilename()));
        file.transferTo(new File(filePath));
        return ResultEntity.success(filePath);
    }
}
