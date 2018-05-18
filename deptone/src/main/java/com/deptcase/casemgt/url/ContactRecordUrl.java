package com.deptcase.casemgt.url;

import com.deptcase.base.BaseURL;

/**
 * @description: 案件
 * @projectName:deptone
 * @className:DeptCaseUrl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月11日 下午5:40:58
 * @version 1.0
 */
public class ContactRecordUrl extends BaseURL{
	/**
	 * 案件管理模块
	 */
	public static final String MODOE_NAME = "/casemgt/contactRecord";
	/**
	 * 联系记录列表
	 * <br>/casemgt/contactRecord/list_record
	 */
	public static final String LIST_RECORD = "/list_record" + DYNAMIC_WEB_SUFFIX;
	
	
}
