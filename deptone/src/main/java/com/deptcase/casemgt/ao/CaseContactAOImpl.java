package com.deptcase.casemgt.ao;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.deptcase.casemgt.dao.CaseBindContactDao;
import com.deptcase.casemgt.dao.CaseContactDao;
import com.deptcase.casemgt.dao.DeptCaseDao;
import com.deptcase.casemgt.entity.CaseBindContactPo;
import com.deptcase.casemgt.entity.CaseContactPo;
import com.deptcase.enums.BindTypeEnum;
import com.deptcase.util.CaseContactExcelUtil;

import com.deptcase.util.StringHelper;
/**
 * @description: 案件联系人绑定
 * @projectName:casemgt
 * @className:CaseContactAOImpl.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:31:36
 * @version 1.0
 */
@Service(value="caseContact")
public class CaseContactAOImpl implements CaseContactAO {
	
	@Resource
	private CaseContactDao caseContactDao;
	@Resource
	private DeptCaseDao deptCaseDao;
	@Resource
	private CaseBindContactDao caseBindContactDao;
	
	@Override
	public String importCaseContactExcel(String operator, File file,
			Integer userId) {
		//读取列表
		long successNum = 0;
		int failNum = 0;
		int currentNum = 0;
		List<Map<String, String>> excelContent = CaseContactExcelUtil.readExcel(file);
//		 循环每一条数据 保存至商家余额
		List<CaseContactPo> contactList = new LinkedList<CaseContactPo>();
		List<String> dcIds = new LinkedList<String>();
		long now = System.currentTimeMillis();
		for (Map<String, String> row : excelContent)
		{
			currentNum++;
			String contactName = row.get(CaseContactExcelUtil.RESOURCE_HEAD_CONTACT_NAME_AC).trim();
			if (StringHelper.isTrimEmpty(contactName))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String contactDcid = row.get(CaseContactExcelUtil.RESOURCE_HEAD_CONTACT_DCID_AC).trim();
			if (StringHelper.isTrimEmpty(contactDcid))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			dcIds.add(contactDcid);
			String householdShip = row.get(CaseContactExcelUtil.RESOURCE_HEAD_HOUSEHOLD_SHIP_AC).trim();
			if (StringHelper.isTrimEmpty(householdShip))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String householdLocation = row.get(CaseContactExcelUtil.RESOURCE_HEAD_HOUSEHOLD_LOCATION_AC).trim();
			if (StringHelper.isTrimEmpty(householdLocation))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			String householdDcid = row.get(CaseContactExcelUtil.RESOURCE_HEAD_HOUSEHOLD_DCID_AC).trim();
			if (StringHelper.isTrimEmpty(householdDcid))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			CaseContactPo caseContactPo = new CaseContactPo(contactName, contactDcid, householdShip, householdLocation, now, userId, householdDcid);
			contactList.add(caseContactPo);
		}
		if(contactList.size() > 0){
			successNum = batchAddCaseContactList(contactList);
			System.out.println("批量导入了"+successNum+"个联系人");
//			successNum = contactListRes;
		}
		Map<String, Object> bindingMap = new HashMap<String, Object>();
		
		List<CaseBindContactPo> cbcList = deptCaseDao.getBindingCase(bindingMap);
		for (CaseBindContactPo caseBindContactPo : cbcList) {
			caseBindContactPo.setBindType(BindTypeEnum.CASE_BIND.getValue());
			caseBindContactPo.setLastAccess(now);
		}
		long cbcNum = caseBindContactDao.batchAddCBCList(cbcList);
		System.out.println("批量导入了"+cbcNum+"个案件绑定");
		
		return "导入成功" + successNum + "条,导入失败" + failNum + "条";
	}

	@Override
	public long batchAddCaseContactList(List<CaseContactPo> list) {
		long res = caseContactDao.batchAddCaseContactList(list);
//		for (CaseContactPo caseContactPo : list) {
//			
//		}
		//先全部添加进去再，删除多余的联系人
		return res;
	}

}
