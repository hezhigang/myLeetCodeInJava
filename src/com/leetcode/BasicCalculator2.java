/**
 * 作者: 和志刚
 * 日期: 2018年9月13日
 * 时间: 上午11:11:53
 */
package com.leetcode;

import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 227. Basic Calculator II
 */
public class BasicCalculator2 {
	
	/**
	 * 
	 * @param s
	 * @return
	 */
    public static int calculate(String s) {
    	System.out.println(s);
    	String expr = infix2postfix(s.replaceAll(" ", ""));
    	System.out.println(expr);
        return postfixCalculator(expr);
    }
    
	/**
	 * 后缀表达式计算器
	 * @param postfixExpr
	 * @return
	 */
	public static int postfixCalculator(String postfixExpr) {
		Stack stk = new Stack();
		char[] arr = postfixExpr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			int a, b, x;
			switch (c) {
			case '*':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a * b;
					stk.push(new Integer(x));
				}
				break;
			case '+':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = a + b;
					stk.push(new Integer(x));
				}
				break;
			case '-':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = b - a;
					stk.push(new Integer(x));
				}
				break;
			case '/':
				if (!stk.isEmpty()) {
					a = ((Integer) stk.pop()).intValue();
					b = ((Integer) stk.pop()).intValue();
					x = b / a;
					stk.push(new Integer(x));
				}
				break;
//			case '0':
//			case '1':
//			case '2':
//			case '3':
//			case '4':
//			case '5':
//			case '6':
//			case '7':
//			case '8':
//			case '9':
			default: 
				stk.push(new Integer(Character.digit(c, 10)));
				break;
			}
		}
		int ret = 0;
		if (!stk.isEmpty())
			ret = ((Integer) stk.pop()).intValue();
		return ret;
	}
	
	/**
	 * 把中缀表达式转换为后缀表达式
	 * @param infixExpr
	 * @return
	 */
	public static String infix2postfix(String infixExpr) {
		StringBuffer postfixExpr = new StringBuffer();
		Stack stk = new Stack();
		char[] arr = infixExpr.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			switch (c) {
			case '*':
			case '/':
				while (!stk.isEmpty() && (((Character) stk.peek()).charValue() == '*' || ((Character) stk.peek()).charValue() == '/')) {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				stk.push(new Character(c));
				break;
			case '+':
			case '-':
				while (!stk.isEmpty() && ((Character) stk.peek()).charValue() != '(') {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				stk.push(new Character(c));
				break;
			case '(':
				stk.push(new Character(c));
				break;
			case ')':
				while (!stk.isEmpty() && ((Character) stk.peek()).charValue() != '(') {
					postfixExpr.append(((Character) stk.pop()).charValue());
				}
				if (((Character) stk.peek()).charValue() == '(')
					stk.pop();
				break;
			default:
				postfixExpr.append(c);
			}
		}

		while (stk != null && !stk.isEmpty()) {
			postfixExpr.append(((Character) stk.pop()).charValue());
		}

		return postfixExpr.toString();
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s = "3+2*2";
//		String s = " 3/2 ";
//		String s = " 3+5 / 2 ";
		String s = "1*2-3/4+5*6-7*8+9/10";
		parse3(s);
		System.out.println( s + " = " + calculate(s) );
	}
	
	public static void parse(String s) {
//		String s = "1*2-3/4+5*6-7*8+9/10";
		String[] arr = s.split("[\\+\\-\\*/]");
		for(int i=0;i<arr.length;i++)
			System.out.println(arr[i]);
	}
	
	public static void parse2(String s) {
		Pattern pattern = Pattern.compile("[\\+\\-\\*/]");
		Matcher matcher = pattern.matcher(s);

		for (int i = 1; matcher.find(); i++)
			System.out.println("Token " + i + ": " + matcher.group());
	}
	
	public static void parse3(String s) {
		StringTokenizer st = new StringTokenizer(s,"[\\+\\-\\*/]",true);
		System.out.println(st.countTokens());
	     while (st.hasMoreTokens()) {
	         System.out.println(st.nextToken());
	     }		
	}	

}
