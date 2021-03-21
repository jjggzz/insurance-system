package com.insurance.business.service;

import com.github.pagehelper.PageInfo;
import com.insurance.business.model.InsuranceModel;
import com.insurance.business.model.InsuranceModelExample;
import com.insurance.business.vo.request.AddInsuranceRequest;
import com.insurance.business.vo.request.GetInsuranceListRequest;
import com.insurance.business.vo.request.UpdateInsuranceRequest;
import com.insurance.business.vo.response.GetInsuranceListResponse;
import com.insurance.business.vo.response.InsuranceAccessKeyAndNameListResponse;
import com.springboot.simple.jdbc.service.BaseService;
import com.springboot.simple.res.ResultEntity;

import java.util.List;

public interface InsuranceService extends BaseService<InsuranceModel, InsuranceModelExample> {

    ResultEntity<Void> addInsurance(AddInsuranceRequest addInsuranceRequest);

    ResultEntity<Void> updateInsurance(UpdateInsuranceRequest updateInsuranceRequest);

    ResultEntity<Void> deleteInsuranceByAccessKey(Long accessKey);

    ResultEntity<PageInfo<GetInsuranceListResponse>> getInsuranceList(GetInsuranceListRequest getInsuranceListRequest);

    InsuranceModel selectByAccessKey(Long accessKey);

    List<InsuranceAccessKeyAndNameListResponse> getAccessKeyAndNameList();
}
