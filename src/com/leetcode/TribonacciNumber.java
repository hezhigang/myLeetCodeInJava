/*
author: hezhigang
date: 12/12/20
time: 2:12 PM
*/
package com.leetcode;

/**
 * 1137. N-th Tribonacci Number
 * https://leetcode.com/problems/n-th-tribonacci-number/
 */
public class TribonacciNumber {

    /**
     * Dynamic Programming
     * 39 / 39 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for N-th Tribonacci Number.
     * Memory Usage: 35.8 MB, less than 47.18% of Java online submissions for N-th Tribonacci Number.
     * @param n
     * @return
     */
    public static int tribonacci(int n) {
        int T = 0;
        int T1 = 0, T2 = 1, T3 = 1;
        if (n == 0)
            T = 0;
        if (n == 1)
            T = 1;
        if (n == 2)
            T = 1;
        for (int i = 3; i <= n; i++) {
            T = T1 + T2 + T3;
            T1 = T2;
            T2 = T3;
            T3 = T;
        }
        return T;
    }

    public static void main(String[] args) {
        int n = 25;
        int T = tribonacci(n);
        System.out.printf("%d-th Tribonacci Number = %d", n, T);
    }
}
