//package com.aotest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import javax.annotation.Resource;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import com.deptcase.casemgt.ao.LoginUserAO;
//import com.deptcase.casemgt.dao.LoginUserDao;
//import com.deptcase.casemgt.entity.DeptCasePo;
//import com.deptcase.casemgt.entity.LoginUserPo;
//import com.deptcase.enums.UserLimitEnum;
//import com.deptcase.util.Pagination;
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations={"classpath:spring-mybatis.xml"})
//public class LoginUserAOTest {
//	@Resource
//	private LoginUserDao loginUserDao; 
//	@Resource
//	private LoginUserAO loginUserAO; 
//	
////	@Test
//	public void testList(){
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("name", "tiger");
////		loginUserDao.listUserByParams(params);
//		int userCount = loginUserDao.countUser(params);
////		Pagination<DeptCasePo> pagination = deptCaseAO.listCase(null, null);
////		System.out.println(pagination);
//		System.out.println("用户统计数："+userCount);
//	}
////	@Test
//	public void testAdd(){
//		String msg = loginUserAO.addUser(new LoginUserPo("tiger", "tiger", UserLimitEnum.SUPPPER_LIMIT.getValue(), "0", System.currentTimeMillis(), "第一个超管"));
//		System.out.println("添加情况："+msg);
//	}
//	@Test
//	public void testAddKey(){
//		 //useGeneratedKeys="true" keyProperty="id"
//		LoginUserPo loginUser = new LoginUserPo("zheng", "zheng", UserLimitEnum.ORDINARY_LIMIT.getValue(), "1", System.currentTimeMillis(), "第三个用户");
//		int msg = loginUserDao.addUserKey(loginUser);
//		System.out.println(loginUser.getId());
//		System.out.println("添加情况："+msg);
//	}
////	@Test
//	public void testEditUser(){
//		LoginUserPo loginUserPo = new LoginUserPo();
//		loginUserPo.setId(1);
//		loginUserPo.setPass("chicken");
//		String msg = loginUserAO.editUser(loginUserPo);
//		System.out.println("编辑情况："+msg);
//	}
////	@Test
//	public void testGetOneUser(){
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("name", "tiger");
//		LoginUserPo loginUserPo = loginUserDao.getOneUser(params);
//		System.out.println(loginUserPo.getPass());
//	}
//}
