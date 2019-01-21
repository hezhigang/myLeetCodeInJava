/**
 * 作者: 和志刚
 * 日期: 2019年1月18日
 * 时间: 下午3:10:27
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class RomanToInteger {
	
	/**
	 * https://leetcode.com/problems/roman-to-integer/discuss/6520/JAVA-Easy-Version-To-Understand!!!!
	 * @param s
	 * @return
	 */
    public static int romanToInt(String s) {
    	if (s==null || s.isEmpty()) return -1;
    	Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);    	
    	char[] arr = s.toCharArray();
    	int len = arr.length;
    	int sum = map.get(arr[len-1]);
//    	for(int i=len-2;i>=0;i--) {
    	for(int i=0;i<len-1;i++) {
    		if (map.get(arr[i])>=map.get(arr[i+1])) {
    			sum += map.get(arr[i]);
    		}
    		else {
    			sum -= map.get(arr[i]);
    		}
    	}
        return sum;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "III";
		System.out.println(s1+"="+romanToInt(s1));
		String s2 = "IV";
		System.out.println(s2+"="+romanToInt(s2));
		String s3 = "IX";
		System.out.println(s3+"="+romanToInt(s3));
		String s4 = "LVIII";
		System.out.println(s4+"="+romanToInt(s4));
		String s5 = "MCMXCIV";
		System.out.println(s5+"="+romanToInt(s5));
	}

}