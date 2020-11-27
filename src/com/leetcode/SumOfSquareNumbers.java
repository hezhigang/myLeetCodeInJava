/*
author: hezhigang
date: 11/26/20
time: 1:16 PM
*/
package com.leetcode;

/**
 * 633. Sum of Square Numbers
 * https://leetcode.com/problems/sum-of-square-numbers/
 */
public class SumOfSquareNumbers {

    private static int mySqrt(int x) {
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

    private static boolean isPerfectSquare(int num) {
        long lo = 1, hi = num;
        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (mid * mid == num)
                return true;
            if (mid * mid > num) {
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return false;
    }

    /**
     * 124 / 124 test cases passed.
     * Runtime: 242 ms, faster than 5.54% of Java online submissions for Sum of Square Numbers.
     * Memory Usage: 37.6 MB, less than 14.48% of Java online submissions for Sum of Square Numbers.
     * @param c
     * @return
     */
    public static boolean judgeSquareSum_v1(int c) {
        if (c == 0 || c == 1)
            return true;
        int root = mySqrt(c);
        for (int i = root; i >= 0; i--) {
            int re = c - i * i;
            if (isPerfectSquare(re)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 124 / 124 test cases passed.
     * Runtime: 206 ms, faster than 7.18% of Java online submissions for Sum of Square Numbers.
     * Memory Usage: 35.5 MB, less than 93.83% of Java online submissions for Sum of Square Numbers.
     * @param c
     * @return
     */
    public static boolean judgeSquareSum_v2(int c) {
        if (c == 0 || c == 1)
            return true;
        for (int i = 0; i <= c/2; i++) {
            int re = c - i * i;
            if (re < 0)
                break;
            if (isPerfectSquare(re)) {
                return true;
            }
        }
        return false;
    }

    public static void trial_division(int n) {
        while (n % 2 == 0) {
            System.out.println(2);
            n /= 2;
        }
        int f = 3;
        while (f * f <= n) {
            if (n % f == 0) {
                System.out.println(f);
                n /= f;
            } else {
                f += 2;
            }
        }
        if (n != 1) {
            System.out.println(n);
        }
    }

    /**
     * Sum of two squares theorem
     * https://en.wikipedia.org/wiki/Sum_of_two_squares_theorem
     * 124 / 124 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Square Numbers.
     * Memory Usage: 35.7 MB, less than 74.91% of Java online submissions for Sum of Square Numbers.
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1)
            return true;

        while (c % 2 == 0) {
            c = c >> 1;
        }

        for (int p = 3; p * p <= c; p += 2) {
            int k = 0;
            if (c % p == 0) {
                while (c % p == 0) {
                    k++;
                    c /= p;
                }
                if (p % 4 == 3 && (k & 1) == 1)
                    return false;
            }
        }
        return c % 4 != 3;
    }

    public static void main(String[] args) {
//        int c = 5;
//        int c = 4;
//        int c = 3;
//        int c = 2;
//        int c = 1;
//        int c = 0;
        int c = 2450;
//        int c = 3430;
        boolean b = judgeSquareSum(c);
        System.out.printf("%d %s sum of square numbers", c, b ? "is" : "is not");
    }
}
