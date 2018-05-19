package com.deptcase.casemgt.dao;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.CaseBindContactPo;

/**
 * @description:案件联系人绑定Dao
 * @projectName:casemgt
 * @className:CaseBindContactDaoImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:25:31
 * @version 1.0
 */
@Repository(value="caseBindContactDao")
public class CaseBindContactDaoImpl implements CaseBindContactDao {

	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(CaseBindContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertSelective(CaseBindContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public CaseBindContactPo selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKeySelective(CaseBindContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateByPrimaryKey(CaseBindContactPo record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long batchAddCBCList(List<CaseBindContactPo> list) {
		return sqlSessionTemplate.insert("batchAddCBCList", list);
	}

}
