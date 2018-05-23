package com.deptcase.casemgt.ao;

import java.io.File;
import java.util.List;

import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.casemgt.entity.DeptCaseVO;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;

public interface DeptCaseAO {
	/**
	 * @description: 导入案件excel文件
	 * @param operator
	 * @param file
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月11日 下午5:45:24
	 */
	String importDeptCaseExcel(String operator, File file, Integer userId);
	
	/**
	 * @description: 查询登陆用户案件列表
	 * @param deptCasePo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月12日 上午11:26:58
	 */
	Pagination<DeptCaseVO> listCase(DeptCasePo deptCasePo,PageParam pageParam);
	
	/**
	 * @description: 通过案件id获得案件详情展示
	 * @param id
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月23日 上午11:53:19
	 */
	DeptCaseVO getOneCaseById(Long id);
	
	/**
	 * @description: 查询登陆用户未分配的案件列表
	 * @param contextId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月23日 下午5:14:40
	 */
	Pagination<DeptCaseVO> listUnDisCase(Integer contextId,PageParam pageParam);
	/**
	 * @description: 查询某一用户管理的案件列表
	 * @param contextId
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月23日 下午6:05:01
	 */
	List<DeptCaseVO> listContactCase(Integer contextId);
}
