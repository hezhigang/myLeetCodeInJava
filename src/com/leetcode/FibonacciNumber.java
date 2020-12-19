package com.leetcode;

import java.util.HashMap;
import java.util.Map;

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
    public static int fib_recur(int N) {
		int r=0;
		if (N == 0)
			r = 0;
		if (N == 1)
			r = 1;
		if (N > 1)
			r = fib_recur(N - 1) + fib_recur(N - 2);
		return r;
    }

	/**
	 * Dynamic Programming
	 * @param N
	 * @return
	 */
	public static int fib_dp_v1(int N) {
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
     * Dynamic Programming
	 * bottom-up approach
	 * https://en.wikipedia.org/wiki/Dynamic_programming
	 * 31 / 31 test cases passed.
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 35.8 MB, less than 36.87% of Java online submissions for Fibonacci Number.
     * @param N
     * @return
     */
	public static int fib_dp_bottom_up(int N) {
		if (N == 0)
			return 0;
		int previousFib = 0, currentFib = 1;
		int newFib = 0;
		for (int i = 1; i < N; i++) {
			newFib = previousFib + currentFib;
			previousFib = currentFib;
			currentFib = newFib;
		}
		return currentFib;
	}

	/**
	 * top-down approach
	 * 31 / 31 test cases passed.
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 36 MB, less than 25.69% of Java online submissions for Fibonacci Number.
	 * @param N
	 * @return
	 */
	public static int fib(int N) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 0);
		map.put(1, 1);
		map.put(2, 1);
		map.put(3, 2);
		map.put(4, 3);
		map.put(5, 5);
		map.put(6, 8);
		map.put(7, 13);
		map.put(8, 21);
		map.put(9, 34);
		map.put(10, 55);
		map.put(11, 89);
		map.put(12, 144);
		map.put(13, 233);
		map.put(14, 377);
		map.put(15, 610);
		map.put(16, 987);
		map.put(17, 1597);
		map.put(18, 2584);
		map.put(19, 4181);
		map.put(20, 6765);
		map.put(21, 10946);
		map.put(22, 17711);
		map.put(23, 28657);
		map.put(24, 46368);
		map.put(25, 75025);
		map.put(26, 121393);
		map.put(27, 196418);
		map.put(28, 317811);
		map.put(29, 514229);
		map.put(30, 832040);
		if (!map.containsKey(N))
			map.put(N, fib(N - 1) + fib(N - 2));
		return map.get(N);
	}

	/**
	 * 31 / 31 test cases passed.
	 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Fibonacci Number.
	 * Memory Usage: 35.7 MB, less than 69.84% of Java online submissions for Fibonacci Number.
	 * @param N
	 * @return
	 */
	public int fib_naive(int N) {
		int[] table = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040};
		return table[N];
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
		System.out.printf("F(%d)=%d", 2, fib(2));
		System.out.println();
		System.out.printf("F(%d)=%d", 3, fib(3));
		System.out.println();
		System.out.printf("F(%d)=%d", 4, fib(4));
		System.out.println();
		System.out.printf("F(%d)=%d", 30, fib(30));
	}

}
