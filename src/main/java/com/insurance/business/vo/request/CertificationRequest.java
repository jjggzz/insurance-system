package com.insurance.business.vo.request;


import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 认证请求体
 */
@Data
public class CertificationRequest {
    private String name;
    private String birthday;
    private String identityNumber;
    private MultipartFile identityPositive;
    private MultipartFile identityReverse;
    private MultipartFile takeIdentityImage;
}
