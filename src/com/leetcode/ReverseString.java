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
	
    public static String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        if (s!=null && !s.isEmpty()) {
        	char[] arr = s.toCharArray();
            for(int i=arr.length-1;i>=0;i--) {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
    
    public static String reverseString2(String s) {
        String r = "";
        if (s!=null && !s.isEmpty()) {
        	StringBuilder sb = new StringBuilder(s);
        	r = sb.reverse().toString();
        }
        return r;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "A man, a plan, a canal: Panama";
		System.out.println(s);
		System.out.println( reverseString2(s) );
	}

}
