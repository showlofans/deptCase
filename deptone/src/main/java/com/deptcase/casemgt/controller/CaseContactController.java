package com.deptcase.casemgt.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.deptcase.casemgt.ao.CaseContactAO;
import com.deptcase.casemgt.ao.DeptCaseAO;
import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.casemgt.url.CaseContactUrl;
import com.deptcase.util.DateUtil;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

/**
 * @description: 案件联系人
 * @projectName:casemgt
 * @className:CaseContactController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 上午9:48:55
 * @version 1.0
 */
@Controller
@RequestMapping(value=CaseContactUrl.MODOE_NAME)
public class CaseContactController {

	@Resource
	private CaseContactAO caseContactAO;
	
	/**
	 * @description:
	 * @param pageNo
	 * @param deptCasePo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月21日 下午3:30:35
	 */
//	@RequestMapping(value=CaseContactUrl.LIST_CASE_CONTACT)
//	public ModelAndView listCaseContact(@RequestParam(value = "pageNo", required = false)String pageNo, DeptCasePo deptCasePo ,
//			HttpServletRequest request){
//		Map<String, Object> resultMap = new HashMap<String, Object>();
//		PageParam pageParam = null;
//		if(StringHelper.isNotEmpty(pageNo)){
//			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
//		}else{
//			pageParam = new PageParam(1, 10);
//		}
////		Pagination<DeptCasePo> pagination = deptCaseAO.listCase(deptCasePo, pageParam);
////		resultMap.put("pagination", pagination);
//		return new ModelAndView("/deptcase/deptcase_list", "resultMap", resultMap);
//	}
	

	/**
	 * @description:导入案件联系人
	 * @param request
	 * @param uploadFile
	 * @param response
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月19日 上午9:47:54
	 */
	@RequestMapping(value = CaseContactUrl.IMPORT_CASE_CONTACT, method = RequestMethod.POST)
	@ResponseBody
	public void importCaseContactExcelBatch(HttpServletRequest request, MultipartFile contactFile,HttpServletResponse response)
	{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String returnMessage = "error";
		try
		{
			if (contactFile != null && !contactFile.isEmpty())
			{
				long size = contactFile.getSize();
				byte[] data = new byte[(int) size];
				InputStream input = contactFile.getInputStream();
				input.read(data);
				File folder = new File(request.getServletContext().getRealPath("/") + "caseContact/");
				if (!folder.exists())
				{
					folder.mkdir();
				}
				String uploadFileName = contactFile.getOriginalFilename();
				String nowTime = DateUtil.formatPramm(System.currentTimeMillis(), "yyyyMMddHHmmss");
				String ExName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
				File outFile = new File(request.getServletContext().getRealPath("/") + "caseContact/" + "useranme-"+nowTime + ExName);
				if (!outFile.exists())
				{
					outFile.createNewFile();
				}
				FileOutputStream outStream = new FileOutputStream(outFile);

				outStream.write(data);
				outStream.close();
				input.close();
				returnMessage = caseContactAO.importCaseContactExcel("me", outFile, 0);
			}
		}
		catch (IOException e)
		{
			returnMessage = "导入号码excel失败";
			e.printStackTrace();
		}
//		Map<String, Object> returnMap = new HashMap<String, Object>(2);
//		returnMap.put("message", returnMessage);
//		return new ModelAndView("success", "map", returnMap);
		try{
			response.setCharacterEncoding("utf-8");
			response.getWriter().print(returnMessage);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
