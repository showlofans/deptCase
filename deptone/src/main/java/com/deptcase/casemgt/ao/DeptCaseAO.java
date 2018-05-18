package com.deptcase.casemgt.ao;

import java.io.File;

import com.deptcase.casemgt.entity.DeptCasePo;
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
	 * @description: 查询案件列表
	 * @param deptCasePo
	 * @param pageParam
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月12日 上午11:26:58
	 */
	Pagination<DeptCasePo> listCase(DeptCasePo deptCasePo,PageParam pageParam);
}
