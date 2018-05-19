package com.deptcase.casemgt.entity;

import java.util.List;

/**
 * @description: 债务案件
 * @projectName:deptone
 * @className:DeptCase.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月12日 上午10:53:07
 * @version 1.0
 */

public class DeptCasePo {
	
    private Integer id;

    private Long deptDate;					//贷款日期

    private Long deptEndDate;				//到期日期

    private Double deptAmount;				//贷款金额

    private Double deptBalance;				//贷款余额

    private Double deptProfit;				//结欠利息

    private String dcId;					//证件号码

    private String caseOrg;					//机构名称

    private String customerContact;			//客户联系方式

    private String customerLocation;		//联系地址

    private String caseWarrantor;			//案件担保人

    private String caseCustomer;			//客户名称

    private Integer caseAdmin;				//案件管理人

    private Long lastAccess;				//案件更新时间

    private Integer accessLog;				//案件操作类型

    private Long createTime;				//案件创建时间
    
    private String deptFor;					//贷款用途
    
    private String warrantorWay;			//保证方式
    
    //
    private List<String> contactIds;			//联系人身份证号列表（参数）

    
    public DeptCasePo() {
		super();
	}

	public DeptCasePo(Double deptAmount, Double deptBalance, Double deptProfit,
			String dcId, String caseOrg, String customerContact,
			String customerLocation, String caseWarrantor, String caseCustomer,
			Integer caseAdmin, Integer accessLog,  String deptFor, String warrantorWay) {
		super();
		this.deptAmount = deptAmount;
		this.deptBalance = deptBalance;
		this.deptProfit = deptProfit;
		this.dcId = dcId;
		this.caseOrg = caseOrg;
		this.customerContact = customerContact;
		this.customerLocation = customerLocation;
		this.caseWarrantor = caseWarrantor;
		this.caseCustomer = caseCustomer;
		this.caseAdmin = caseAdmin;
		this.accessLog = accessLog;
		this.deptFor=deptFor;
		this.warrantorWay=warrantorWay;
	}
	
	public List<String> getContactIds() {
		return contactIds;
	}

	public void setContactIds(List<String> contactIds) {
		this.contactIds = contactIds;
	}

	public String getDeptFor() {
		return deptFor;
	}

	public void setDeptFor(String deptFor) {
		this.deptFor = deptFor;
	}

	public String getWarrantorWay() {
		return warrantorWay;
	}

	public void setWarrantorWay(String warrantorWay) {
		this.warrantorWay = warrantorWay;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getDeptDate() {
        return deptDate;
    }

    public void setDeptDate(Long deptDate) {
        this.deptDate = deptDate;
    }

    public Long getDeptEndDate() {
        return deptEndDate;
    }

    public void setDeptEndDate(Long deptEndDate) {
        this.deptEndDate = deptEndDate;
    }

    public Double getDeptAmount() {
        return deptAmount;
    }

    public void setDeptAmount(Double deptAmount) {
        this.deptAmount = deptAmount;
    }

    public Double getDeptBalance() {
        return deptBalance;
    }

    public void setDeptBalance(Double deptBalance) {
        this.deptBalance = deptBalance;
    }

    public Double getDeptProfit() {
        return deptProfit;
    }

    public void setDeptProfit(Double deptProfit) {
        this.deptProfit = deptProfit;
    }

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId == null ? null : dcId.trim();
    }

    public String getCaseOrg() {
        return caseOrg;
    }

    public void setCaseOrg(String caseOrg) {
        this.caseOrg = caseOrg == null ? null : caseOrg.trim();
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact == null ? null : customerContact.trim();
    }

    public String getCustomerLocation() {
        return customerLocation;
    }

    public void setCustomerLocation(String customerLocation) {
        this.customerLocation = customerLocation == null ? null : customerLocation.trim();
    }

    public String getCaseWarrantor() {
        return caseWarrantor;
    }

    public void setCaseWarrantor(String caseWarrantor) {
        this.caseWarrantor = caseWarrantor == null ? null : caseWarrantor.trim();
    }

    public String getCaseCustomer() {
        return caseCustomer;
    }

    public void setCaseCustomer(String caseCustomer) {
        this.caseCustomer = caseCustomer == null ? null : caseCustomer.trim();
    }

    public Integer getCaseAdmin() {
        return caseAdmin;
    }

    public void setCaseAdmin(Integer caseAdmin) {
        this.caseAdmin = caseAdmin;
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Integer getAccessLog() {
        return accessLog;
    }

    public void setAccessLog(Integer accessLog) {
        this.accessLog = accessLog;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}