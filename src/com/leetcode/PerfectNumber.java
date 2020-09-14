/**
 * 
 */
package com.leetcode;

/**
 * @author hezhigang
 * 507. Perfect Number
 * https://leetcode.com/problems/perfect-number/
 */
public class PerfectNumber {

	/**
	 * 
	 * @param num
	 * @return
	 */
	public static boolean checkPerfectNumber(int num) {
		if ((num & 1) == 1)
			return false;
		else {
			if (num == 0)
				return false;
			int n = num;
			int p = 0;
			for (; (n & 1) == 0; p++) {
				n = n >> 1;
			}
			int x = (2 << (p - 1)) * ((2 << p) - 1);
			return num == x;
		}
	}
    
    /**
     * Time Limit Exceeded
     * @param num
     * @return
     */
    public static boolean checkPerfectNumber_timeout(int num) {
        int sum=1;
        for(int i=2;i<num;i++) {
            if (num%i==0) sum+=i;
        }
        return num==sum;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//      int num = 2;
//	  int num = 28;
//      int num = 100000000;
		int num = 0;
      boolean b = checkPerfectNumber(num);
      System.out.printf("%d %s a perfect number \n\r", num, b?"is":"is not");
	}

}
