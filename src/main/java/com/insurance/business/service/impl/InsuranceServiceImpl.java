package com.insurance.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.business.mapper.InsuranceModelMapper;
import com.insurance.business.model.InsuranceModel;
import com.insurance.business.model.InsuranceModelExample;
import com.insurance.business.service.InsuranceService;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddInsuranceRequest;
import com.insurance.business.vo.request.GetInsuranceListRequest;
import com.insurance.business.vo.request.UpdateInsuranceRequest;
import com.insurance.business.vo.response.GetInsuranceListResponse;
import com.insurance.utils.IdUtils;
import com.springboot.simple.jdbc.service.impl.BaseServiceImpl;
import com.springboot.simple.res.ResultEntity;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImpl
        extends BaseServiceImpl<InsuranceModel, InsuranceModelMapper, InsuranceModelExample>
        implements InsuranceService {

    @Resource
    private UserService userService;

    @Resource
    @Override
    public void setMapper(InsuranceModelMapper mapper) {
        super.setMapper(mapper);
        super.setModelSupplier(InsuranceModel::new);
        super.setExampleSupplier(InsuranceModelExample::new);
    }

    @Override
    public ResultEntity<Void> addInsurance(AddInsuranceRequest addInsuranceRequest) {
        InsuranceModel insuranceModel = newModel();
        BeanUtils.copyProperties(addInsuranceRequest,insuranceModel);
        insuranceModel.setAccessKey(IdUtils.getInstance().nextId());
        insuranceModel.setInputTime(new Date());
        insert(insuranceModel);
        LOGGER.warn("{} 添加保险,添加人主键: id = {}","addInsurance",addInsuranceRequest.getInputUserId());
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> updateInsurance(UpdateInsuranceRequest updateInsuranceRequest) {
        InsuranceModelExample insuranceModelExample = newExample();
        insuranceModelExample.createCriteria()
                .andAccessKeyEqualTo(updateInsuranceRequest.getAccessKey());
        List<InsuranceModel> insuranceModels = selectByExample(insuranceModelExample);
        if (CollectionUtils.isEmpty(insuranceModels)) {
            return ResultEntity.failure("保险不存在");
        }
        InsuranceModel insuranceModel = insuranceModels.get(0);
        BeanUtils.copyProperties(updateInsuranceRequest,insuranceModel);
        update(insuranceModel);
        LOGGER.warn("{} 修改保险,accessKey = {}","updateInsurance",insuranceModel.getAccessKey());
        return null;
    }

    @Override
    public ResultEntity<Void> deleteInsuranceByAccessKey(Long accessKey) {
        InsuranceModelExample insuranceModelExample = newExample();
        insuranceModelExample.createCriteria()
                .andAccessKeyEqualTo(accessKey);
        List<InsuranceModel> insuranceModels = selectByExample(insuranceModelExample);
        if (CollectionUtils.isEmpty(insuranceModels)) {
            return ResultEntity.failure("该保险不存在");
        }
        InsuranceModel insuranceModel = insuranceModels.get(0);
        LOGGER.warn("{} 删除保险,accessKey = {}","deleteInsuranceByAccessKey",insuranceModel.getAccessKey());
        delete(insuranceModel.getId());

        return ResultEntity.success();
    }

    @Override
    public ResultEntity<PageInfo<GetInsuranceListResponse>> getInsuranceList(GetInsuranceListRequest getInsuranceListRequest) {
        Page<InsuranceModel> insuranceModels = PageHelper.startPage(getInsuranceListRequest.getPageNum(), getInsuranceListRequest.getPageSize());
        InsuranceModelExample insuranceModelExample = newExample();
        InsuranceModelExample.Criteria criteria = insuranceModelExample.createCriteria()
                .andDeletedEqualTo(false);

        if (StringUtils.isNotBlank(getInsuranceListRequest.getInsuranceName())) {
            criteria.andInsuranceNameLike("%" + getInsuranceListRequest.getInsuranceName() + "%");
        }
        if (Objects.nonNull(getInsuranceListRequest.getInsuranceType())) {
            criteria.andInsuranceTypeEqualTo(getInsuranceListRequest.getInsuranceType());
        }
        if (Objects.nonNull(getInsuranceListRequest.getStartTime())) {
            criteria.andInputTimeGreaterThanOrEqualTo(getInsuranceListRequest.getStartTime());
        }
        if (Objects.nonNull(getInsuranceListRequest.getEndTime())) {
            criteria.andInputTimeLessThanOrEqualTo(getInsuranceListRequest.getEndTime());
        }
        selectByExample(insuranceModelExample);

        List<GetInsuranceListResponse> list = insuranceModels.stream().map(insuranceModel -> {
            GetInsuranceListResponse getInsuranceListResponse = new GetInsuranceListResponse();
            BeanUtils.copyProperties(insuranceModel, getInsuranceListResponse);
            getInsuranceListResponse.setInputUserName(userService.selectByPrimaryKey(insuranceModel.getId()).getUserName());
            return getInsuranceListResponse;
        }).collect(Collectors.toList());


        PageInfo<GetInsuranceListResponse> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(insuranceModels.getPageNum());
        pageInfo.setPageSize(insuranceModels.getPageSize());
        pageInfo.setTotal(insuranceModels.getTotal());
        return ResultEntity.success(pageInfo);
    }
}
