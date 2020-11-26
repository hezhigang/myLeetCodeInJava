/*
author: hezhigang
date: 11/25/20
time: 2:32 PM
*/
package com.leetcode;

/**
 * 367. Valid Perfect Square
 * https://leetcode.com/problems/valid-perfect-square/
 */
public class ValidPerfectSquare {

    /**
     * 70 / 70 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Perfect Square.
     * Memory Usage: 35.8 MB, less than 46.67% of Java online submissions for Valid Perfect Square.
     * @param num
     * @return
     */
    public static boolean isPerfectSquare(int num) {
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

    public static void main(String[] args) {
//        int num = 16;
//        int num = 14;
        int num = 808201;
//        int num = 36;
//        int num = 37;
        boolean b = isPerfectSquare(num);
        System.out.printf("%d %s a perfect square", num, b ? "is" : "is not");
    }
}
