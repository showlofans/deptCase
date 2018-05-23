package com.deptcase.casemgt.dao;

import java.util.List;
import java.util.Map;

import com.deptcase.casemgt.entity.CaseBindContactPo;
import com.deptcase.casemgt.entity.DeptCasePo;

public interface DeptCaseDao {
    int deleteByPrimaryKey(Long id);

    int insert(DeptCasePo record);

    int insertSelective(DeptCasePo record);

    DeptCasePo getOneCaseById(Long id);

    int updateByPrimaryKeySelective(DeptCasePo record);

    int updateByPrimaryKey(DeptCasePo record);
    
    /**
     * @description: 批量添加记录
     * @param caseList
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月12日 下午2:57:17
     */
    int batchAddCase(List<DeptCasePo> caseList);
    
    /**
     * @description:
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月12日 下午3:23:14
     */
    int countCase(Map<String,Object> params);
    /**
     * @description:
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月12日 下午3:23:10
     */
    List<DeptCasePo> listCase (Map<String,Object> params);
    
    /**
     * @description: 获得待绑定的案件联系人绑定列表
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月19日 下午1:06:21
     */
    List<CaseBindContactPo> getBindingCase(Map<String,Object> params);
    
    /**
     * @description: 查询未分配的案件列表
     * @param params
     * @return
     * @author:微族通道代码设计人 宁强
     * @createTime:2018年5月23日 下午4:40:27
     */
//    List<DeptCasePo> listUnDisCase(Map<String,Object> params);
}