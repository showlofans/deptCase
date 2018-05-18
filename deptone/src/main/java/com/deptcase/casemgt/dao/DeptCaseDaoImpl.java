package com.deptcase.casemgt.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.DeptCasePo;

@Repository(value="deptCaseDao")
public class DeptCaseDaoImpl implements DeptCaseDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(DeptCasePo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(DeptCasePo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DeptCasePo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(DeptCasePo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(DeptCasePo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int batchAddCase(List<DeptCasePo> caseList) {
		return sqlSessionTemplate.insert("batchAddCase", caseList);
	}

	@Override
	public int countCase(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countCase", params);
	}

	@Override
	public List<DeptCasePo> listCase(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("listCase", params);
	}

}
