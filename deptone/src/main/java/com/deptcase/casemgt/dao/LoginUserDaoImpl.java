package com.deptcase.casemgt.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.LoginUserPo;

@Repository(value="loginUserDao")
public class LoginUserDaoImpl implements LoginUserDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addUser(LoginUserPo record) {
		return sqlSessionTemplate.insert("addUser", record);
	}

	@Override
	public int insertSelective(LoginUserPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
//	public LoginUserPo selectByPrimaryKey(Integer id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int updateByPrimaryKeySelective(LoginUserPo record) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int updateByPrimaryKey(LoginUserPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<LoginUserPo> listUserByParams(Map<String, Object> parasm) {
		return sqlSessionTemplate.selectList("getUserByParams", parasm);
	}

	@Override
	public int countUser(Map<String, Object> parasm) {
		return sqlSessionTemplate.selectOne("countUser", parasm);
	}

	@Override
	public LoginUserPo getOneUser(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("getOneUser", params);
	}

	@Override
	public int editUser(LoginUserPo loginUserPo) {
		return sqlSessionTemplate.update("editUser", loginUserPo);
	}

	@Override
	public int addUserKey(LoginUserPo record) {
		return sqlSessionTemplate.insert("addUserKey", record);
	}

}
