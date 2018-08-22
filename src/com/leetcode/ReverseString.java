/**
 * 作者: 和志刚
 * 日期: 2018年8月22日
 * 时间: 上午6:59:20
 */
package com.leetcode;

/**
 * 344. Reverse String
 */
public class ReverseString {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s!=null && !s.isEmpty()) {
            for(int i=s.length()-1;i>=0;i--) {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
