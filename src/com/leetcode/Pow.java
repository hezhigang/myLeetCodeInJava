package com.leetcode;

/**
 * 50. Pow(x, n)
 * https://leetcode.com/problems/powx-n/
 * @author hezhigang
 *
 */
public class Pow {

	public static double myPow(double x, int n) {
		if (x==0.0d && n==0)
			return Double.POSITIVE_INFINITY;
		if (n>=0) {
			return myPow_recur(x, n);
		}
		else {
			double reciprocal = myPow_recur(x, -n);
			return 1.0/reciprocal;
		}
	}

	/**
	 * Efficiently implement power function | Recursive and Iterative - Techie Delight
	 * 3. Optimized Divide & Conquer solution
	 * https://www.techiedelight.com/power-function-implementation-recursive-iterative/
	 * @param x
	 * @param n non-negative integer
	 * @return
	 */
	public static double myPow_recur(double x, int n) {
		if (n==0) return 1;

		double square = myPow_recur(x,n/2);
		if ( (n & 1) == 1 ) {
			return x*square*square;
		}
		return square*square;
	}

	/**
	 * naive
	 * Time Limit Exceeded
	 * 1.00000^2147483647
	 * 299 / 304 test cases passed.
	 * @param x
	 * @param n
	 * @return
	 */
    public static double myPow_slow(double x, int n) {
    	if (x==0.0d && n==0)
    		return Double.POSITIVE_INFINITY;
        double y = 1;
        if (n==0)
        	y=1;
        if (n>0) {
        	for(int i=n;i>0;i--)
        		y*=x;
		}
        if (n<0) {
        	double reciprocal = 1;
        	for(int i=-n;i>0;i--)
				reciprocal*=x;
        	y = 1.0/reciprocal;
		}
        return y;
    }
	
	/**
	 * jdk
	 * @param x -100.0 < x < 100.0
	 * @param n 32-bit signed integer,
	 * @return
	 */
    public static double myPow_jdk(double x, int n) {
        return Math.pow(x, n);
    }

	public static void main(String[] args) {
//		double x = 2.00000;
//		int n = 10;
		
		double x = 2.10000;
		int n = 3;
		
//		double x = 2.00000;
//		int n = -2;
		
		double y = myPow_jdk(x,n);
		double y2 = myPow_slow(x,n);
		double y3 = myPow(x,n);
		
		System.out.printf("%f^%d = %f", x, n, y);
		System.out.println();
		System.out.printf("%f^%d = %f", x, n, y2);
		System.out.println();
		System.out.printf("%f^%d = %f", x, n, y3);
	}

}