package com.leetcode;

/**
 * @author hezhigang
 * 509. Fibonacci Number
 * https://leetcode.com/problems/fibonacci-number/
 */
public class FibonacciNumber {
	
	/**
	 * Recursion
	 * @param N
	 * @return
	 */
    public static int fib(int N) {
		int r=0;
		if (N == 0)
			r = 0;
		if (N == 1)
			r = 1;
		if (N > 1)
			r = fib(N - 1) + fib(N - 2);
		return r;
    }
    
    /**
     * Dynamic Programming
     * @param N
     * @return
     */
    public static int fib_dp(int N) {
		int r=0, recip1st=0, recip2nd=1;
		if (N == 0)
			r = 0;
		if (N == 1)
			r = 1;		
		for(int i=1; i<N; i++) {
			r = recip1st + recip2nd;
			recip1st = recip2nd;
			recip2nd = r;
		}
		return r;
    }
    
    /**
     * Binet's formula
     * @param N
     * @return
     */
    public static int fib_formula(int N) {
    	final double SQRT5 = Math.sqrt(5);
    	Double d = ( Math.pow((1+SQRT5)/2,N)-Math.pow((1-SQRT5)/2,N) )/SQRT5;
    	return d.intValue();
    }

	public static void main(String[] args) {
		System.out.printf("F(%d)=%d", 2, fib_formula(2));
		System.out.println();
		System.out.printf("F(%d)=%d", 3, fib_formula(3));
		System.out.println();
		System.out.printf("F(%d)=%d", 4, fib_formula(4));
	}

}
