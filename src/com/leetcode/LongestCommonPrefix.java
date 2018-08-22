/**
 * 作者: 和志刚
 * 日期: 2018年8月22日
 * 时间: 下午12:46:24
 */
package com.leetcode;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * 14. Longest Common Prefix
 */
public class LongestCommonPrefix {
	
    public static String longestCommonPrefix(String[] strs) {
    	if (strs==null || strs.length==0) return "";
    	int minStrLen = strs[0].length();
    	int idx = 0;
    	for(int i=1;i<strs.length;i++) {
    		if (strs[i].length()<minStrLen) {
    			minStrLen = strs[i].length();
    			idx = i;
    		}
    	}
    	System.out.println("idx="+idx);
    	System.out.println("strs["+idx+"].length()="+strs[idx].length());
    	StringBuilder lcp = new StringBuilder();
    	if (strs[idx]!=null && strs[idx].length()>0) {
        	char ch = strs[idx].charAt(0);
        	boolean b = true;
        	for(int i=0;i<strs.length;i++) {
        		b = b && (strs[i].charAt(0)==ch?true:false);
        	}
        	if (b) {
        		lcp.append(ch);
        		for(int j=1;j<minStrLen;j++) {
        			ch = strs[idx].charAt(j);
        			b = true;
        			for(int i=0;i<strs.length;i++) {
        				b = b && (strs[i].charAt(j)==ch?true:false);
        			}
        			if (b) {
        				lcp.append(ch);
        			}
//        			else {
//        				break;
//        			}
        		}
        	}    		
    	}
        return lcp.toString();
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String[] strs = {"flower","flow","flight"};
//		String[] strs = {"dog","racecar","car"};
//		String[] strs = {"aca","cba"};
//		String[] strs = {"a"};
		String[] strs = {""};
		System.out.println(Arrays.stream(strs).collect(Collectors.joining( "," )));
		String lcp = longestCommonPrefix(strs);
		System.out.println("lcp="+lcp);
	}

}
