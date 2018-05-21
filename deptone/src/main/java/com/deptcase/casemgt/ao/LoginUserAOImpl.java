package com.deptcase.casemgt.ao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.deptcase.casemgt.dao.LoginUserDao;
import com.deptcase.casemgt.entity.LoginUserPo;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

/**
 * @description: 
 * @projectName:casemgt
 * @className:LoginUserAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午2:09:29
 * @version 1.0
 */
@Service(value="loginUserAO")
public class LoginUserAOImpl implements LoginUserAO {
	@Resource
	private LoginUserDao loginUserDao; 
	
	@Override
	public String addUser(LoginUserPo loginUserPo) {
		Map<String, Object> params = getParamsByLoginUserPo(loginUserPo);
		int userCount = loginUserDao.countUser(params);
		String msg = "error";
		if(userCount > 0){
			msg = "用户名已存在";
		}else{
			int intRes = loginUserDao.insert(loginUserPo);
			if(intRes > 0){
				msg="success";
			}
		}
		return msg;
	}

	@Override
	public String editUser(LoginUserPo loginUserPo) {
		String msg = "error";
		if(loginUserPo.getId() == null){
			msg="没有选择用户Id";
		}
		int upRes = loginUserDao.editUser(loginUserPo);
		if(upRes > 0){
			msg = "success";
		}
		return msg;
	}
	
	private Map<String, Object> getParamsByLoginUserPo(LoginUserPo loginUserPo){
		Map<String, Object> params = new HashMap<String, Object>();
		if(StringHelper.isNotEmpty(loginUserPo.getName())){
			params.put("name", loginUserPo.getName());
		}
		if(StringHelper.isNotEmpty(loginUserPo.getPass())){
			params.put("pass", loginUserPo.getPass());
		}
		if(StringHelper.isNotEmpty(loginUserPo.getRootFlag())){
			params.put("rootFlag", loginUserPo.getRootFlag());
		}
		if(StringHelper.isNotEmpty(loginUserPo.getUserRemark())){
			params.put("userRemark", loginUserPo.getUserRemark());
		}
		if(loginUserPo.getId() != null){
			params.put("id", loginUserPo.getId());
		}
		if(loginUserPo.getUserLimit() != null){
			params.put("userLimit", loginUserPo.getUserLimit());
		}
		return params;
	}

	@Override
	public Pagination<LoginUserPo> listUser(LoginUserPo loginUserPo,
			PageParam pageParam) {
		Map<String, Object> paramsMap = getParamsByLoginUserPo(loginUserPo);
		int totalRecord = loginUserDao.countUser(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<LoginUserPo> userList = loginUserDao.listUserByParams(paramsMap);
		
		return new Pagination<LoginUserPo>(userList, totalRecord, pageNo, pageSize);
	}

	@Override
	public LoginUserPo getOneUser(LoginUserPo loginUserPo) {
		Map<String, Object> paramsMap = getParamsByLoginUserPo(loginUserPo);
		LoginUserPo userPo = loginUserDao.getOneUser(paramsMap);
		return userPo;
	}

}
