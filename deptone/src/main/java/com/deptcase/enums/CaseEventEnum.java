package com.deptcase.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 案件事件日志类型
 * @projectName:deptone
 * @className:CaseEventEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月11日 下午5:54:58
 * @version 1.0
 */
public enum CaseEventEnum {
	/**
	 * 案件导入-0
	 */
	CASE_IMPORT("案件导入",0),
	/**
	 * 案件分配-1
	 */
	CASE_DISTRIBUTE("案件分配",1),
	/**
	 * 案件联系方式添加-2
	 */
	CASE_CONTACT_ADD("案件联系方式添加",2),
	/**
	 * 案件通话记录添加-3
	 */
	CONTACT_RECORD_ADD("案件通话记录添加",3);
	/**
	 * 省漫游流量
	 */
//	PROVINCE_ROAMING("省漫游",2);
	
	
	private String desc;
	private int value;
	
	private CaseEventEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}

	public static CaseEventEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		CaseEventEnum resultEnum = null;

		// 获取附件类型枚举数组
		CaseEventEnum[] enumArray = CaseEventEnum.values();

		for (CaseEventEnum serviceTypeEnum : enumArray)
		{
			if(value.equals(serviceTypeEnum.getValue()))
			{
				resultEnum = serviceTypeEnum;
				break;
			}
		}

		return resultEnum;
	}
	
	/**
	 * @description:将枚举转换为MAP，转换成的MAP的key值为枚举值，value值为一个MAP，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:17
	 */
	public static Map<String, Map<String, Object>> toMap()
	{
		// 获取附件类型枚举数组
		CaseEventEnum[] enumArray = CaseEventEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (CaseEventEnum serviceTypeEnum : enumArray)
		{
			String key = String.valueOf(getEnum(serviceTypeEnum.getValue()));

			Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
			serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
			serviceTypeMap.put("value", serviceTypeEnum.getValue());

			enumMap.put(key, serviceTypeMap);
		}

		return enumMap;
	}
	
	/**
	 * @description:将枚举转换成list，其中每个值为一个Map，包含desc和value两个key，值分别为枚举的desc和value值
	 * @return
	 * @author:POP产品研发部 宁强
	 * @createTime:2017年4月26日 下午12:36:27
	 */
	public static List<Map<String, Object>> toList()
	{
		// 获取附件类型枚举数组
		CaseEventEnum[] enumArray = CaseEventEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (CaseEventEnum serviceTypeEnum : enumArray)
		{
			Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
			serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
			serviceTypeMap.put("value", serviceTypeEnum.getValue());

			attachmentTypeMapList.add(serviceTypeMap);
		}

		return attachmentTypeMapList;
	}
	/**
	 * @description: 话费业务类型枚举列表
	 * @return
	 * @author:微族通道代码设计人 宁强
	 * @createTime:2017年11月9日 下午3:53:04
	 */
//	public static List<Map<String, Object>> toHuaList()
//	{
//		// 获取附件类型枚举数组
//		ServiceTypeEnum[] enumArray = ServiceTypeEnum.values();
//		
//		// 定义枚举list
//		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);
//		
//		for (ServiceTypeEnum serviceTypeEnum : enumArray)
//		{
//			if(serviceTypeEnum.getValue() != PROVINCE_ROAMING.getValue()){
//				Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
//				serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
//				serviceTypeMap.put("value", serviceTypeEnum.getValue());
//				
//				attachmentTypeMapList.add(serviceTypeMap);
//			}
//		}
//		
//		return attachmentTypeMapList;
//	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
}
