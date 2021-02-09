package com.insurance.business.controller;

import com.insurance.business.constant.CustomerConstant;
import com.insurance.business.constant.VerifyConstant;
import com.insurance.business.dto.CertificationDto;
import com.insurance.business.model.CustomerModel;
import com.insurance.business.service.CustomerService;
import com.insurance.business.vo.request.CertificationRequest;
import com.insurance.business.vo.request.LoginRequest;
import com.insurance.business.vo.request.RegisterRequest;
import com.insurance.business.vo.response.LoginResponse;
import com.insurance.utils.SessionUtils;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import com.springboot.simple.support.util.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Objects;

@RestController
@RequestMapping("customer")
public class CustomerController extends BaseController {

    @Resource
    private CustomerService customerService;

    /**
     * 注册
     * @param registerRequest
     */
    @PostMapping("/register")
    public ResultEntity<Void> register(@RequestBody RegisterRequest registerRequest) {
        // 校验验证码
        String sessionVerify = (String) SessionUtils.getValue(getRequest(), VerifyConstant.VERIFY_KEY);
        if (Objects.isNull(sessionVerify) || !sessionVerify.equals(registerRequest.getVerifyCode())) {
            return ResultEntity.failure("验证码错误");
        }
        CustomerModel customerModel = customerService.selectByLoginName(registerRequest.getLoginName());
        if (Objects.nonNull(customerModel)) {
            return ResultEntity.failure("用户已存在");
        }
        customerService.register(registerRequest.getLoginName(),registerRequest.getPassword(),registerRequest.getPhone());
        return ResultEntity.success();
    }

    /**
     * 登陆
     * @param loginRequest
     * @return
     */
    @PostMapping("/login")
    public ResultEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        // 校验验证码
        String sessionVerify = (String) SessionUtils.getValue(getRequest(), VerifyConstant.VERIFY_KEY);
        if (Objects.isNull(sessionVerify) || !sessionVerify.equals(loginRequest.getVerifyCode())) {
            return ResultEntity.failure("验证码错误");
        }
        CustomerModel customerModel = customerService.login(loginRequest.getLoginName(),loginRequest.getPassword());
        SessionUtils.setValue(getRequest(), CustomerConstant.CUSTOMER_INFO,customerModel);
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setCustomerName(customerModel.getCustomerName());
        return ResultEntity.success(loginResponse);
    }

    /**
     * 登出
     * @return
     */
    @PostMapping("/logout")
    public ResultEntity<LoginResponse> logout() {
        SessionUtils.removeValue(getRequest(), CustomerConstant.CUSTOMER_INFO);
        return ResultEntity.success();
    }

    /**
     * 提交认证材料
     * @param certificationRequest
     * @return
     */
    @PostMapping("/certification")
    public ResultEntity<Void> certification(CertificationRequest certificationRequest) throws IOException {
        CustomerModel value = (CustomerModel) SessionUtils.getValue(getRequest(), CustomerConstant.CUSTOMER_INFO);
        if (Objects.isNull(value)) {
            return ResultEntity.failure("用户未登陆");
        }
        if (CustomerConstant.CERTIFICATION_2 == value.getCertification()) {
            return ResultEntity.failure("您已认证");
        }
        CertificationDto certificationDto = new CertificationDto();
        BeanUtils.copyProperties(certificationRequest,certificationDto,"birthday");
        certificationDto.setCustomerId(value.getId());
        certificationDto.setBirthday(DateUtils.detailDateParseToDate(certificationRequest.getBirthday()));
        // 认证
        CustomerModel certification = customerService.certification(certificationDto);
        SessionUtils.setValue(getRequest(), CustomerConstant.CUSTOMER_INFO,certification);

        return ResultEntity.success();
    }

}
