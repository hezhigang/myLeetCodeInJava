/**
 * 作者: 和志刚
 * 日期: 2018年6月24日
 * 时间: 下午4:49:17
 */
package com.leetcode;

/**
 * 7. Reverse Integer
 * Given a 32-bit signed integer, reverse digits of an integer.
 */
public class ReverseInteger {
	
    public static int reverse(int x) {
    	int r = 0;
    	if (x>Integer.MAX_VALUE || x<Integer.MIN_VALUE) {
    		return r;
    	}
    	String s = Integer.toString(x);
//        	System.out.println(s);
    	if (s!=null && !s.isEmpty()) {
    		String ss = "";
    		char c = 0;
    		if (x<0) 
    			s = s.substring(1);
    		for(int i=s.length()-1;i>=0;i--) {
    			c = s.charAt(i);
    			ss += c;
    		}
    		if (x<0)
    			ss = '-'+ss;
    		System.out.println("ss="+ss);
    		try {
    		    r = Integer.parseInt(ss);
    		} catch (NumberFormatException ex) {
    			r = 0;
    		}
    	}    		
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
		
		String input = "9646324351";
//		String pattern ="-?\\d+";
		if(input.matches("-?\\d+")){
			System.out.println(input+"是数字");
		}
		else {
			System.out.println(input+"不是数字");
		}
//		int k = 9646324351;
		
//		int i5 = Integer.parseInt(input);
//		System.out.println(""+i5);
		
		int i4 = 1534236469;
		int r4 = reverse(i4);
		System.out.println("i4="+i4+", r4="+r4);		
	}

}
