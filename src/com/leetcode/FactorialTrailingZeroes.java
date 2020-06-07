package com.leetcode;

/**
 * 172. Factorial Trailing Zeroes
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeroes {

    public static int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        long x = 0;
        long p = 5;
        while (n >= p) {
            x += n / p;
            p *= 5;
        }
        Long l = new Long(x);
        return l.intValue();
    }

    public static int trailingZeroes_v2(int n) {
        if (n < 5)
            return 0;
        int m = logarithm(n, 5);
        System.out.println(m);
        int x = 0;
        for (int i = 1; i <= m; i++) {
            x += n / Math.pow(5, i);
        }
        return x;
    }

    /**
     * Program to compute Log n
     * https://www.geeksforgeeks.org/program-to-compute-log-n/
     * @param n
     * @param r
     * @return
     */
    static int logarithm(int n, int r) {
        return (n > r - 1) ? 1 + logarithm(n / r, r) : 0;
    }

    public static int trailingZeroes_v1(int n) {
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
//        int n = 25;
//        int n = 30;
//        int n = 125;
//        int n = 126;
//        int n = 625;
//        int n = 0;
//        int n = 50;
        int n = 1808548329;

        int c = trailingZeroes(n);
        int c1 = trailingZeroes_v1(n);
        int c2 = trailingZeroes_v2(n);

        System.out.printf("the number of trailing zeroes in %d! = %d \n", n, c);
        System.out.printf("the number of trailing zeroes in %d! = %d \n", n, c1);
        System.out.printf("the number of trailing zeroes in %d! = %d \n", n, c2);
    }
}
