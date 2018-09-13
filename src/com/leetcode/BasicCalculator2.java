/**
 * 作者: 和志刚
 * 日期: 2018年9月13日
 * 时间: 上午11:11:53
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
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
//    	System.out.println(s);
    	List<String> expr = infix2postfix(s.replaceAll(" ", ""));
//    	for(int i=0;i<expr.size();i++)
//    		System.out.println(expr.get(i));
        return postfixCalculator(expr);
    }
    
	/**
	 * 后缀表达式计算器
	 * @param postfixExpr
	 * @return
	 */
	public static int postfixCalculator(List<String> postfixExpr) {
		Stack<Integer> stk = new Stack<Integer>();
//		char[] arr = postfixExpr.toCharArray();
		for (int i = 0; i < postfixExpr.size(); i++) {
			String s = postfixExpr.get(i);
			int a, b, x;
			switch (s) {
			case "*":
				if (!stk.isEmpty()) {
					a = stk.pop().intValue();
					b = stk.pop().intValue();
					x = a * b;
					stk.push(new Integer(x));
				}
				break;
			case "+":
				if (!stk.isEmpty()) {
					a = stk.pop().intValue();
					b = stk.pop().intValue();
					x = a + b;
					stk.push(new Integer(x));
				}
				break;
			case "-":
				if (!stk.isEmpty()) {
					a = stk.pop().intValue();
					b = stk.pop().intValue();
					x = b - a;
					stk.push(new Integer(x));
				}
				break;
			case "/":
				if (!stk.isEmpty()) {
					a = stk.pop().intValue();
					b = stk.pop().intValue();
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
				stk.push(new Integer(s));
				break;
			}
		}
		int ret = 0;
		if (!stk.isEmpty())
			ret = stk.pop().intValue();
		return ret;
	}
	
	/**
	 * 把中缀表达式转换为后缀表达式
	 * @param infixExpr
	 * @return
	 */
	public static List<String> infix2postfix(String infixExpr) {
		List<String> r = new ArrayList<String>();
//		StringBuffer postfixExpr = new StringBuffer();
		Stack<String> stk = new Stack<String>();
//		char[] arr = infixExpr.toCharArray();
		List<String> list = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(infixExpr,"[\\+\\-\\*/]",true);
	     while (st.hasMoreTokens()) {
	         list.add(st.nextToken());
	     }
		for (int i = 0; i < list.size(); i++) {
			String s = list.get(i);
			switch (s) {
			case "*":
			case "/":
				while (!stk.isEmpty() && (stk.peek().equals("*") || stk.peek().equals("/"))) {
					r.add( stk.pop() );
				}
				stk.push(s);
				break;
			case "+":
			case "-":
				while (!stk.isEmpty() && !stk.peek().equals("(")) {
					r.add( stk.pop() );
				}
				stk.push(s);
				break;
			case "(":
				stk.push(s);
				break;
			case ")":
				while (!stk.isEmpty() && !stk.peek().equals("(")) {
					r.add(stk.pop());
				}
				if (stk.peek().equals("("))
					stk.pop();
				break;
			default:
				r.add(s);
			}
		}

		while (stk != null && !stk.isEmpty()) {
			r.add( stk.pop() );
		}

		return r;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		String s = "1 + 1";
//		String s = " 2-1 + 2 ";
//		String s = "3+2*2";
//		String s = " 3/2 ";
//		String s = " 3+5 / 2 ";
		String s = "1*2-3/4+5*6-7*8+9/10";
//		String s = "(1+(4+5+2)-3)+(6+8)";
//		parse3(s);
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
