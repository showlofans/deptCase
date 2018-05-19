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
import com.deptcase.enums.CaseEventEnum;
import com.deptcase.util.DateUtil;
import com.deptcase.util.DeptCaseExcelUtil;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

@Service(value="deptCaseAO")
public class DeptCaseAOImpl implements DeptCaseAO {

	Logger logger = Logger.getLogger(DeptCaseAOImpl.class);
	
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
			DeptCasePo deptCasePo = new DeptCasePo(deptAmount, deptBalance, deptProfit, dcId, caseOrg, customerContact, customerLocation, caseWarrantor, caseCustomer, userId, CaseEventEnum.CASE_IMPORT.getValue(),deptFor,warrantorWay);
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
	public Pagination<DeptCasePo> listCase(DeptCasePo deptCasePo,
			PageParam pageParam) {
		Map<String, Object> paramsMap = new HashMap<String, Object>();
//		paramsMap.put("epName", ep.getEpName());
//		paramsMap.put("epEngId", ep.getEpEngId());
//		paramsMap.put("epFor", ep.getEpFor());
//		if(ep.getId() != null){
//			paramsMap.put("id", ep.getId());
//		}
		int toatalRecord = deptCaseDao.countCase(paramsMap);
		int pageSize = 10;
		int pageNo = 1;
		if(pageParam != null){
			pageSize = pageParam.getPageSize();
			pageNo = pageParam.getPageNo();
			paramsMap.put("start", (pageNo-1)*pageSize);
			paramsMap.put("end", pageSize);
		}
		List<DeptCasePo> records = deptCaseDao.listCase(paramsMap);
//		for (ExchangePlatformPo exchangePlatformPo : records) {//动态设置平台余额
////			exchangePlatformPo.setEpBalance(epBalance);
//			String lastAccessStr = DateUtil.formatPramm(exchangePlatformPo.getLastAccess(),"yyyy-MM-dd");
//			exchangePlatformPo.setLastAccessStr(lastAccessStr);
//			String dataUserPass = Hash.BASE_UTIL.decode(exchangePlatformPo.getEpUserPass());
//			exchangePlatformPo.setEpUserPass(dataUserPass);
//		}
		return new Pagination<DeptCasePo>(records, toatalRecord, pageNo, pageSize);
//		return new Pagination<DeptCasePo>(null, 0,pageParam.getPageNo() , pageParam.getPageSize());
	}

}
