package com.insurance.business.service;

import com.springboot.simple.res.ResultEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    ResultEntity<String> upload(MultipartFile file) throws IOException;

}
