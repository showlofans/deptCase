//package com.aotest;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.deptcase.casemgt.ao.DeptCaseAO;
//import com.deptcase.casemgt.entity.DeptCasePo;
//import com.deptcase.util.Pagination;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class DeptCaseAOTest {
//	@Resource
//	private DeptCaseAO deptCaseAO;
//	
//	@Test
//	public void testList(){
//		Pagination<DeptCasePo> pagination = deptCaseAO.listCase(null, null);
//		System.out.println(pagination);
//	}
//}
