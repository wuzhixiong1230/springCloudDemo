package com.oristartech.mybatis.entity;

import javax.persistence.*;

@Table(name = "a8_user")
public class A8user {
    @Id
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "USER_NAME")
    private String userName;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    /**
     * @return USER_ID
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return ACCOUNT
     */
    public String getAccount() {
        return account;
    }

    /**
     * @param account
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * @return USER_NAME
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return USER_STATUS
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return ORG_ID
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * @return ORDER_NUM
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * @param orderNum
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}