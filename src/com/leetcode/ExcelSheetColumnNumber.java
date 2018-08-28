/**
 * 作者: 和志刚
 * 日期: 2018年8月28日
 * 时间: 下午12:26:39
 */
package com.leetcode;

/**
 * 171. Excel Sheet Column Number
 */
public class ExcelSheetColumnNumber {

	/**
	 * A -> 1
	 * Z -> 26
	 * @param s
	 * @return
	 */
    public static int titleToNumber(String s) {
    	int n = 0;
    	int len = s.length();
    	for(int i=s.length()-1;i>=0;i--) {
    		n += (Character.getNumericValue(s.charAt(i))-9)*Math.pow(26, len-i-1);
    	}
        return n;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s = "A";
//		String s = "AB";
		String s = "ZY";
//		String s = "AZ";
		for(int i=0;i<s.length();i++) {
			char c = s.charAt(i);
			System.out.println(c+"->"+Character.getNumericValue(c));
		}
		int n = titleToNumber(s);
		System.out.println(s+" -> "+n);
	}

}
