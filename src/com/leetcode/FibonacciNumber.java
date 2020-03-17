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
    public static int fib_dyn(int N) {
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

	public static void main(String[] args) {
		System.out.printf("F(%d)=%d", 2, fib(2));
		System.out.println();
		System.out.printf("F(%d)=%d", 3, fib(3));
		System.out.println();
		System.out.printf("F(%d)=%d", 4, fib(4));
	}

}
