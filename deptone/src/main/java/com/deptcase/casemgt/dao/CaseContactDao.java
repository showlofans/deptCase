package com.deptcase.casemgt.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.deptcase.casemgt.entity.CaseContactPo;

public interface CaseContactDao {
    int deleteByPrimaryKey(Long id);

    int addContact(CaseContactPo record);

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
    
    /**
     * @description: 获得已存在的身份证号
     * @param dcid
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午5:35:27
     */
//    List<String> getDoubleIds(List<String> dcids);
    
    /**
     * @description: 根据参数统计联系人数量
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月21日 下午5:54:50
     */
    long countCCByParams(Map<String, Object> params);
    
    /**
     * @description: 更新联系人信息
     * @param caseContactPo
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月22日 下午3:52:48
     */
    int updateContactByPo(CaseContactPo caseContactPo);
    
    /**
     * @description:通过参数案件ID查找所有关联的联系人
     * @param caseId
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月23日 上午10:23:51
     */
    List<CaseContactPo> getContactByCaseId(Map<String, Object> params);
}