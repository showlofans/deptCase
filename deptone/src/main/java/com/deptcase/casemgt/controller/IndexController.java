package com.deptcase.casemgt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.deptcase.casemgt.url.DeptCaseUrl;

@Controller
public class IndexController {
	/**
	 * @description: 首页控制
	 * <br>跳转到首页还有一种方法，就是session中已登录直接从首页跳转到首页
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年12月9日 上午9:36:22
	 */
	@RequestMapping(value=DeptCaseUrl.INDEX)
	public String goIndex(HttpServletRequest request) {
//		HttpSession session = request.getSession();
//		AgencyBackwardVO agencyVo = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
//		if(agencyVo == null){
//			return "/agency/login_page";
//		}
//		
//		//设置session中的总余额
//		//超管登陆的时候，默认如果没有对公账户，就给他创建一个对公账户
//		ChargeAccountPo chargeAccountPo1 = chargeAccountAO
//				.getAccountByAgencyId(agencyVo.getId(),BillTypeEnum.CORPORATE_BUSINESS.getValue());
//		ChargeAccountPo chargeAccountPo = chargeAccountAO
//				.getAccountByAgencyId(agencyVo.getId(),BillTypeEnum.BUSINESS_INDIVIDUAL.getValue());
//		Double accountBalance = chargeAccountPo.getAccountBalance();
//		if(chargeAccountPo1 != null){
//			accountBalance = NumberTool.add(accountBalance, chargeAccountPo1.getAccountBalance());
//		}
//		//注册的时候已经保证了可以进行表连接
//		session.setAttribute("totalBalance", accountBalance);//对私
//		
//		///**设置消息*/
//		messageTool.setMsg(agencyVo.getId(), session);
		return "index";
	}
}
