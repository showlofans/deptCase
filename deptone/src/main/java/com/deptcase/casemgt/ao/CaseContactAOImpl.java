package com.deptcase.casemgt.ao;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deptcase.casemgt.dao.CaseBindContactDao;
import com.deptcase.casemgt.dao.CaseContactDao;
import com.deptcase.casemgt.dao.DeptCaseDao;
import com.deptcase.casemgt.entity.CaseBindContactPo;
import com.deptcase.casemgt.entity.CaseContactPo;
import com.deptcase.casemgt.entity.CaseContactVO;
import com.deptcase.casemgt.entity.LoginUserPo;
import com.deptcase.enums.BindTypeEnum;
import com.deptcase.enums.UserLimitEnum;
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
//			caseContactDao
			Map<String, Object> contactMap = new HashMap<String, Object>();
			contactMap.put("contactDcid", contactDcid);
			if(caseContactDao.countCCByParams(contactMap) > 0){
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
//			String householdLocation = row.get(CaseContactExcelUtil.RESOURCE_HEAD_HOUSEHOLD_LOCATION_AC).trim();
//			if (StringHelper.isTrimEmpty(householdLocation))
//			{
//				failNum++;
////				logger.info("第" + currentNum + "条商家ID不存在");
//				continue;
//			}
			String householdDcid = row.get(CaseContactExcelUtil.RESOURCE_HEAD_HOUSEHOLD_DCID_AC).trim();
			if (StringHelper.isTrimEmpty(householdDcid))
			{
				failNum++;
//				logger.info("第" + currentNum + "条商家ID不存在");
				continue;
			}
			CaseContactPo caseContactPo = new CaseContactPo(contactName, contactDcid, householdShip, "", now, userId, householdDcid);
			contactList.add(caseContactPo);
		}
		if(contactList.size() > 0){
			successNum = batchAddCaseContactList(contactList);
			System.out.println("批量导入了"+successNum+"个联系人");
//			successNum = contactListRes;
		}
		Map<String, Object> bindingMap = new HashMap<String, Object>();
		bindingMap.put("dcIds", dcIds);
		List<CaseBindContactPo> cbcList = deptCaseDao.getBindingCase(bindingMap);
//		List<CaseBindContactPo> cbcList = new LinkedList<CaseBindContactPo>();
		for (CaseBindContactPo caseBindContactPo : cbcList) {
			if(caseBindContactPo.getCaseId() != null && StringHelper.isNotEmpty(caseBindContactPo.getContactDcid())){
				caseBindContactPo.setBindType(BindTypeEnum.CASE_BIND.getValue());
				caseBindContactPo.setLastAccess(now);
			}
		}
		long cbcNum = caseBindContactDao.batchAddCBCList(cbcList);
		System.out.println("批量导入了"+cbcNum+"个案件绑定");
		
		return "导入成功" + successNum + "条,导入失败" + failNum + "条";
	}

	@Override
	public long batchAddCaseContactList(List<CaseContactPo> list) {
		long res = caseContactDao.batchAddCaseContactList(list);
		return res;
	}

	@Transactional
	@Override
	public String addContact(CaseContactVO caseContactVO) {
		long now = System.currentTimeMillis();
		String res = "error";
		if(caseContactVO.getCaseId() != null && StringHelper.isNotEmpty(caseContactVO.getContactNumber()) && caseContactVO.getContactAddUser() != null){
			String contactDcid = caseContactVO.getContactDcid();
			CaseContactPo caseContactPo = new CaseContactPo(caseContactVO.getContactName(), contactDcid, 
					caseContactVO.getHouseholdShip(), caseContactVO.getHouseholdLocation(), now, caseContactVO.getContactAddUser(), caseContactVO.getHouseholdDcid());
			Map<String, Object> contactMap = new HashMap<String, Object>();
			contactMap.put("contactDcid", contactDcid);
			int caseRes = 0, cbcRes = 0;
			if(StringHelper.isNotEmpty(contactDcid) && caseContactDao.countCCByParams(contactMap) > 0){
				LoginUserPo loginUserPo = new LoginUserPo();
				loginUserPo.setId(caseContactVO.getContactAddUser());
				LoginUserPo getUserPo = loginUserAO.getOneUser(loginUserPo);
				//当前登录用户不是超管
				if(getUserPo == null || UserLimitEnum.SUPPPER_LIMIT.getValue() != getUserPo.getUserLimit()){
					caseContactPo = new CaseContactPo(caseContactVO.getContactName(), caseContactVO.getOtherContactShip(), caseContactVO.getContactNumber(), caseContactVO.getContactLocation()	, caseContactVO.getContactRemark());
				}
				//证件号码出现重复:按照证件号码，修改联系人其他信息，并完成联系人和案件的绑定
				caseRes = caseContactDao.updateContactByPo(caseContactPo);
//				return "exist";//证件号码出现重复
			}else{
				caseRes = caseContactDao.addContact(caseContactPo);
			}
			long caseId = caseContactVO.getCaseId();
			CaseBindContactPo cbcPo = new CaseBindContactPo(now, caseId, contactDcid, BindTypeEnum.OTHER_BIND.getValue());
			cbcRes = caseBindContactDao.addCBC(cbcPo);
			if(caseRes > 0 || cbcRes > 0){
				res = "success";
			}
		}
		return res;
	}
//	private CaseContactPo getPoByVO(CaseContactVO caseContactVO){
//		CaseContactPo caseContactPo = new CaseContactPo(caseContactVO.getContactName(), caseContactVO.getContactDcid(), caseContactVO.getHouseholdShip(), caseContactVO.getHouseholdLocation(), caseContactVO.getLastAccess(), caseContactVO.getContactAddUser(), caseContactVO.getHouseholdDcid());
//	}
	@Resource
	private LoginUserAO loginUserAO;
	@Override
	public String editContact(CaseContactVO caseContactVO) {
		String res = "error";
		//联系人id不能为空，联系号码不能为空，当前登录用户id不能为空
		if(caseContactVO.getId() != null && StringHelper.isNotEmpty(caseContactVO.getContactNumber()) && caseContactVO.getContactAddUser() != null){
			LoginUserPo loginUserPo = new LoginUserPo();
			loginUserPo.setId(caseContactVO.getContactAddUser());
			LoginUserPo getUserPo = loginUserAO.getOneUser(loginUserPo);
			CaseContactPo caseContactPo = null;
			long now = System.currentTimeMillis();
			//当前登录用户为超管
			if(getUserPo != null && UserLimitEnum.SUPPPER_LIMIT.getValue() == getUserPo.getUserLimit()){
				caseContactPo = new CaseContactPo(caseContactVO.getContactName(), caseContactVO.getContactDcid(), 
						caseContactVO.getHouseholdShip(), caseContactVO.getHouseholdLocation(), now, caseContactVO.getContactAddUser(), caseContactVO.getHouseholdDcid());
			}else{
				//证件号码出现重复:按照证件号码，修改联系人其他信息，并完成联系人和案件的绑定
				caseContactPo = new CaseContactPo(caseContactVO.getContactName(), caseContactVO.getOtherContactShip(), caseContactVO.getContactNumber(), caseContactVO.getContactLocation()	, caseContactVO.getContactRemark());
			}
			int caseRes = caseContactDao.updateContactByPo(caseContactPo);
			if(caseRes > 0){
				res = "success";
			}
		}
		return res;
	}

}
