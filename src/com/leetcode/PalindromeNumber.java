/**
 * 作者: 和志刚
 * 日期: 2018年6月25日
 * 时间: 上午9:32:55
 */
package com.leetcode;

/**
 * 9. Palindrome Number
 * Coud you solve it without converting the integer to a string?
 */
public class PalindromeNumber {
	
	/**
	 * C Program to Check Whether a Number is Palindrome or Not
	 * https://www.programiz.com/c-programming/examples/palindrome-number
	 * @param x
	 * @return
	 */
    public static boolean isPalindrome(final int x) {
    	boolean b =  false;
    	int originalInteger = x;
    	int reversedInteger = 0, remainder = 0;
    	int t = x;
        while (t>0) {
        	remainder = t%10;
        	reversedInteger = reversedInteger*10+remainder;
        	t /= 10;
        }
        System.out.println("reversedInteger="+reversedInteger);
        if (originalInteger==reversedInteger)
        	b = true;
        return b;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i1=121;
		System.out.println(i1 + " is " + (isPalindrome(i1)?"":"not") + " Palindrome Number");
		int i2=-121;
		System.out.println(i2 + " is " + (isPalindrome(i2)?"":"not") + " Palindrome Number");
		int i3=10;
		System.out.println(i3 + " is " + (isPalindrome(i3)?"":"not") + " Palindrome Number");		
	}

}
