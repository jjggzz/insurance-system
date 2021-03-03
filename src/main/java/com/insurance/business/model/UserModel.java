package com.insurance.business.model;

import com.springboot.simple.jdbc.model.BaseModel;

import java.util.Date;

public class UserModel extends BaseModel {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.id
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.create_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.modified_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Date modifiedTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.deleted
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Boolean deleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.access_key
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Long accessKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.user_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String userName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.login_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String loginName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.phone
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String phone;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.password
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.input_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Date inputTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.rule
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Integer rule;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.identity_number
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String identityNumber;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.address
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user.age
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    private Integer age;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.id
     *
     * @return the value of t_user.id
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.id
     *
     * @param id the value for t_user.id
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.create_time
     *
     * @return the value of t_user.create_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.create_time
     *
     * @param createTime the value for t_user.create_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.modified_time
     *
     * @return the value of t_user.modified_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Date getModifiedTime() {
        return modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.modified_time
     *
     * @param modifiedTime the value for t_user.modified_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.deleted
     *
     * @return the value of t_user.deleted
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Boolean getDeleted() {
        return deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.deleted
     *
     * @param deleted the value for t_user.deleted
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.access_key
     *
     * @return the value of t_user.access_key
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Long getAccessKey() {
        return accessKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.access_key
     *
     * @param accessKey the value for t_user.access_key
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setAccessKey(Long accessKey) {
        this.accessKey = accessKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.user_name
     *
     * @return the value of t_user.user_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.user_name
     *
     * @param userName the value for t_user.user_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.login_name
     *
     * @return the value of t_user.login_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.login_name
     *
     * @param loginName the value for t_user.login_name
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.phone
     *
     * @return the value of t_user.phone
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.phone
     *
     * @param phone the value for t_user.phone
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.password
     *
     * @return the value of t_user.password
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.password
     *
     * @param password the value for t_user.password
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.input_time
     *
     * @return the value of t_user.input_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Date getInputTime() {
        return inputTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.input_time
     *
     * @param inputTime the value for t_user.input_time
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.rule
     *
     * @return the value of t_user.rule
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Integer getRule() {
        return rule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.rule
     *
     * @param rule the value for t_user.rule
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setRule(Integer rule) {
        this.rule = rule;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.identity_number
     *
     * @return the value of t_user.identity_number
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.identity_number
     *
     * @param identityNumber the value for t_user.identity_number
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber == null ? null : identityNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.address
     *
     * @return the value of t_user.address
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.address
     *
     * @param address the value for t_user.address
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.age
     *
     * @return the value of t_user.age
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public Integer getAge() {
        return age;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.age
     *
     * @param age the value for t_user.age
     *
     * @mbggenerated Sun Feb 28 19:30:50 CST 2021
     */
    public void setAge(Integer age) {
        this.age = age;
    }
}