package com.deptcase.casemgt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.CaseContactPo;

/**
 * @description: 案件联系人Dao层
 * @projectName:casemgt
 * @className:CaseContactDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:05:36
 * @version 1.0
 */
@Repository(value="caseContactDao")
public class CaseContactDaoImpl implements CaseContactDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addContact(CaseContactPo record) {
		return sqlSessionTemplate.insert("addContact", record);
	}

	@Override
	public int insertSelective(CaseContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CaseContactPo selectByPrimaryKey(Long id) {
		
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(CaseContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(CaseContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long batchAddCaseContactList(List<CaseContactPo> list) {
		return sqlSessionTemplate.insert("batchAddCaseContactList", list);
	}

	@Override
	public long countCCByParams(Map<String, Object> params) {
		return sqlSessionTemplate.selectOne("countCCByParams", params);
	}

	@Override
	public int updateContactByPo(CaseContactPo caseContactPo) {
		return sqlSessionTemplate.update("updateContactByPo", caseContactPo);
	}

	@Override
	public List<CaseContactPo> getContactByCaseId(Map<String, Object> params) {
		return sqlSessionTemplate.selectList("getContactByCaseId", params);
	}

//	@Override
//	public List<String> getDoubleIds(List<String> dcids) {
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("contactDcids", dcids);
//		return sqlSessionTemplate.selectList("getDoubleIds", params);
//	}

}
