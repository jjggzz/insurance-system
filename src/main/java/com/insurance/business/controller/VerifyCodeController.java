package com.insurance.business.controller;

import com.insurance.business.constant.VerifyConstant;
import com.insurance.utils.SessionUtils;
import com.insurance.utils.VerifyImageUtils;
import com.springboot.simple.controller.BaseController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class VerifyCodeController extends BaseController {

    /**
     * 获取验证码,并设置到session
     * @throws IOException
     */
    @GetMapping("/getImage")
    public void getImage() throws IOException {
        VerifyImageUtils.ImageVerificationCode oneImage = VerifyImageUtils.getOneImage();
        HttpServletResponse response = getResponse();
        SessionUtils.setValue(getRequest(),VerifyConstant.VERIFY_KEY,oneImage.getText());
        oneImage.output(response.getOutputStream());
    }

}
