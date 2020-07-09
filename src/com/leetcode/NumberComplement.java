package com.leetcode;

import java.math.BigInteger;

/**
 * 476. Number Complement
 * https://leetcode.com/problems/number-complement/
 * 1009. Complement of Base 10 Integer
 * https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class NumberComplement {

    public static int findComplement(int num) {
        // For any integer n, ~n, i.e., 2's complement of n will be -(n+1).
        String s = Integer.toBinaryString(num);
        int r = 0;
        final int N = s.length();
        if (s.charAt(N - 1) == '0')
            r = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (s.charAt(i) == '0')
                r += 2 << (N - 2 - i);
        }
        return r;
    }

    public static int findComplement_v2(int num) {
        // For any integer n, ~n, i.e., 2's complement of n will be -(n+1).
        String s = Integer.toBinaryString(num);
        int r = 0;
        final int N = s.length();
        char[] a = s.toCharArray();
        if (a[N - 1] == '0')
            r = 1;
        for (int i = N - 2; i >= 0; i--) {
            if (a[i] == '0')
                r += 2 << (N - 2 - i);
        }
        return r;
    }

    public static int findComplement_v1(int num) {
        int r = 0;
        String s = Integer.toBinaryString(num);
        final int N = s.length();
        char[] a = new char[N];
        for (int i = 0; i < N; i++) {
            a[i] = s.charAt(i) == '0' ? '1' : '0';
        }
        r = Integer.parseInt(String.valueOf(a),2);
        return r;
    }

    public static void main(String[] args) {
//        int num = 5;
//        int num = 1;
//        int num = 2;
//        int num = 7;
        int num = 10;
        int complement = findComplement(num);
        System.out.printf("complement number of %d = %d", num, complement);
    }
}
