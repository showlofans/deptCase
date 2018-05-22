package com.deptcase.casemgt.ao;

import java.io.File;
import java.util.List;

import com.deptcase.casemgt.entity.CaseContactPo;
import com.deptcase.casemgt.entity.CaseContactVO;

/**
 * @description: 案件联系人AO层
 * @projectName:casemgt
 * @className:CaseContactAO.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:43:04
 * @version 1.0
 */
public interface CaseContactAO {
	
	/**
	 * @description: 导入案件联系人基本信息
	 * @param operator
	 * @param file
	 * @param userId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月19日 上午9:49:50
	 */
	String importCaseContactExcel(String operator, File file, Integer userId);
	
	/**
	 * @description: 批量添加案件联系人
	 * @param list
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月19日 下午1:55:14
	 */
	long batchAddCaseContactList(List<CaseContactPo> list);
	
	/**
	 * @description: 在案件上手动添加联系人
	 * @param caseContactPo
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月22日 下午3:35:54
	 */
	String addContact(CaseContactVO caseContactVO);
	
	/**
	 * @description: 修改联系人
	 * @param caseContactVO
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月22日 下午4:22:11
	 */
	String editContact(CaseContactVO caseContactVO);
	/**
	 * @description: 查询案件列表
	 * @param deptCasePo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月12日 上午11:26:58
	 */
//	Pagination<CaseC> listCase(DeptCasePo deptCasePo,PageParam pageParam);
}
