package com.insurance.business.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * 认证数据传输对象
 */
@Data
public class CertificationDto {
    private Long customerId;
    private String name;
    private Date birthday;
    private String identityNumber;
    private MultipartFile identityPositive;
    private MultipartFile identityReverse;
    private MultipartFile takeIdentityImage;
}
