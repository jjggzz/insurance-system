package com.insurance.business.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.insurance.business.mapper.PolicyModelMapper;
import com.insurance.business.model.*;
import com.insurance.business.service.InsuranceService;
import com.insurance.business.service.PolicyService;
import com.insurance.business.service.UserService;
import com.insurance.business.vo.request.AddPolicyRequest;
import com.insurance.business.vo.request.GetPolicyListRequest;
import com.insurance.business.vo.request.UpdatePolicyRequest;
import com.insurance.business.vo.response.GetPolicyListResponse;
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
public class PolicyServiceImpl
        extends BaseServiceImpl<PolicyModel, PolicyModelMapper, PolicyModelExample>
        implements PolicyService {

    @Resource
    private UserService userService;

    @Resource
    private InsuranceService insuranceService;

    @Resource
    @Override
    public void setMapper(PolicyModelMapper mapper) {
        super.setMapper(mapper);
        super.setModelSupplier(PolicyModel::new);
        super.setExampleSupplier(PolicyModelExample::new);
    }

    @Override
    public ResultEntity<Void> addPolicy(AddPolicyRequest addPolicyRequest) {
        UserModel insureUser = userService.selectByAccessKey(addPolicyRequest.getInsureUserAccessKey());
        UserModel benefitUser = userService.selectByAccessKey(addPolicyRequest.getBenefitUserAccessKey());
        InsuranceModel insuranceModel = insuranceService.selectByAccessKey(addPolicyRequest.getInsuranceAccessKey());
        // 校验数据
        if (Objects.isNull(insureUser)) {
            return ResultEntity.failure("投保人不存在");
        }
        if (Objects.isNull(benefitUser)) {
            return ResultEntity.failure("受益人不存在");
        }
        if (Objects.isNull(insuranceModel)) {
            return ResultEntity.failure("该保险不存在");
        }
        PolicyModel policyModel = newModel();
        BeanUtils.copyProperties(addPolicyRequest,policyModel);
        policyModel.setAccessKey(IdUtils.getInstance().nextId());
        policyModel.setInputTime(new Date());
        policyModel.setInsureUserId(insureUser.getId());
        policyModel.setBenefitUserId(benefitUser.getId());
        policyModel.setInsuranceId(insuranceModel.getId());
        insert(policyModel);
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> deletePolicyByAccessKey(Long accessKey) {
        PolicyModelExample policyModelExample = newExample();
        policyModelExample.createCriteria()
                .andAccessKeyEqualTo(accessKey);
        List<PolicyModel> policyModels = selectByExample(policyModelExample);
        if (CollectionUtils.isEmpty(policyModels)) {
            return ResultEntity.failure("该保单不存在");
        }

        PolicyModel policyModel = policyModels.get(0);
        delete(policyModel.getId());
        LOGGER.warn("{} 删除保单,accessKey = {}","deletePolicyByAccessKey",policyModel.getAccessKey());
        return ResultEntity.success();
    }

    @Override
    public ResultEntity<Void> updatePolicy(UpdatePolicyRequest updatePolicyRequest) {
        PolicyModelExample policyModelExample = newExample();
        policyModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andAccessKeyEqualTo(updatePolicyRequest.getAccessKey());
        List<PolicyModel> policyModels = selectByExample(policyModelExample);
        if (CollectionUtils.isEmpty(policyModels)){
            return ResultEntity.failure("该保单不存在");
        }
        PolicyModel policyModel = policyModels.get(0);

        BeanUtils.copyProperties(updatePolicyRequest,policyModel);
        UserModel insureUser = userService.selectByAccessKey(updatePolicyRequest.getInsureUserAccessKey());
        UserModel benefitUser = userService.selectByAccessKey(updatePolicyRequest.getBenefitUserAccessKey());
        InsuranceModel insuranceModel = insuranceService.selectByAccessKey(updatePolicyRequest.getInsuranceAccessKey());
        policyModel.setInsureUserId(insureUser.getId());
        policyModel.setBenefitUserId(benefitUser.getId());
        policyModel.setInsuranceId(insuranceModel.getId());
        update(policyModel);
        return ResultEntity.success();
    }

    @Override
    public PolicyModel selectByAccessKey(Long accessKey) {
        PolicyModelExample policyModelExample = newExample();
        policyModelExample.createCriteria()
                .andDeletedEqualTo(false)
                .andAccessKeyEqualTo(accessKey);
        List<PolicyModel> policyModels = selectByExample(policyModelExample);
        return CollectionUtils.isEmpty(policyModels)? null : policyModels.get(0);
    }

    @Override
    public ResultEntity<PageInfo<GetPolicyListResponse>> getPolicyList(GetPolicyListRequest getPolicyListRequest) {
        Page<PolicyModel> policyModels = PageHelper.startPage(getPolicyListRequest.getPageNum(), getPolicyListRequest.getPageSize());
        PolicyModelExample policyModelExample = newExample();
        PolicyModelExample.Criteria criteria = policyModelExample.createCriteria()
                .andDeletedEqualTo(false);

        if (StringUtils.isNotBlank(getPolicyListRequest.getPolicyName())) {
            criteria.andPolicyNameLike("%" + getPolicyListRequest.getPolicyName() + "%");
        }
        if (Objects.nonNull(getPolicyListRequest.getStartTime())) {
            criteria.andInputTimeGreaterThanOrEqualTo(getPolicyListRequest.getStartTime());
        }
        if (Objects.nonNull(getPolicyListRequest.getEndTime())) {
            criteria.andInputTimeLessThanOrEqualTo(getPolicyListRequest.getEndTime());
        }

        selectByExample(policyModelExample);
        List<GetPolicyListResponse> list = policyModels.stream().map(policyModel -> {
            GetPolicyListResponse getPolicyListResponse = new GetPolicyListResponse();
            BeanUtils.copyProperties(policyModel,getPolicyListResponse);
            UserModel insureUser = userService.selectByPrimaryKey(policyModel.getInsureUserId());
            UserModel benefitUser = userService.selectByPrimaryKey(policyModel.getBenefitUserId());
            InsuranceModel insuranceModel = insuranceService.selectByPrimaryKey(policyModel.getInsuranceId());

            getPolicyListResponse.setBenefitUserAccessKey(benefitUser.getAccessKey());
            getPolicyListResponse.setBenefitUserName(benefitUser.getUserName());
            getPolicyListResponse.setInsureUserAccessKey(insureUser.getAccessKey());
            getPolicyListResponse.setInsureUserName(insureUser.getUserName());
            getPolicyListResponse.setInsuranceAccessKey(insuranceModel.getAccessKey());
            getPolicyListResponse.setInsuranceName(insuranceModel.getInsuranceName());

            return getPolicyListResponse;
        }).collect(Collectors.toList());

        PageInfo<GetPolicyListResponse> pageInfo = new PageInfo<>(list);
        pageInfo.setPageNum(policyModels.getPageNum());
        pageInfo.setPageSize(policyModels.getPageSize());
        pageInfo.setTotal(policyModels.getTotal());
        return ResultEntity.success(pageInfo);
    }
}
