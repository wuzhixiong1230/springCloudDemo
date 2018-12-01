package com.oristartech.mybatis.entity;

import javax.persistence.*;

@Table(name = "a8_org")
public class A8org {
    @Id
    @Column(name = "ORG_ID")
    private Long orgId;

    @Column(name = "ORG_NO")
    private String orgNo;

    @Column(name = "ORG_NAME")
    private String orgName;

    @Column(name = "PARENT_ORG_ID")
    private Long parentOrgId;

    @Column(name = "ORDER_NUM")
    private Integer orderNum;

    @Column(name = "ORG_STATUS")
    private String orgStatus;

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
     * @return ORG_NO
     */
    public String getOrgNo() {
        return orgNo;
    }

    /**
     * @param orgNo
     */
    public void setOrgNo(String orgNo) {
        this.orgNo = orgNo;
    }

    /**
     * @return ORG_NAME
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return PARENT_ORG_ID
     */
    public Long getParentOrgId() {
        return parentOrgId;
    }

    /**
     * @param parentOrgId
     */
    public void setParentOrgId(Long parentOrgId) {
        this.parentOrgId = parentOrgId;
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

    /**
     * @return ORG_STATUS
     */
    public String getOrgStatus() {
        return orgStatus;
    }

    /**
     * @param orgStatus
     */
    public void setOrgStatus(String orgStatus) {
        this.orgStatus = orgStatus;
    }
}