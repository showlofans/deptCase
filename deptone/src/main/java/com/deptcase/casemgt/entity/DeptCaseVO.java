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

public class DeptCaseVO {
	
    private Integer id;

    private String deptDate;					//贷款日期

    private String deptEndDate;				//到期日期

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

    private String lastAccess;				//案件更新时间

    private Integer accessLog;				//案件操作类型

    private String createTime;				//案件创建时间
    
    private String deptFor;					//贷款用途
    
    private String warrantorWay;			//保证方式
    
    private String loanNumber;				//借据号
    
    private Integer caseState;				//CaseStateEnum 案件状态
    
//    private List<String> contactIds;			//联系人身份证号列表（参数）

    
    public DeptCaseVO() {
		super();
	}

	/**
	 * 构建页面实体
	 */
	public DeptCaseVO(String deptDate, String deptEndDate, Double deptAmount,
			Double deptBalance, Double deptProfit, String dcId, String caseOrg,
			String customerContact, String customerLocation,
			String caseWarrantor, String caseCustomer, Integer caseAdmin,
			String lastAccess, Integer accessLog, String createTime,
			String deptFor, String warrantorWay, String loanNumber,
			Integer caseState) {
		super();
		this.deptDate = deptDate;
		this.deptEndDate = deptEndDate;
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
		this.lastAccess = lastAccess;
		this.accessLog = accessLog;
		this.createTime = createTime;
		this.deptFor = deptFor;
		this.warrantorWay = warrantorWay;
		this.loanNumber = loanNumber;
		this.caseState = caseState;
	}



	public Integer getCaseState() {
		return caseState;
	}

	public void setCaseState(Integer caseState) {
		this.caseState = caseState;
	}

	public String getLoanNumber() {
		return loanNumber;
	}

	public void setLoanNumber(String loanNumber) {
		this.loanNumber = loanNumber;
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

    public Integer getAccessLog() {
        return accessLog;
    }

    public void setAccessLog(Integer accessLog) {
        this.accessLog = accessLog;
    }

	public String getDeptDate() {
		return deptDate;
	}

	public void setDeptDate(String deptDate) {
		this.deptDate = deptDate;
	}

	public String getDeptEndDate() {
		return deptEndDate;
	}

	public void setDeptEndDate(String deptEndDate) {
		this.deptEndDate = deptEndDate;
	}

	public String getLastAccess() {
		return lastAccess;
	}

	public void setLastAccess(String lastAccess) {
		this.lastAccess = lastAccess;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
    
}