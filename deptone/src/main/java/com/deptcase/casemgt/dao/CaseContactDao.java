package com.deptcase.casemgt.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.CaseContactPo;

public interface CaseContactDao {
    int deleteByPrimaryKey(Long id);

    int insert(CaseContactPo record);

    int insertSelective(CaseContactPo record);

    CaseContactPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CaseContactPo record);

    int updateByPrimaryKey(CaseContactPo record);
    
    /**
     * @description:批量添加联系人
     * @param list
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月19日 下午2:03:19
     */
    long batchAddCaseContactList(List<CaseContactPo> list);
}