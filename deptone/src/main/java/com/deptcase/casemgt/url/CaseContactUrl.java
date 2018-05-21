package com.deptcase.casemgt.url;

import com.deptcase.base.BaseURL;

/**
 * @description:案件联系人
 * @projectName:casemgt
 * @className:CaseContactUrl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 上午9:45:36
 * @version 1.0
 */
public class CaseContactUrl extends BaseURL{
	/**
	 * 联系人管理模块
	 */
	public static final String MODOE_NAME = "/casemgt/caseContact";
	/**
	 * 导入联系人
	 * <br>/casemgt/caseContact/import_case_contact
	 */
	public static final String IMPORT_CASE_CONTACT = "/import_case_contact" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 编辑联系人
	 * <br>/casemgt/caseContact/edit_contact
	 */
	public static final String EDIT_CONTACT = "/edit_contact" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 联系人编辑页面
	 * <br>/casemgt/caseContact/edit_contact_page
	 */
	public static final String EDIT_CONTACT_PAGE = "/edit_contact_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 联系人列表
	 * <br>/casemgt/caseContact/list_case_contact
	 */
//	public static final String LIST_CASE_CONTACT = "/list_case_contact" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 导入联系人页面
	 * <br>/flowsys/deptCase/import_case_page
	 */
//	public static final String IMPORT_CASE_PAGE = "/import_case_page" + DYNAMIC_WEB_SUFFIX;
	
}
