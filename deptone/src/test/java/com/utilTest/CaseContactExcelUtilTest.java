//package com.utilTest;
//
//import java.io.File;
//import java.util.List;
//import java.util.Map;
//
//import org.junit.Test;
//
//import com.deptcase.casemgt.entity.CaseContactPo;
//import com.deptcase.util.CaseContactExcelUtil;
//import com.deptcase.util.StringHelper;
//
//public class CaseContactExcelUtilTest {
//	
//	
//	@Test
//	public void testImportFile(){
//		File file = new File("D:/Desktop/家属联系人.xlsx");
//		if(file != null){
//			List<Map<String, String>> excelContent = CaseContactExcelUtil.readExcel(file);
//			for (Map<String, String> row : excelContent)
//			{
//				System.out.println(row);
//			}
//		}
//	}
//	
////	public static void main(String[] args) {
////		int nums = 9;
////		int base = 3;
////		int zu = nums / base;//3组
////		for (int i = 0; i < zu; i++) {
////			for (int j = 0; j < base; j++) {
////				int k = i*base+j;
////				System.out.println("iCon:"+k);
////			}
////		}
////		
////		//0 1 2  
////		//3 4 5 
//////		System.out.println((nums % 3) +"\t"+((nums / 3)));
////	}
//	
//	
//}
