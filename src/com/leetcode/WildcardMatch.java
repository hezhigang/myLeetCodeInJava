/**
 * 作者: 和志刚
 * 日期: 2019年2月22日
 * 时间: 下午1:22:46
 */
package com.leetcode;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * 44. Wildcard Matching
 */
public class WildcardMatch {
	
	/**
	 * DP way and less space
	 * time (M*N)
	 * space(2N) N is the length of s
	 * http://vialgorithms.blogspot.com/2013/11/wildcard-matching.html
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch(String s, String p) {
        // these are strange case, edge case.  
        int pl = 0;  
        for (int i = 0; i < p.length(); i++) {  
             if (p.charAt(i) != '*') {  
                  pl++;  
             }  
        }  
        if (pl > s.length()) {  
             return false;  
        }  
        if (s.length() == 0 && pl == 0) {  
             return true;  
        }  
        // main function  
        boolean[][] store = new boolean[2][s.length() + 1];  
        store[0][0] = true;  
        store[1][0] = false;   
        for (int ps = 1; ps <= p.length(); ps++) {  
             // remember to check the first one. make "*" can match ""  
             if (p.charAt(ps - 1) == '*') {  
                  store[1][0] = store[0][0];  
             } else {  
                  store[1][0] = false;  
             }  
             for (int ss = 1; ss <= s.length(); ss++) {  
                  if (p.charAt(ps - 1) == '?'  
                            || p.charAt(ps - 1) == s.charAt(ss - 1)) {  
                       store[1][ss] = store[0][ss - 1];  
                  } else if (p.charAt(ps - 1) != '*') {  
                       store[1][ss] = false;  
                  } else {  
                       store[1][ss] = store[0][ss - 1] || store[1][ss - 1]  
                                 || store[0][ss];  
                  }  
             }  
             for (int i = 0; i <= s.length(); i++) {  
                  store[0][i] = store[1][i];  
             }  
        }  
        return store[1][s.length()]; 		
	}
	
	/**
	 * 940 / 1808 test cases passed.
	 * Status: Time Limit Exceeded
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isMatch_regex(String s, String p) {
//		Pattern pattern = Pattern.compile(p);
//		Matcher matcher = pattern.matcher(s);
//		return matcher.matches();
		boolean r = false;
		try {
			r = Pattern.matches(p.replaceAll("(\\*){2,}","[a-z| ]*").replaceAll("\\*", "[a-z| ]*").replaceAll("\\?", "[a-z| ]{1}"),s);
//			r = Pattern.matches(p.replaceAll("(\\*){2,}",".*?").replace("?", ".?").replace("*", ".*?"),s);
		}
		catch (PatternSyntaxException ex) {
			System.out.println(ex.getDescription());
			System.out.println(ex.getMessage());
			System.out.println(ex.getPattern());
		}
		return r;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		final String s = "aa", p = "a";
//		String s = "aa", p = "*";
//		final String s = "cb", p = "?a";
//		final String s = "adceb", p = "*a*b";
//		final String s = "acdcb", p = "a*c?b";
		/*
		 * 940 / 1808 test cases passed.
		 * Status: Time Limit Exceeded
		 */
		//final String s = "aaaabaaaabbbbaabbbaabbaababbabbaaaababaaabbbbbbaabbbabababbaaabaabaaaaaabbaabbbbaababbababaabbbaababbbba",
		//p = "*****b*aba***babaa*bbaba***a*aaba*b*aa**a*b**ba***a*a*";
		final String s = "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
				p = "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb";

		System.out.printf("%s %s %s", s, isMatch(s,p)?"match":"not match", p);
	}

}
