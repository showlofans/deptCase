package com.deptcase.casemgt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deptcase.casemgt.ao.DeptCaseAO;
import com.deptcase.casemgt.ao.LoginUserAO;
import com.deptcase.casemgt.dao.LoginUserDao;
import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.casemgt.entity.LoginUserPo;
import com.deptcase.casemgt.url.DeptCaseUrl;
import com.deptcase.casemgt.url.LoginUserUrl;
import com.deptcase.util.DateUtil;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

/**
 * @description: 用户管理
 * @projectName:casemgt
 * @className:LoginController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午1:44:02
 * @version 1.0
 */
@Controller
@RequestMapping(value=LoginUserUrl.MODOE_NAME)
public class LoginController {

	@Resource
	private LoginUserAO loginUserAO;
	@Resource
	private LoginUserDao loginUserDao; 
	
	/**
	 * @description: 查询用户列表
	 * @param pageNo
	 * @param loginUserPo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午3:16:49
	 */
	@RequestMapping(value=LoginUserUrl.LIST_USER)
	public ModelAndView listUser(@RequestParam(value = "pageNo", required = false)String pageNo, LoginUserPo loginUserPo,
			HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			pageParam = new PageParam(1, 10);
		}
		Pagination<LoginUserPo> pagination = loginUserAO.listUser(loginUserPo, pageParam);
		resultMap.put("pagination", pagination);
		return new ModelAndView("/userLogin/user_list", "resultMap", resultMap);
	}
	/**
	 * @description: 用户添加
	 * @param loginUserPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午2:42:52
	 */
	@ResponseBody
	@RequestMapping(value=LoginUserUrl.USER_ADD)
	public String addUser(LoginUserPo loginUserPo){
		String msg = loginUserAO.addUser(loginUserPo);
		
		return msg;
	}
	/**
	 * @description: 用户登陆
	 * @param loginUserPo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午3:16:12
	 */
	@RequestMapping(value=LoginUserUrl.USER_LOGIN)
	public ModelAndView login( LoginUserPo loginUserPo,
			HttpServletRequest request){
//		Map<String, Object> resultMap = get;
		LoginUserPo userPo = loginUserAO.getOneUser(loginUserPo);
		String msg = "success";
		if(userPo == null){
			msg = "用户名或密码错误";
		}
		request.getSession().setAttribute("loginContext", userPo);
//		request
//		resultMap.put("pagination", pagination);
		return new ModelAndView("/userLogin/login_page");
	}
	
}
