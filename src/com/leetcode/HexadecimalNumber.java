package com.leetcode;

/**
 * @author hezhigang
 * 405. Convert a Number to Hexadecimal
 * https://leetcode.com/problems/convert-a-number-to-hexadecimal/
 */
public class HexadecimalNumber {
	
    public static String toHex(int num) {
    	char hex[]={'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    	String hexdec_num="";
    	if (num==0)
    		return "0";
    	else if (num>0) {
            int rem;
            while(num>0)
            {
                rem = num%16;
                hexdec_num = hex[rem] + hexdec_num;
                num = num/16;
            }
            return hexdec_num;    		
    	}
    	else {
    		num = ~num;
    		String s = "";
            for (int i = 0; i < 8; i++) {
                int n = 15 - num % 16;
                s += hex[n];
                num /= 16;
            }
            char[] charArr = s.toCharArray();
            for(int i=charArr.length-1;i>=0;i--)
            	hexdec_num+=charArr[i];
            return hexdec_num;
    	}
    }

	public static void main(String[] args) {
		int num1 = 26;
		String hex1 = Integer.toHexString(num1);
		System.out.printf("hexadecimal of %d is %s \n", num1, hex1);
		System.out.println(toHex(num1));
		
		System.out.println();
		
		int num2 = -1;
		String hex2 = Integer.toHexString(num2);
		System.out.printf("hexadecimal of %d is %s \n", num2, hex2);
		System.out.println(toHex(num2));
		
		System.out.println();
		int num3 = -2;
		String hex3 = Integer.toHexString(num3);
		System.out.printf("hexadecimal of %d is %s \n", num3, hex3);
		System.out.println(toHex(num3));
	}

}
