/**
 * 作者: 和志刚
 * 日期: 2019年2月11日
 * 时间: 下午9:18:56
 */
package com.leetcode;

/**
 * 28. Implement strStr()
 * Java's indexOf()
 */
public class StrStr {
	
	/**
	 * jdk String indexOf
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public static int strStr_jdk(String haystack, String needle) {
    	if (needle.isEmpty()) return 0;
        return haystack.indexOf(needle);
    }
    
    /**
     * 模板串的特征向量
     * @param P
     * @return
     */
	public static int[] nextVector(String P) {
		int[] arr = new int[P.length()];
		arr[0] = 0;
		int k = 0;
		for (int i = 1; i < P.length(); i++) {
			k = arr[i - 1];

			while (k > 0 && P.charAt(i) != P.charAt(k)) {
				k = arr[k - 1];
			}

			if (P.charAt(i) == P.charAt(k))
				arr[i] = k + 1;
			else
				arr[i] = 0;
		}
		return arr;
	}   
    
    /**
     * 快速无回溯的字符串模式匹配
     * @param S
     * @param P
     * @param N
     * @param startIndex
     * @return
     */
	public static int findPat_KMP(String S, String P, int[] N, int startIndex) {
		int lastIndex = S.length() - P.length();
		if (lastIndex < startIndex)
			return -1;
		int i = startIndex, j = 0;
		for (; i < S.length(); i++) {
			while (P.charAt(j) != S.charAt(i) && j > 0)
				j = N[j - 1];
			if (S.charAt(i) == P.charAt(j))
				j++;
			if (j == P.length())
				return i - j + 1;
		}
		return -1;
	}    
    
	/**
	 * via Knuth–Morris–Pratt algorithm
	 * @param haystack
	 * @param needle
	 * @return
	 */
    public static int strStr(String haystack, String needle) {
    	if (needle.isEmpty()) return 0;
    	int[] arr = nextVector(needle);
    	if (needle.isEmpty()) return 0;
        return findPat_KMP(haystack,needle,arr,0);
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String haystack = "hello", needle = "ll";
		System.out.printf("%s in %s = %d", needle, haystack, haystack.indexOf(needle));
		System.out.printf("%s in %s = %d", needle, haystack, strStr(haystack,needle));
//		final String haystack = "aaaaa", needle = "bba";
//		System.out.printf("%s in %s = %d", needle, haystack, haystack.indexOf(needle));
	}

}
