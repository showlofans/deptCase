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
    
    public CaseBindContactPo(Long lastAccess, Long caseId, String contactDcid,
			Integer bindType) {
		super();
		this.lastAccess = lastAccess;
		this.caseId = caseId;
		this.contactDcid = contactDcid;
		this.bindType = bindType;
	}

	public CaseBindContactPo() {
		super();
		// TODO Auto-generated constructor stub
	}

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