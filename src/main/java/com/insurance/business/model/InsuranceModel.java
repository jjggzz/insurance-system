package com.insurance.business.model;

import com.springboot.simple.jdbc.model.BaseModel;

import java.math.BigDecimal;
import java.util.Date;

public class InsuranceModel extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.create_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.modified_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.deleted
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.access_key
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Long accessKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.insurance_name
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private String insuranceName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.insurance_type
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Integer insuranceType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.money
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private BigDecimal money;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.input_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Date inputTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.input_user_id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Long inputUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.status
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_insurance.file_path
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    private String filePath;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.id
     *
     * @return the value of t_insurance.id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.id
     *
     * @param id the value for t_insurance.id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.create_time
     *
     * @return the value of t_insurance.create_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.create_time
     *
     * @param createTime the value for t_insurance.create_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.modified_time
     *
     * @return the value of t_insurance.modified_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.modified_time
     *
     * @param modifiedTime the value for t_insurance.modified_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.deleted
     *
     * @return the value of t_insurance.deleted
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.deleted
     *
     * @param deleted the value for t_insurance.deleted
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.access_key
     *
     * @return the value of t_insurance.access_key
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Long getAccessKey() {
        return accessKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.access_key
     *
     * @param accessKey the value for t_insurance.access_key
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setAccessKey(Long accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.insurance_name
     *
     * @return the value of t_insurance.insurance_name
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public String getInsuranceName() {
        return insuranceName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.insurance_name
     *
     * @param insuranceName the value for t_insurance.insurance_name
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setInsuranceName(String insuranceName) {
        this.insuranceName = insuranceName == null ? null : insuranceName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.insurance_type
     *
     * @return the value of t_insurance.insurance_type
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Integer getInsuranceType() {
        return insuranceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.insurance_type
     *
     * @param insuranceType the value for t_insurance.insurance_type
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setInsuranceType(Integer insuranceType) {
        this.insuranceType = insuranceType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.money
     *
     * @return the value of t_insurance.money
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.money
     *
     * @param money the value for t_insurance.money
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.input_time
     *
     * @return the value of t_insurance.input_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.input_time
     *
     * @param inputTime the value for t_insurance.input_time
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.input_user_id
     *
     * @return the value of t_insurance.input_user_id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Long getInputUserId() {
        return inputUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.input_user_id
     *
     * @param inputUserId the value for t_insurance.input_user_id
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setInputUserId(Long inputUserId) {
        this.inputUserId = inputUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.status
     *
     * @return the value of t_insurance.status
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.status
     *
     * @param status the value for t_insurance.status
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_insurance.file_path
     *
     * @return the value of t_insurance.file_path
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_insurance.file_path
     *
     * @param filePath the value for t_insurance.file_path
     *
     * @mbggenerated Sat Mar 06 16:32:15 CST 2021
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }
}