package com.deptcase.util;

public class StringHelper {
	 public static boolean isNotEmpty(String string) {
	    return (string != null) && (string.length() > 0);
	 }
	
	 public static boolean isEmpty(String string) {
	    return (string == null) || (string.length() == 0);
	 }
	 public static boolean isTrimEmpty(String string) {
		 string = string.trim();
		 return (string == null) || (string.length() == 0);
	 }
}
