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
    public static String toLowerCase_java(String str) {
    	String s = "";
    	for(int i=0;i<str.length();i++) {
    		s += Character.toLowerCase(str.charAt(i));
    	}
    	return s;
    }

	/**
	 * 10 cool bitwise operator hacks and tricks every programmer must know
	 * Quickly convert character to lowercase and uppercase
	 * https://codeforwin.org/2018/05/10-cool-bitwise-operator-hacks-and-tricks.html
	 * 8 / 8 test cases passed.
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for To Lower Case.
	 * Memory Usage: 36.9 MB, less than 46.27% of Java online submissions for To Lower Case.
	 * @param str
	 * @return
	 */
	public static String toLowerCase(String str) {
		char[] a = str.toCharArray();
		for (int i = 0; i < a.length; i++) {
			a[i] = (char) (a[i] | ' ');
		}
		return String.valueOf(a);
	}

	public static void main(String[] args) {
		String s = "Hello";
//		String s = "LOVELY";
		System.out.printf("Lower Case of %s: %s, %s", s, s.toLowerCase(), toLowerCase(s));
		System.out.println();
	}

}
