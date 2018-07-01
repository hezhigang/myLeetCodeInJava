/**
 * 作者: 和志刚
 * 日期: 2018年6月7日
 * 时间: 下午5:23:41
 */
package com.leetcode;

/**
 * Given a string, find the length of the longest substring without repeating characters.
Examples:
Given "abcabcbb", the answer is "abc", which the length is 3.
Given "bbbbb", the answer is "b", with the length of 1.
Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "abcabcbb";
		String s2 = "bbbbb";
		String s3 = "pwwkew";
		String s4 = "ABDEFGABEF";
//		int len1 = lengthOfLongestSubstring(s1);
//		System.out.println("s1="+s1+" ,len1="+len1);
		t(s4);
	}
	
    public static int lengthOfLongestSubstring(String s) {
        return 0;
    }
    
    public static void t(String s) {
    	int len = s.length();
    	for(int i=0;i<len;i++)
    		System.out.println(s.charAt(i));
    }

}
