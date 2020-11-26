/**
 * 作者: 和志刚
 * 日期: 2018年11月30日
 * 时间: 下午9:20:16
 */
package com.leetcode;

/**
 * 69. Sqrt(x)
 */
public class Sqrt {
	
	/**
	 * Square root of an integer
	 * https://www.geeksforgeeks.org/square-root-of-an-integer/
	 * @param x
	 * @return
	 */
	public static int mySqrtNaive(int x) {
		if (x==0 || x==1) return x;
		long i=1, result=1;
		while(result<=x) {
			i++;
			result = i*i;
		}
		return new Long(i-1).intValue();
	}
	
	/**
	 * https://www.geeksforgeeks.org/square-root-of-an-integer/
	 * Time Complexity: O(Log x)
	 * @param x
	 * @return
	 */
	public static int mySqrt2(int x) {
		if (x == 0 || x == 1)
			return x;

		long start = 1, end = x, ans = 0;
		while (start <= end) {
			long mid = (start + end) / 2;

			if (mid * mid == x)
				return new Long(mid).intValue();

			if (mid * mid < x) {
				start = mid + 1;
				ans = mid;
			} else
				end = mid - 1;
		}
		return new Long(ans).intValue();
	}
	
	/**
	 * Integer square root
	 * https://en.wikipedia.org/wiki/Integer_square_root
	 * @param x
	 * @return
	 */
	public static int mySqrt(int x) {
		if (x < 0)
			return 0;
		else if (x < 2)
			return x;
		else {
			long smallCandidate = mySqrt(x >> 2) << 1;
			long largeCandidate = smallCandidate + 1;
			if (largeCandidate*largeCandidate > x)
				return new Long(smallCandidate).intValue();
			else
				return new Long(largeCandidate).intValue();
		}
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		System.out.printf("The square root of %d is %d", 4, mySqrt(4));
//		System.out.println();
//		System.out.printf("The square root of %d is %d", 8, mySqrt(8));
//		System.out.println();
//		System.out.printf("The square root of %d is %d", 2148322500, mySqrt(2148322500));
//		System.out.println();
		System.out.printf("The square root of %d is %d, %f", 2147395600, mySqrt(2147395600), Math.sqrt(2147395600));
		System.out.println();
		System.out.printf("The square root of %d is %d, %f", 2147395600, mySqrtNaive(2147395600), Math.sqrt(2147395600));
		System.out.println();
		System.out.printf("The square root of %d is %d, %f", 2147395600, mySqrt2(2147395600), Math.sqrt(2147395600));
		System.out.println();
		System.out.printf("The square root of %d is %d, %f", 808201, mySqrt2(808201), Math.sqrt(808201));
	}

}
