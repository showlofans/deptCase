package com.deptcase.enums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 用户类型
 * @projectName:casemgt
 * @className:UserLimitEnum.java
 * @author:微族通道代码设计人 宁强
 * @createTime:2018年5月21日 下午1:39:53
 * @version 1.0
 */
public enum UserLimitEnum {
	/**
	 * 超管-0：有导入权限
	 */
	SUPPPER_LIMIT("超管",0),
	/**
	 * 一般用户-1
	 */
	ORDINARY_LIMIT("一般用户",1);
	
	private String desc;
	private int value;
	
	private UserLimitEnum(String desc, int value) {
		this.desc = desc;
		this.value = value;
	}

	public static UserLimitEnum getEnum(Integer value)
	{
		if (value == null)
		{
			return null;
		}

		UserLimitEnum resultEnum = null;

		// 获取附件类型枚举数组
		UserLimitEnum[] enumArray = UserLimitEnum.values();

		for (UserLimitEnum serviceTypeEnum : enumArray)
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
		UserLimitEnum[] enumArray = UserLimitEnum.values();

		// 定义枚举MAP
		Map<String, Map<String, Object>> enumMap = new HashMap<String, Map<String, Object>>(enumArray.length);

		for (UserLimitEnum serviceTypeEnum : enumArray)
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
		UserLimitEnum[] enumArray = UserLimitEnum.values();

		// 定义枚举list
		List<Map<String, Object>> attachmentTypeMapList = new ArrayList<Map<String, Object>>(enumArray.length);

		for (UserLimitEnum serviceTypeEnum : enumArray)
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
