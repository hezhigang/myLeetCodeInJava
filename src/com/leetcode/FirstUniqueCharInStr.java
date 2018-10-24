/**
 * 作者: 和志刚
 * 日期: 2018年10月23日
 * 时间: 下午10:23:22
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 */
public class FirstUniqueCharInStr {
	
	/**
	 * Given a string, find its first non-repeating character
	 * https://www.geeksforgeeks.org/given-a-string-find-its-first-non-repeating-character/
	 * @param s
	 * @return
	 */
    public static int firstUniqChar_(String s) {
    	char[] count = new char[255];
    	for(int i=0;i<s.length();i++)
    		count[s.charAt(i)]++;
        int r = -1;
        for(int i=0;i<s.length();i++) {
        	if (count[s.charAt(i)]==1) {
        		r = i;
        		break;
        	}
        }
        return r;
    }
    
    /**
     * 
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
    	Map<Character,Integer> count = new HashMap<Character,Integer>();
    	char c = '\u0000';
    	for(int i=0;i<s.length();i++) {
    		c = s.charAt(i);
    		if (count.containsKey(c)) {
    			count.put(c, count.get(c)+1);
    		}
    		else {
    			count.put(c, 1);
    		}
    	}
    		
        int r = -1;
        for(int i=0;i<s.length();i++) {
        	if (count.get(s.charAt(i))==1) {
        		r = i;
        		break;
        	}
        }
        return r;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "leetcode";
//		String s = "loveleetcode";
		int i = firstUniqChar(s);
		System.out.printf("the first non-repeating character in %s = %d", s, i);
	}

}