package com.deptcase.casemgt.url;

import com.deptcase.base.BaseURL;

/**
 * @description:用户管理模块
 * @projectName:casemgt
 * @className:UserUrl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午2:37:37
 * @version 1.0
 */
public class LoginUserUrl extends BaseURL {
	/**
	 * 用户管理模块
	 */
	public static final String MODOE_NAME = "/casemgt/userLogin";
	/**
	 * 用户登录
	 * <br>/casemgt/userLogin/user_login
	 */
	public static final String USER_LOGIN = "/user_login" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 用户登录页面
	 * <br>/casemgt/userLogin/login_page
	 */
	public static final String LOGIN_PAGE = "/login_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 用户添加
	 * <br>/casemgt/userLogin/user_add
	 */
	public static final String USER_ADD = "/user_add" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 用户添加
	 * <br>/casemgt/userLogin/user_add_page
	 */
	public static final String USER_ADD_PAGE = "/user_add_page" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 用户编辑
	 * <br>/casemgt/userLogin/user_edit
	 */
	public static final String USER_EDIT = "/user_edit" + DYNAMIC_WEB_SUFFIX;
	/**
	 * 用户列表加载
	 * <br>/casemgt/userLogin/list_user
	 */
	public static final String LIST_USER = "/list_user" + DYNAMIC_WEB_SUFFIX;
}
