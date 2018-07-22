/**
 * 作者: 和志刚
 * 日期: 2018年6月7日
 * 时间: 下午5:23:41
 */
package com.leetcode;

import java.util.LinkedHashMap;

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
		int len1 = lengthOfLongestSubstring(s1);
		int len2 = lengthOfLongestSubstring(s2);
		int len3 = lengthOfLongestSubstring(s3);
		int len4 = lengthOfLongestSubstring(s4);
		System.out.println("s1="+s1+" ,len1="+len1);
		System.out.println("s2="+s2+" ,len2="+len2);
		System.out.println("s3="+s3+" ,len3="+len3);
		System.out.println("s4="+s4+" ,len4="+len4);
//		t(s4);
	}
	
	/**
	 * How To Find Longest Substring Without Repeating Characters In Java?
	 * https://javaconceptoftheday.com/find-longest-substring-without-repeating-characters-java/
	 * @param s
	 * @return
	 */
    public static int lengthOfLongestSubstring(String s) {
    	String longestSubstring = null;
    	int maxUniqSubstrLen = 0;
    	if (!s.isEmpty()) {
        	LinkedHashMap<Character,Integer> map = new LinkedHashMap<Character,Integer>();
        	int len = s.length();
        	for(int i=0;i<len;i++) {
        		char ch = s.charAt(i);
        		if (!map.containsKey(ch)) {
        			map.put(ch, i);
        		}
        		else {
        			i = map.get(ch);  //key point
        			map.clear();
        		}
        		if (map.size()>maxUniqSubstrLen) {
        			maxUniqSubstrLen = map.size();
        			longestSubstring = map.keySet().toString();
        		}
        	}    		
    	}
    	System.out.println("Longest Substring Without Repeating Characters->:"+longestSubstring);
        return maxUniqSubstrLen;
    }
    
    public static void t(String s) {
    	int len = s.length();
    	for(int i=0;i<len;i++)
    		System.out.println(s.charAt(i));
    }

}
