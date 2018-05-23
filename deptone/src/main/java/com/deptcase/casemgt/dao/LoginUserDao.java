package com.deptcase.casemgt.dao;

import java.util.List;
import java.util.Map;

import com.deptcase.casemgt.entity.LoginUserPo;

/**
 * @description: 用户列表
 * @projectName:casemgt
 * @className:LoginUserDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午2:02:57
 * @version 1.0
 */
public interface LoginUserDao {
    int deleteByPrimaryKey(Integer id);

    int addUser(LoginUserPo record);
    
    /**
     * @description: 添加返key
     * @param record
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月22日 上午10:55:22
     */
    int addUserKey(LoginUserPo record);

    int insertSelective(LoginUserPo record);

//    LoginUserPo selectByPrimaryKey(Integer id);

//    int updateByPrimaryKeySelective(LoginUserPo record);

    int updateByPrimaryKey(LoginUserPo record);
    
    /**
     * @description: 用户编辑
     * @param loginUserPo
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午2:45:38
     */
    int editUser(LoginUserPo loginUserPo);
    
    /**
     * @description: 根据条件查询用户列表
     * @param parasm
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午2:02:46
     */
    List<LoginUserPo> listUserByParams(Map<String, Object> params);
    
    /**
     * @description: 查询登陆用户
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午2:32:30
     */
    LoginUserPo getOneUser(Map<String, Object> params);
    
	/**
	 * @description: 获得用户信息
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月23日 下午6:45:03
	 */
	LoginUserPo getOneUserById(Integer id);
    
    /**
     * @description:统计用户数量
     * @param parasm
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午2:03:25
     */
    int countUser(Map<String, Object> parasm);
}