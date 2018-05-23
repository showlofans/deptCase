//package com.aotest;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.deptcase.casemgt.ao.CaseContactAO;
//import com.deptcase.casemgt.dao.CaseContactDao;
//import com.deptcase.casemgt.entity.CaseContactPo;
//
///**
// * @description: 案件联系人管理测试
// * @projectName:casemgt
// * @className:CaseContactAOTest.java
// * @author:微族通道代码设计人 宁强
// * @createTime:2018年5月22日 下午4:50:55
// * @version 1.0
// */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class CaseContactAOTest {
//
//	@Resource
//	private CaseContactAO caseContactAO;
//	@Resource
//	private CaseContactDao caseContactDao;
//	
////	@Test
////	public void testAddContact(){
////		CaseContactVO caseContactVO = new CaseContactVO("小明", "6217002020019662232", "哥哥", "广州", System.currentTimeMillis(), 1, "362425199310070017", 4l,"15888888888");
////		
////		String res = caseContactAO.addContact(caseContactVO);
////		System.out.println("添加结果:"+res);
////	}
////	@Test
////	public void testEditContact(){
////		CaseContactVO caseContactVO = new CaseContactVO("小明", "6217002020019662232", "哥哥", "广州", System.currentTimeMillis(), 1, "362425199310070017", 4l,"15888888888");
////		caseContactVO.setId(25l);
////		String res = caseContactAO.editContact(caseContactVO);
////		System.out.println("修改结果:"+res);
////	}
//	@Test
//	public void testgetContactByCaseId(){
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("caseId", 4);
//		List<CaseContactPo> contactList = caseContactDao.getContactByCaseId(params);
//		for (CaseContactPo caseContactPo : contactList) {
//			System.out.println(caseContactPo.getContactName()+"\t"+caseContactPo.getContactDcid());
//		}
//	}
//}
