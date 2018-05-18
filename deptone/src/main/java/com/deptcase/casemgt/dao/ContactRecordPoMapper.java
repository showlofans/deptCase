package com.deptcase.casemgt.dao;

import com.deptcase.casemgt.entity.ContactRecordPo;

public interface ContactRecordPoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContactRecordPo record);

    int insertSelective(ContactRecordPo record);

    ContactRecordPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContactRecordPo record);

    int updateByPrimaryKey(ContactRecordPo record);
}