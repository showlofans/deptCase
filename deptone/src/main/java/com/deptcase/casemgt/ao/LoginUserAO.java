package com.deptcase.casemgt.ao;

import com.deptcase.casemgt.entity.LoginUserPo;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;

public interface LoginUserAO {
	/**
	 * @description: 添加用户
	 * @param loginUserPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午1:50:45
	 */
	String addUser(LoginUserPo loginUserPo);
	
	/**
	 * @description: 获得登录用户
	 * @param loginUserPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午3:10:23
	 */
	LoginUserPo getOneUser(LoginUserPo loginUserPo);
	/**
	 * @description: 编辑用户
	 * @param loginUserPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午1:51:25
	 */
	String editUser(LoginUserPo loginUserPo);
	
	/**
	 * @description: 查询用户分页列表
	 * @param loginUserPo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午2:59:52
	 */
	Pagination<LoginUserPo> listUser(LoginUserPo loginUserPo, PageParam pageParam);
	
	
}
