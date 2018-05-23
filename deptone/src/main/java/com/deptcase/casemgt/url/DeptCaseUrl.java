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
public class DeptCaseUrl extends BaseURL{
	/**
	 * 案件管理模块
	 */
	public static final String MODOE_NAME = "/casemgt/deptCase";
	/**
	 * 导入案件
	 * <br>/casemgt/deptCase/import_case
	 */
	public static final String IMPORT_CASE = "/import_case" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 案件列表
	 * <br>/casemgt/deptCase/list_case
	 */
	public static final String LIST_CASE = "/list_case" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 案件批量分配页面
	 * <br>/casemgt/deptCase/batch_distribute_case_page
	 */
	public static final String BATCH_DISTRIBUTE_CASE_PAGE = "/batch_distribute_case_page" + DYNAMIC_WEB_SUFFIX;
	
	
	/**
	 * 导入案件页面
	 * <br>/flowsys/deptCase/import_case_page
	 */
//	public static final String IMPORT_CASE_PAGE = "/import_case_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 进入首页controller
	 * <br>/index
	 */
	public static final String INDEX = "/home" + DYNAMIC_WEB_SUFFIX;
	
	
}
