package com.deptcase.util;

import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @description: 联系人导入工具类
 * @projectName:casemgt
 * @className:CaseContactExcelUtil.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午1:20:01
 * @version 1.0
 */
public class CaseContactExcelUtil {
	public static final String RESOURCE_HEAD_CONTACT_NAME_AC = "联系人";
	public static final String RESOURCE_HEAD_CONTACT_DCID_AC = "证件号码";
	public static final String RESOURCE_HEAD_HOUSEHOLD_SHIP_AC = "户籍关系";
//	public static final String RESOURCE_HEAD_HOUSEHOLD_LOCATION_AC = "户籍地址";
	public static final String RESOURCE_HEAD_HOUSEHOLD_DCID_AC = "户主证件号码";
	public static final String ROW_KEYWORD = "户主";
	public static final int BASE_COLUMN_NUM = 3;//基本信息占多少列

	@SuppressWarnings("resource")
	public static List<Map<String, String>> readExcel(File excel) 
	{
		List<Map<String, String>> listMap = null;

		try
		{
			Workbook workbook = null;

			try
			{
				workbook = new XSSFWorkbook(excel.getPath());
			}
			catch (Exception e)
			{
				workbook = new HSSFWorkbook(new FileInputStream(excel));
			}

			for (int j = 0; j < 1; j++)
			{
				Sheet sheet = workbook.getSheetAt(j);

				Row row;
				Map<String, String> rows;
				if (sheet != null && sheet.getLastRowNum() > 0)
				{
					// 先获取sheet行数
					int iRowCount = sheet.getLastRowNum() + 1;

					// 获取整个表格的列数
					int iColumns = 0;
					for (int i = 0; i < iRowCount; i++)
					{
						if (sheet.getRow(i) != null)
						{
							int tempColumns = sheet.getRow(i).getLastCellNum();
							if (tempColumns > iColumns)
							{
								iColumns = tempColumns;
							}
						}
					}

					Map<Integer, String> m = new HashMap<Integer, String>(iColumns);
					int iRow = 0;

					// 获取表头
					for (iRow = 0; iRow < iRowCount; iRow++)
					{
						row = sheet.getRow(iRow);
						for (int iCol = 0; iCol < iColumns; iCol++)
						{
							if (row != null)
							{
								String cv = getCellValue(row.getCell(iCol));
								if (!"-".equals(cv) && !StringHelper.isEmpty(cv.trim()))
								{
									String h = cv.replace("\r", "").replace("\n", "");
									if (!StringHelper.isEmpty(h.trim()))
									{
										if(h.contains(RESOURCE_HEAD_CONTACT_NAME_AC)){
											h = RESOURCE_HEAD_CONTACT_NAME_AC;
										}
										m.put(iCol, h);
									}
								}
							}
						}
						// 判断是否为表头，则视为不是表头
						if (ObjectUtils.notEmpty(m) && m.size() > 1)
						{
							boolean headTag = false;

							for (Entry<Integer, String> e : m.entrySet())
							{
								if ("证件号码".equals(e.getValue().trim()) || "户籍关系".equals(e.getValue().trim()))
								{
									headTag = true;
									break;
								}
							}

							if (headTag)
							{
								break;
							}
						}
						else
						{
							m = new HashMap<Integer, String>(iColumns);
						}
					}

					// 判断是否取到表头
					if (ObjectUtils.notEmpty(m))
					{
						// 判断数据是否为空
						if (ObjectUtils.isEmpty(listMap))
						{
							listMap = new ArrayList<Map<String, String>>();
						}
						// 获取数据
						for (int i = iRow + 1; i < iRowCount; i++)
						{
							String houseHoldDcid = null;
							row = sheet.getRow(i);
							for (int iCol = 0; iCol < iColumns; iCol++){
								String cellValue = getCellValue(row.getCell(iCol));
								cellValue = (cellValue).replace(" ", "");
								String headM = m.get(iCol).trim();
								if(headM.equals(RESOURCE_HEAD_HOUSEHOLD_SHIP_AC) && ROW_KEYWORD.equals(cellValue)){
									houseHoldDcid = getCellValue(row.getCell(iCol-1));
									break;
									//把户籍关系的前一个表头必须是证件号码
								}
							}
							if(houseHoldDcid == null){
								continue;
							}
							int num = iColumns / BASE_COLUMN_NUM;//整除得到rowMap数量
							for (int k = 0; k < num; k++) {
								rows = new HashMap<String, String>(BASE_COLUMN_NUM);
								for (int t = 0; t < num; t++)
								{
									int iCol = BASE_COLUMN_NUM * k + t;
									
									if (m.containsKey(iCol) && row != null)
									{
										String cellValue = getCellValue(row.getCell(iCol));
										cellValue = (cellValue).replace(" ", "");
										String headM = m.get(iCol).trim();
										rows.put(headM, cellValue);
									}
								}
								rows.put(RESOURCE_HEAD_HOUSEHOLD_DCID_AC, houseHoldDcid);//最后加上户主id
//								System.out.println("每行的内容："+rows);
								listMap.add(rows);
							}
						}
					}
				}
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.out.println("读取Excel文档发生错误");
		}

		return listMap;
	}

	private static String getCellValue(Cell cell)
	{
		if (cell == null)
		{
			return "";
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_STRING)
		{
			return StringHelper.isEmpty(cell.getStringCellValue().trim()) ? "-" : cell.getStringCellValue();
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_NUMERIC)
		{
			String returnStr="";
			if(HSSFDateUtil.isCellDateFormatted(cell)){
				Date date = cell.getDateCellValue();
				DateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
				returnStr = formater.format(date);
			}else{
				  DecimalFormat df = new DecimalFormat("#");
				returnStr = String.valueOf(df.format(cell.getNumericCellValue()));
			}
			return returnStr;
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_BLANK)
		{
			return "";
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_BOOLEAN)
		{
			return String.valueOf(cell.getBooleanCellValue());
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_FORMULA)
		{
			String sValue = "";

			try
			{
				sValue = String.valueOf(cell.getNumericCellValue());
			}
			catch (Exception e)
			{
				sValue = cell.getStringCellValue();
			}

			return sValue;
		}
		else if (cell.getCellType() == XSSFCell.CELL_TYPE_ERROR)
		{
			return String.valueOf(cell.getErrorCellValue());
		}
		else
		{
			return "";
		}
	}
}
