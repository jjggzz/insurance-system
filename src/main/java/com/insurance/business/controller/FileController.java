package com.insurance.business.controller;

import com.insurance.business.service.FileService;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

@RestController
@RequestMapping("file")
public class FileController extends BaseController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public ResultEntity<String> uploadFile(MultipartFile file) throws Exception {
        return result(file,fileService::upload);
    }

    @GetMapping("/download/policy/{accessKey}")
    public void downloadPolicy(@PathVariable("accessKey")Long accessKey) throws Exception {
        File file = fileService.downloadPolicyByAccessKey(accessKey);
        FileUtils.copyFile(file,getResponse().getOutputStream());
    }

    @GetMapping("/download/insurance/{accessKey}")
    public void downloadInsurance(@PathVariable("accessKey")Long accessKey) throws Exception {
        File file = fileService.downloadInsuranceByAccessKey(accessKey);
        FileUtils.copyFile(file,getResponse().getOutputStream());
    }

}
