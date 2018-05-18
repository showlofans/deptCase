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

import com.deptcase.casemgt.ao.DeptCaseAO;
import com.deptcase.casemgt.entity.DeptCasePo;
import com.deptcase.casemgt.url.DeptCaseUrl;
import com.deptcase.util.PageParam;
import com.deptcase.util.Pagination;
import com.deptcase.util.StringHelper;

/**
 * @description: 案件处理controller
 * @projectName:deptone
 * @className:DeptCaseController.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月11日 下午5:32:13
 * @version 1.0
 */
@Controller
@RequestMapping(value=DeptCaseUrl.MODOE_NAME)
public class DeptCaseController {

	@Resource
	private DeptCaseAO deptCaseAO;
	
	/**
	 * @description: 导入案件列表 
	 * @param pageNo
	 * @param deptCasePo
	 * @param request
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月12日 上午11:30:10
	 */
	@RequestMapping(value=DeptCaseUrl.LIST_CASE)
	public ModelAndView listCase(@RequestParam(value = "pageNo", required = false)String pageNo, DeptCasePo deptCasePo ,
			HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		PageParam pageParam = null;
		if(StringHelper.isNotEmpty(pageNo)){
			pageParam = new PageParam(Integer.parseInt(pageNo), 10);
		}else{
			pageParam = new PageParam(1, 10);
		}
		Pagination<DeptCasePo> pagination = deptCaseAO.listCase(deptCasePo, pageParam);
		resultMap.put("pagination", pagination);
		return new ModelAndView("/deptcase/deptcase_list", "resultMap", resultMap);
	}
	
	/**
	 * @description: 导入案件 
	 * @param request
	 * @param uploadFile
	 * @param response
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2018年5月11日 下午5:49:39
	 */
	@RequestMapping(value = DeptCaseUrl.IMPORT_CASE, method = RequestMethod.POST)
	@ResponseBody
	public void importCaseExcelBatch(HttpServletRequest request, MultipartFile uploadFile,HttpServletResponse response)
	{
//		AgencyBackwardVO agencyVO = (AgencyBackwardVO)request.getSession().getAttribute("loginContext");
		String returnMessage = "error";
		try
		{
			if (uploadFile != null && !uploadFile.isEmpty())
			{
				long size = uploadFile.getSize();
				byte[] data = new byte[(int) size];
				InputStream input = uploadFile.getInputStream();
				input.read(data);
				File folder = new File(request.getServletContext().getRealPath("/") + "deptcase/");
				if (!folder.exists())
				{
					folder.mkdir();
				}
				String uploadFileName = uploadFile.getOriginalFilename();
				String ExName = uploadFileName.substring(uploadFileName.lastIndexOf("."), uploadFileName.length());
				File outFile = new File(request.getServletContext().getRealPath("/") + "deptcase/" + "useranme" + ExName);
				if (!outFile.exists())
				{
					outFile.createNewFile();
				}
				FileOutputStream outStream = new FileOutputStream(outFile);

				outStream.write(data);
				outStream.close();
				input.close();
				returnMessage = deptCaseAO.importDeptCaseExcel("", outFile, 0);
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
