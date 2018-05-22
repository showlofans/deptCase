package com.deptcase.casemgt.entity;

/**
 * @description:用户实体
 * @projectName:casemgt
 * @className:LoginUserPo.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午1:48:28
 * @version 1.0
 */
public class LoginUserPo {
    private Integer id;

    private String name;

    private String pass;

    private Integer userLimit;

    private String rootFlag;

    private Long createTime;
    
    private String createTimeStr;

    private String userRemark;

    /** 创建用户
     * @param name
     * @param pass
     * @param userLimit
     * @param rootFlag
     * @param createTime
     * @param userRemark
     */
    public LoginUserPo(String name, String pass, Integer userLimit,
			String rootFlag, Long createTime, String userRemark) {
		super();
		this.name = name;
		this.pass = pass;
		this.userLimit = userLimit;
		this.rootFlag = rootFlag;
		this.createTime = createTime;
		this.userRemark = userRemark;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}



	public LoginUserPo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass == null ? null : pass.trim();
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    public String getRootFlag() {
        return rootFlag;
    }

    public void setRootFlag(String rootFlag) {
        this.rootFlag = rootFlag == null ? null : rootFlag.trim();
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public String getUserRemark() {
        return userRemark;
    }

    public void setUserRemark(String userRemark) {
        this.userRemark = userRemark == null ? null : userRemark.trim();
    }
}