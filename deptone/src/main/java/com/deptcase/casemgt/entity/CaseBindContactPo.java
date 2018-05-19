package com.deptcase.casemgt.entity;

/**
 * @description: 联系人案件绑定表
 * @projectName:casemgt
 * @className:CaseBindContactPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午12:41:12
 * @version 1.0
 */
public class CaseBindContactPo {
    private Long id;

    private Long lastAccess;

    private Long caseId;				//案件id

    private String contactDcid;			//联系人证件号码

    private Integer bindType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Long getCaseId() {
        return caseId;
    }

    public void setCaseId(Long caseId) {
        this.caseId = caseId;
    }

    public String getContactDcid() {
        return contactDcid;
    }

    public void setContactDcid(String contactDcid) {
        this.contactDcid = contactDcid == null ? null : contactDcid.trim();
    }

    public Integer getBindType() {
        return bindType;
    }

    public void setBindType(Integer bindType) {
        this.bindType = bindType;
    }
}