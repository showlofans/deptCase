package com.deptcase.casemgt.dao;

import java.util.List;

import com.deptcase.casemgt.entity.CaseBindContactPo;

/**
 * @description: 案件联系人绑定Dao层
 * @projectName:casemgt
 * @className:CaseBindContactDao.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:24:13
 * @version 1.0
 */
public interface CaseBindContactDao {
    int deleteByPrimaryKey(Long id);

    /**
     * @description: 添加绑定
     * @param record
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月22日 下午3:32:06
     */
    int addCBC(CaseBindContactPo record);
    
    

    int insertSelective(CaseBindContactPo record);

    CaseBindContactPo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CaseBindContactPo record);

    int updateByPrimaryKey(CaseBindContactPo record);
    
    /**
     * @description: 批量添加案件联系人绑定
     * @param list
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月19日 下午2:23:42
     */
    long batchAddCBCList(List<CaseBindContactPo> list);
}