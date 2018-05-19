package com.deptcase.casemgt.dao;

import java.util.List;

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
	public int insert(CaseContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(CaseContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CaseContactPo selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
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

}
