package com.insurance.business.controller;

import com.insurance.business.service.FileService;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public ResultEntity<String> uploadFile(MultipartFile file) throws Exception {
        return result(file,fileService::upload);
    }

}
