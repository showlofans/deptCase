package com.deptcase.casemgt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.CaseBindContactPo;
import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.enums.CaseStateEnum;

@Repository(value="deptCaseDao")
public class DeptCaseDaoImpl implements DeptCaseDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
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
	public DeptCasePo getOneCaseById(Long id) {
		if(id != null){
			return sqlSessionTemplate.selectOne("getOneCaseById", id);
		}
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

	@Override
	public List<CaseBindContactPo> getBindingCase(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getBindingCase", params);
	}

//	@Override
//	public List<DeptCasePo> listUnDisCase(Map<String, Object> params) {
//		Integer [] inCaseStates = new Integer[]{CaseStateEnum.NEWONE.getValue(),CaseStateEnum.UNDISTRIBUE.getValue()};
//		params.put("inCaseStates", inCaseStates);
//		System.out.println(params.toString());
//		return sqlSessionTemplate.selectList("listCase", params);
//	}
	
	

}
