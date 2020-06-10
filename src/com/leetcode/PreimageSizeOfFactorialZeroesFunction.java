package com.leetcode;

/**
 * 793. Preimage Size of Factorial Zeroes Function
 * https://leetcode.com/problems/preimage-size-of-factorial-zeroes-function/
 */
public class PreimageSizeOfFactorialZeroesFunction {

    public static int preimageSizeFZF(int K) {
        int count = 0;
        long r = search_rank(K);
        count = r==-1?0:5;
        return count;
    }

    private static long search_rank(long K) {
        long lo = 4*K;
        long hi = 5*K;
        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long y = f(mid);
            if (K < y)
                hi = mid - 1;
            else if (K > y)
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private static long f(long x) {
        long count = 0;
        for (long i = 5; i <= x; i *= 5)
            count += x / i;
        return count;
    }

    public static void main(String[] args) {
/*
        for(int i=0;i<=300;i++) {
            System.out.printf("%d <= f(%d)=%d <= %d ", i/5, i, f(i), i/4);
            if (i%5==4)
                System.out.println();
        }

 */

//        int K = 0;
//        int K = 5;
//        int K = 15;
//        int K = 60;
        int K = 1000000000;
        int n = preimageSizeFZF(K);
        System.out.println();
        System.out.printf("preimage size of f(x) = %d is %d\n", K, n);
    }

}
