package com.deptcase.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 案件联系人绑定类型
 * @projectName:casemgt
 * @className:BindTypeEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月19日 下午2:18:34
 * @version 1.0
 */
public enum BindTypeEnum {
	/**
	 * 案件关联人-0
	 */
	CASE_BIND("案件关联人",0),
	/**
	 * 其他关联-1
	 */
	OTHER_BIND("其他关联",1);
	
	private String desc;
	private int value;
	
	private BindTypeEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}

	public static BindTypeEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		BindTypeEnum resultEnum = null;

		// 获取附件类型枚举数组
		BindTypeEnum[] enumArray = BindTypeEnum.values();

		for (BindTypeEnum serviceTypeEnum : enumArray)
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
		BindTypeEnum[] enumArray = BindTypeEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (BindTypeEnum serviceTypeEnum : enumArray)
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
		BindTypeEnum[] enumArray = BindTypeEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (BindTypeEnum serviceTypeEnum : enumArray)
		{
			Map<String, Object> serviceTypeMap = new HashMap<String, Object>(2);
			serviceTypeMap.put("desc", serviceTypeEnum.getDesc());
			serviceTypeMap.put("value", serviceTypeEnum.getValue());

			attachmentTypeMapList.add(serviceTypeMap);
		}

		return attachmentTypeMapList;
	}
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
