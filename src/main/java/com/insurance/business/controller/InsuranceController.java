package com.insurance.business.controller;

import com.github.pagehelper.PageInfo;
import com.insurance.business.constant.UserConstant;
import com.insurance.business.model.UserModel;
import com.insurance.business.service.InsuranceService;
import com.insurance.business.vo.request.AddInsuranceRequest;
import com.insurance.business.vo.request.GetInsuranceListRequest;
import com.insurance.business.vo.request.UpdateInsuranceRequest;
import com.insurance.business.vo.response.GetInsuranceListResponse;
import com.insurance.utils.SessionUtils;
import com.springboot.simple.controller.BaseController;
import com.springboot.simple.res.ResultEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 保险管理
 */
@RequestMapping("insurance")
@RestController
public class InsuranceController extends BaseController {

    @Resource
    private InsuranceService insuranceService;

    /**
     * 添加保险
     * @param addInsuranceRequest
     * @return
     * @throws Exception
     */
    @PostMapping("/add")
    public ResultEntity<Void> addInsurance(@RequestBody AddInsuranceRequest addInsuranceRequest) throws Exception {
        UserModel userInfo = (UserModel) SessionUtils.getValue(getRequest(), UserConstant.USER_INFO);
        addInsuranceRequest.setInputUserId(userInfo.getId());
        return result(addInsuranceRequest,insuranceService::addInsurance);
    }

    /**
     * 修改保险
     * @param updateInsuranceRequest
     * @return
     * @throws Exception
     */
    @PutMapping("/update")
    public ResultEntity<Void> updateInsurance(@RequestBody UpdateInsuranceRequest updateInsuranceRequest) throws Exception {
        return result(updateInsuranceRequest,insuranceService::updateInsurance);
    }

    /**
     * 删除保险
     * @param accessKey
     * @return
     * @throws Exception
     */
    @DeleteMapping("/delete/{accessKey}")
    public ResultEntity<Void> deleteInsurance(@PathVariable("accessKey") Long accessKey) throws Exception {
        return result(accessKey,insuranceService::deleteInsuranceByAccessKey);
    }

    /**
     * 分页查询保险信息
     * @param getInsuranceListRequest
     * @return
     * @throws Exception
     */
    @GetMapping("/list")
    public ResultEntity<PageInfo<GetInsuranceListResponse>> getInsuranceList(@RequestBody GetInsuranceListRequest getInsuranceListRequest) throws Exception {
        return result(getInsuranceListRequest,insuranceService::getInsuranceList);
    }




}
