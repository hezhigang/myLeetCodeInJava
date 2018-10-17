/**
 * 作者: 和志刚
 * 日期: 2018年10月17日
 * 时间: 下午3:35:15
 */
package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 */
public class ValidParentheses {
	
	/**
	 * https://cheonhyangzhang.wordpress.com/2015/09/14/20-leetcode-java-valid-parentheses-easy/
	 * @param s
	 * @return
	 */
    public static boolean isValid(String s) {
    	HashMap<Character, Character> pair = new HashMap<Character, Character>();
        pair.put(')','(');
        pair.put('}','{');
        pair.put(']','[');    	
        Stack<Character> stk = new Stack<Character>();
        char c = '\u0000';
        for(int i=0;i<s.length();i++) {
        	c = s.charAt(i);
        	switch(c) {
        	case '{':
        	case '[':
        	case '(':
        		stk.push(c);
        		break;
        	default:
        		if (stk.isEmpty() || pair.get(c)!=stk.pop())
        			return false;
        	}
        }
        if (stk.isEmpty())
        	return true;
        return false;
    }
    
    public static boolean isValid2(String s) {
    	char c = '\u0000';
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i=0;i<s.length();i++) {
    		c = s.charAt(i);
    		if (c=='(' || c==')' || c=='[' || c==']' || c=='{' || c=='}')
    			sb.append(c);
    	}
    	
    	String str = "";
    	if (sb!=null && sb.length()>0)
    		str = sb.toString();
    	
    	HashMap<Character, Character> pair = new HashMap<Character, Character>();
        pair.put(')','(');
        pair.put('}','{');
        pair.put(']','[');    	
        Stack<Character> stk = new Stack<Character>();
        
        for(int i=0;i<str.length();i++) {
        	c = str.charAt(i);
        	switch(c) {
        	case '{':
        	case '[':
        	case '(':
        		stk.push(c);
        		break;
        	default:
        		if (stk.isEmpty() || pair.get(c)!=stk.pop())
        			return false;
        	}
        }
        if (stk.isEmpty())
        	return true;
        return false;
    }    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "()";
		String s2 = "()[]{}";
		String s3 = "(]";
		String s4 = "([)]";
		String s5 = "{[]}";
		String s6 = "{abc[123](xyz)}";
		String s7 = "{123[456}abc]";
		
		System.out.println("Valid Parentheses of " + s1 + "="+ isValid(s1));
		System.out.println("Valid Parentheses of " + s2 + "="+ isValid(s2));
		System.out.println("Valid Parentheses of " + s3 + "="+ isValid(s3));
		System.out.println("Valid Parentheses of " + s4 + "="+ isValid(s4));
		System.out.println("Valid Parentheses of " + s5 + "="+ isValid(s5));
		
		System.out.println("Valid Parentheses of " + s6 + "="+ isValid(s6));
		System.out.println("Valid Parentheses of " + s6 + "="+ isValid2(s6));
		
		System.out.println("Valid Parentheses of " + s7 + "="+ isValid(s7));
		System.out.println("Valid Parentheses of " + s7 + "="+ isValid2(s7));		
	}

}
