package com.deptcase.casemgt.entity;

/**
 * @description: 案件联系人
 * @projectName:casemgt
 * @className:CaseContactPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 上午10:09:47
 * @version 1.0
 */
public class CaseContactPo {
    private Long id;

    private String contactName;				//联系人名字

    private String contactDcid;				//联系人身份证号

    private String householdShip;			//户籍关系

    private String householdLocation;		//户籍地址
    
    private String householdDcid;			//户主身份证号

    private String otherContactShip;		//其他关系(称呼)

    private String contactNumber;			//联系人号码

    private String contactLocation;			//现在的联系地址

    private String contactRemark;			//备注信息

    private Long lastAccess;				//最后更新

    private Integer contactAddUser;			//添加人id

    
    
    /** 导入添加联系人实体
     * @param contactName
     * @param contactDcid
     * @param householdShip
     * @param householdLocation
     * @param lastAccess
     * @param contactAddUser
     * @param householdDcid
     */
    public CaseContactPo(String contactName, String contactDcid,
			String householdShip, String householdLocation, Long lastAccess,
			Integer contactAddUser,String householdDcid) {
		super();
		this.contactName = contactName;
		this.contactDcid = contactDcid;
		this.householdShip = householdShip;
		this.householdLocation = householdLocation;
		this.lastAccess = lastAccess;
		this.contactAddUser = contactAddUser;
		this.householdDcid=householdDcid;
	}

	public String getHouseholdDcid() {
		return householdDcid;
	}

	public void setHouseholdDcid(String householdDcid) {
		this.householdDcid = householdDcid;
	}

	public CaseContactPo() {
		super();
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactDcid() {
        return contactDcid;
    }

    public void setContactDcid(String contactDcid) {
        this.contactDcid = contactDcid == null ? null : contactDcid.trim();
    }

    public String getHouseholdShip() {
        return householdShip;
    }

    public void setHouseholdShip(String householdShip) {
        this.householdShip = householdShip == null ? null : householdShip.trim();
    }

    public String getHouseholdLocation() {
        return householdLocation;
    }

    public void setHouseholdLocation(String householdLocation) {
        this.householdLocation = householdLocation == null ? null : householdLocation.trim();
    }

    public String getOtherContactShip() {
        return otherContactShip;
    }

    public void setOtherContactShip(String otherContactShip) {
        this.otherContactShip = otherContactShip == null ? null : otherContactShip.trim();
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber == null ? null : contactNumber.trim();
    }

    public String getContactLocation() {
        return contactLocation;
    }

    public void setContactLocation(String contactLocation) {
        this.contactLocation = contactLocation == null ? null : contactLocation.trim();
    }

    public String getContactRemark() {
        return contactRemark;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark == null ? null : contactRemark.trim();
    }

    public Long getLastAccess() {
        return lastAccess;
    }

    public void setLastAccess(Long lastAccess) {
        this.lastAccess = lastAccess;
    }

    public Integer getContactAddUser() {
        return contactAddUser;
    }

    public void setContactAddUser(Integer contactAddUser) {
        this.contactAddUser = contactAddUser;
    }
}