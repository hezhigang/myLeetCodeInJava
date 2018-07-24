/**
 * 作者: 和志刚
 * 日期: 2018年7月23日
 * 时间: 下午12:01:08
 */
package com.leetcode;

/**
 * 7. Reverse Integer
 * Coud you solve it without converting the integer to a string?
 */
public class ReverseIntegerPro {
    public static int reverse(final int x) {
    	if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) {
    		return 0;
    	}
    	if (x==0) return 0;
    	int r = 0;
    	int remainder = 0;
    	long reverseNumber = 0L;
    	for(int t = x>0?x:-x; t>0; t/=10) {
    		remainder = t%10;
    		reverseNumber *= 10;  //2147483647
    		reverseNumber += remainder;
    	}
    	if (reverseNumber<Integer.MAX_VALUE)
    		r = Long.valueOf(reverseNumber).intValue();
    	else 
    		r = 0;
    	if (x<0)
    		r *= -1;    	
        return r;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int i1 = 123;
		int r1 = reverse(i1);
		System.out.println("i1="+i1+", r1="+r1);
		int i2 = -123;
		int r2 = reverse(i2);
		System.out.println("i2="+i2+", r2="+r2);
		int i3 = 120;
		int r3 = reverse(i3);
		System.out.println("i3="+i3+", r3="+r3);
		int i4 = 1534236469;
		int r4 = reverse(i4);
		System.out.println("i4="+i4+", r4="+r4);
	}

}
