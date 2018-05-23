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
//import com.deptcase.casemgt.ao.DeptCaseAO;
//import com.deptcase.casemgt.dao.DeptCaseDao;
//import com.deptcase.casemgt.entity.DeptCasePo;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class DeptCaseAOTest {
//	@Resource
//	private DeptCaseAO deptCaseAO;
//	
//	@Resource
//	private DeptCaseDao deptCaseDao;
//	
////	@Test
////	public void testList(){
////		Pagination<DeptCasePo> pagination = deptCaseAO.listCase(null, null);
////		System.out.println(pagination);
////	}
////	@Test
////	public void testdeptCaseDao(){
////		long caseId = 1l;
////		DeptCasePo deptCasePo = deptCaseDao.getOneCaseById(caseId);
////		System.out.println(deptCasePo.getCaseCustomer());
////	}
//	@Test
//	public void testListUndisCase(){
//		Map<String,Object> params = new HashMap<String, Object>();
//		params.put("caseAdmin", 0);
////		System.out.println(deptCaseDao.countCase(params));
//		List<DeptCasePo> deptList = deptCaseDao.listUnDisCase(params);
//		for (DeptCasePo deptCasePo : deptList) {
//			System.out.println(deptCasePo.getCaseCustomer());
//		}
//	}
//	
//}
