/**
 * 作者: 和志刚
 * 日期: 2018年12月23日
 * 时间: 下午6:02:16
 */
package com.leetcode;

/**
 * 393. UTF-8 Validation
 */
public class UTF8Validation {
	
    public static boolean validUtf8(int[] data) {
    	int count=0;
    	for(int k : data) {
    		if (count==0) {
    			if ((k>>5)==0b110) count=1;
    			else if ((k>>4)==0b1110) count=2;
    			else if ((k>>3)==0b11110) count=3;
    			else if ((k>>7)==1) return false;
    		}
    		else {
    			if ((k>>6)!=0b10) return false;
    			count--;
    		}
    	}
    	return count==0;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] data = {197, 130, 1};
		for(int i=0;i<data.length;i++)
			System.out.println( String.format("%8s",Integer.toBinaryString(data[i])).replace(' ', '0') );
		for(int i=0;i<data.length;i++) {
			System.out.println( Integer.toBinaryString(data[i]>>5) );
		}
		
		boolean b = validUtf8(data);
		System.out.println(b);
		
		System.out.println();
		int[] data2 = {235, 140, 4};
		for(int i=0;i<data2.length;i++)
			System.out.println( Integer.toBinaryString(data2[i]) );
//		System.out.println( String.format("%8s",Integer.toBinaryString(data2[i])).replace(' ', '0') );
		boolean b2 = validUtf8(data2);
		System.out.println(b2);
	}

}