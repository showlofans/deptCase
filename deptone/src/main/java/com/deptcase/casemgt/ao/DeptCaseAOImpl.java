package com.deptcase.casemgt.ao;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.deptcase.casemgt.dao.DeptCaseDao;
import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.casemgt.entity.DeptCaseVO;
import com.deptcase.enums.CaseEventEnum;
import com.deptcase.enums.CaseStateEnum;
import com.deptcase.util.DateUtil;
import com.deptcase.util.DeptCaseExcelUtil;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

@Service(value="deptCaseAO")
public class DeptCaseAOImpl implements DeptCaseAO {

//	Logger logger = Logger.getLogger(DeptCaseAOImpl.class);
	
	@Resource
	private DeptCaseDao deptCaseDao;
	
	@Override
	public String importDeptCaseExcel(String operator, File file, Integer userId) {
		int successNum = 0;
		int failNum = 0;
		int currentNum = 0;
		List<Map<String, String>> excelContent = DeptCaseExcelUtil.readExcel(file);
//		 循环每一条数据 保存至商家余额
		List<DeptCasePo> caseList = new LinkedList<DeptCasePo>();
		for (Map<String, String> row : excelContent)
		{
			currentNum++;
			String caseCustomer = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_CASE_CUSTOMER_AC).trim();
			if (StringHelper.isTrimEmpty(caseCustomer))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String deptDateStr = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_DATE_AC).trim();
			if (StringHelper.isTrimEmpty(deptDateStr))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String deptEndDateStr = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_END_DATE_AC).trim();
			if (StringHelper.isTrimEmpty(deptEndDateStr))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			long deptDate = 0;
			long deptEndDate = 0;
			try
			{
				deptDate = DateUtil.strToDate(deptDateStr, "yyyy-MM-dd").getTime();
				deptEndDate = DateUtil.strToDate(deptEndDateStr, "yyyy-MM-dd").getTime();
			}
			catch (Exception e)
			{
//				logger.info("第" + currentNum + "条解析的进项票余额错误");
				failNum++;
				continue;
			}
			
			
			double deptAmount = 0.00;
			double deptBalance = 0.00;
			double deptProfit = 0.00;
			try
			{
				deptAmount = Double.parseDouble(row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_AMOUNT_AC).trim());
				deptBalance = Double.parseDouble(row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_BALANCE_AC).trim());
				deptProfit = Double.parseDouble(row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_PROFIT_AC).trim());
			}
			catch (Exception e)
			{
//				logger.info("第" + currentNum + "条解析的进项票余额错误");
				failNum++;
				continue;
			}
			String dcId = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DC_ID_AC).trim();
			if (StringHelper.isTrimEmpty(dcId))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String caseOrg = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_CASE_ORG_AC).trim();
			if (StringHelper.isTrimEmpty(caseOrg))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String customerContact = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_CUSTOMER_CONTACT_AC).trim();
			if (StringHelper.isTrimEmpty(customerContact))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String customerLocation = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_CUSTOMER_LOCATION_AC).trim();
			if (StringHelper.isTrimEmpty(customerLocation))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String caseWarrantor = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_CASE_WARRANTOR_AC).trim();
			if (StringHelper.isTrimEmpty(caseWarrantor))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String deptFor = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_DEPT_FOR_AC).trim();
			if (StringHelper.isTrimEmpty(deptFor))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String warrantorWay = row.get(DeptCaseExcelUtil.RESOURCE_HEAD_WARRANTOR_WAY_AC).trim();
			if (StringHelper.isTrimEmpty(warrantorWay))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			DeptCasePo deptCasePo = new DeptCasePo(deptAmount, deptBalance, deptProfit, dcId, caseOrg, customerContact, CaseStateEnum.NEWONE.getValue(),customerLocation, caseWarrantor, caseCustomer,  userId, CaseEventEnum.CASE_IMPORT.getValue(),deptFor,warrantorWay);
//			deptCasePo.set
//			invoiceRecord.setOperator(operator);
			deptCasePo.setLastAccess(System.currentTimeMillis());
//			deptCasePo.setAccessLog(CaseEventEnum.CASE_IMPORT.getValue());
			deptCasePo.setCreateTime(System.currentTimeMillis());
			deptCasePo.setDeptEndDate(deptEndDate);
			deptCasePo.setDeptDate(deptDate);
			
			caseList.add(deptCasePo);
			
//			invoiceAccountService.saveOrUpdateInvoiceAccountByInvoiceRecord(invoiceRecord);
			successNum++;
		}
		if(caseList.size() > 0){
			successNum = deptCaseDao.batchAddCase(caseList);
		}
		return "导入成功" + successNum + "条,导入失败" + failNum + "条";
	}

	@Override
	public Pagination<DeptCaseVO> listCase(DeptCasePo deptCasePo,
			PageParam pageParam) {
		Map<String, Object> paramsMap = getParamsByPo(deptCasePo);
		int toatalRecord = deptCaseDao.countCase(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<DeptCasePo> caseList = deptCaseDao.listCase(paramsMap);
		
		List<DeptCaseVO> caseVOList = new LinkedList<DeptCaseVO>();
		for (DeptCasePo deptCasePo2 : caseList) {
			String deptDate = DateUtil.formatAll(deptCasePo2.getDeptDate());
			String deptEndDate = DateUtil.formatAll(deptCasePo2.getDeptEndDate());
			String createTime = DateUtil.formatAll(deptCasePo2.getCreateTime());
			String lastAccess = DateUtil.formatAll(deptCasePo2.getLastAccess());
			DeptCaseVO deptCaseVO = new DeptCaseVO(deptDate, deptEndDate, deptCasePo2.getDeptAmount(), deptCasePo2.getDeptBalance(), deptCasePo2.getDeptProfit(), deptCasePo2.getDcId(), deptCasePo2.getCaseOrg(), deptCasePo2.getCustomerContact(), deptCasePo2.getCustomerLocation(), deptCasePo2.getCaseWarrantor(), deptCasePo2.getCaseCustomer(), deptCasePo2.getCaseAdmin(), lastAccess, deptCasePo2.getAccessLog(), createTime, deptCasePo2.getDeptFor(), deptCasePo2.getWarrantorWay(), deptCasePo2.getLoanNumber(), deptCasePo2.getCaseState());
			caseVOList.add(deptCaseVO);
		}
		return new Pagination<DeptCaseVO>(caseVOList, toatalRecord, pageNo, pageSize);
	}
	
	private Map<String, Object> getParamsByPo(DeptCasePo deptCasePo){
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		if(deptCasePo.getCaseAdmin() != null){
			paramsMap.put("caseAdmin", deptCasePo.getCaseAdmin());
		}
		return paramsMap;
	}

	@Override
	public DeptCaseVO getOneCaseById(Long id) {
		DeptCasePo deptCasePo = deptCaseDao.getOneCaseById(id);
		DeptCaseVO deptCaseVO = null;
		if(deptCasePo != null){
			String deptDate = DateUtil.formatAll(deptCasePo.getDeptDate());
			String deptEndDate = DateUtil.formatAll(deptCasePo.getDeptEndDate());
			String createTime = DateUtil.formatAll(deptCasePo.getCreateTime());
			String lastAccess = DateUtil.formatAll(deptCasePo.getLastAccess());
			deptCaseVO = new DeptCaseVO(deptDate, deptEndDate, deptCasePo.getDeptAmount(), deptCasePo.getDeptBalance(), deptCasePo.getDeptProfit(), deptCasePo.getDcId(), deptCasePo.getCaseOrg(), deptCasePo.getCustomerContact(), deptCasePo.getCustomerLocation(), deptCasePo.getCaseWarrantor(), deptCasePo.getCaseCustomer(), deptCasePo.getCaseAdmin(), lastAccess, deptCasePo.getAccessLog(), createTime, deptCasePo.getDeptFor(), deptCasePo.getWarrantorWay(), deptCasePo.getLoanNumber(), deptCasePo.getCaseState());
		}
		return deptCaseVO;
	}

	@Override
	public List<DeptCaseVO> listContactCase(Integer contactId) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("caseAdmin", contactId);
		List<DeptCasePo> caseList = deptCaseDao.listCase(paramsMap);
		List<DeptCaseVO> caseVOList = new LinkedList<DeptCaseVO>();
		for (DeptCasePo deptCasePo : caseList) {
			String deptDate = DateUtil.formatAll(deptCasePo.getDeptDate());
			String deptEndDate = DateUtil.formatAll(deptCasePo.getDeptEndDate());
			String createTime = DateUtil.formatAll(deptCasePo.getCreateTime());
			String lastAccess = DateUtil.formatAll(deptCasePo.getLastAccess());
			DeptCaseVO deptCaseVO = new DeptCaseVO(deptDate, deptEndDate, deptCasePo.getDeptAmount(), deptCasePo.getDeptBalance(), deptCasePo.getDeptProfit(), deptCasePo.getDcId(), deptCasePo.getCaseOrg(), deptCasePo.getCustomerContact(), deptCasePo.getCustomerLocation(), deptCasePo.getCaseWarrantor(), deptCasePo.getCaseCustomer(), deptCasePo.getCaseAdmin(), lastAccess, deptCasePo.getAccessLog(), createTime, deptCasePo.getDeptFor(), deptCasePo.getWarrantorWay(), deptCasePo.getLoanNumber(), deptCasePo.getCaseState());
			caseVOList.add(deptCaseVO);
		}
		return caseVOList;
	}

	@Override
	public Pagination<DeptCaseVO>  listUnDisCase(Integer contextId ,PageParam pageParam) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
		paramsMap.put("caseAdmin", contextId);
		Integer [] inCaseStates = new Integer[]{CaseStateEnum.NEWONE.getValue(),CaseStateEnum.UNDISTRIBUE.getValue()};
		paramsMap.put("inCaseStates", inCaseStates);
		int toatalRecord = deptCaseDao.countCase(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<DeptCasePo> caseList = deptCaseDao.listCase(paramsMap);
		List<DeptCaseVO> caseVOList = new LinkedList<DeptCaseVO>();
		for (DeptCasePo deptCasePo : caseList) {
			String deptDate = DateUtil.formatAll(deptCasePo.getDeptDate());
			String deptEndDate = DateUtil.formatAll(deptCasePo.getDeptEndDate());
			String createTime = DateUtil.formatAll(deptCasePo.getCreateTime());
			String lastAccess = DateUtil.formatAll(deptCasePo.getLastAccess());
			DeptCaseVO deptCaseVO = new DeptCaseVO(deptDate, deptEndDate, deptCasePo.getDeptAmount(), deptCasePo.getDeptBalance(), deptCasePo.getDeptProfit(), deptCasePo.getDcId(), deptCasePo.getCaseOrg(), deptCasePo.getCustomerContact(), deptCasePo.getCustomerLocation(), deptCasePo.getCaseWarrantor(), deptCasePo.getCaseCustomer(), deptCasePo.getCaseAdmin(), lastAccess, deptCasePo.getAccessLog(), createTime, deptCasePo.getDeptFor(), deptCasePo.getWarrantorWay(), deptCasePo.getLoanNumber(), deptCasePo.getCaseState());
			caseVOList.add(deptCaseVO);
		}
		return new Pagination<DeptCaseVO>(caseVOList, toatalRecord, pageNo, pageSize);
		
	}

}
