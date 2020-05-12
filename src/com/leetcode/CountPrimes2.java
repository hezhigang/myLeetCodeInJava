package com.leetcode;

public class CountPrimes2 {

    public static int countPrimes(int n) {
        MeisselLehmerPrimeCounting ml = new MeisselLehmerPrimeCounting();
        ml.init();
        return new Long(ml.lehmer_pi(n)).intValue();
    }

    public static void main(String[] args) {
        int n = 1000000;
//        int n = 10;
//        int n = 2;
//        int n = 3;
//        int n = 11;
        int x = countPrimes(n);
        System.out.printf("the count of primes less than %d = %d", n, x);
        System.out.println();
    }
}
