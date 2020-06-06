package com.leetcode;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        if (n == 0)
            return 0;
        Double d = Math.floor((Math.log(n)) / (Math.log(5)));
        int m = d.intValue();
        System.out.println(m);
        int x = 0;
        for (int i = 1; i <= m; i++) {
            x += n / Math.pow(5, i);
        }
        return x;
    }

    public static void main(String[] args) {
//        int n = 3;
//        int n = 5;
//        int n = 30;
//        int n = 126;
//        int n = 0;
        int n = 50;
        int c = trailingZeroes(n);
        System.out.printf("the number of trailing zeroes in %d! = %d", n, c);
    }
}
