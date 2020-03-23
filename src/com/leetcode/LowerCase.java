package com.leetcode;

/**
 * @author hezhigang
 * 709. To Lower Case
 * https://leetcode.com/problems/to-lower-case/
 */
public class LowerCase {
	
	/**
	 * jdk
	 * @param str
	 * @return
	 */
    public static String toLowerCase_jdk(String str) {
    	return str.toLowerCase();
    }
	
	/**
	 * Character
	 * @param str
	 * @return
	 */
    public static String toLowerCase(String str) {
    	String s = "";
    	for(int i=0;i<str.length();i++) {
    		s += Character.toLowerCase(str.charAt(i));
    	}
    	return s;
    }

	public static void main(String[] args) {
//		String s = "Hello";
		String s = "LOVELY";
		System.out.printf("Lower Case of %s: %s, %s", s, s.toLowerCase(), toLowerCase(s));
		System.out.println();
	}

}
