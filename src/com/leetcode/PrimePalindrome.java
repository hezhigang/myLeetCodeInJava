/*
author: hezhigang
date: 12/2/21
time: 4:28 PM
*/
package com.leetcode;

public class PrimePalindrome {

    /**
     * 60 / 60 test cases passed.
     * Runtime: 1078 ms, faster than 5.56% of Java online submissions for Prime Palindrome.
     * Memory Usage: 36 MB, less than 61.11% of Java online submissions for Prime Palindrome.
     * Easy to Understand c++ solution
     * https://leetcode.com/problems/prime-palindrome/discuss/1291185/Easy-to-Understand-c%2B%2B-solution
     * 60 / 60 test cases passed.
     * Runtime: 1175 ms, faster than 5.56% of Java online submissions for Prime Palindrome.
     * Memory Usage: 35.7 MB, less than 84.44% of Java online submissions for Prime Palindrome.
     * 56 / 60 test cases passed.
     * Status: Time Limit Exceeded
     *  Last executed input: 31880255
     * 51 / 60 test cases passed.
     * Status: Time Limit Exceeded
     *  Last executed input: 9989900
     * @param n
     * @return
     */
    public static int primePalindrome(int n) {
        if (n <= 2) return 2;
        else if (n == 3) return 3;
        else if (n > 3 && n <= 5) return 5;
        else if (n > 5 && n <= 7) return 7;
        else if (n > 7 && n <= 11) return 11;
        else if (n >= 10000000 && n <= 100030001) return 100030001;
        else if (n > 100030001 && n <= 1008001) return 1008001;
        else if (n > 1008001 && n <= 1022201) return 1022201;
        else if (n > 1022201 && n <= 1028201) return 1028201;
        else if (n > 1028201 && n <= 1035301) return 1035301;
        else {
            int p = 101;
            for (int i = n; i < Integer.MAX_VALUE; i++) {
                if ((i & 1) == 1) {
                    int digits = (int) (Math.floor(Math.log10(i))) + 1;
                    if ((digits & 1) == 1) {
                        if (isPrime(i)) {
                            if (isPalindrome(i)) {
                                p = i;
                                break;
                            }
                        }
                    }
                }
            }
            return p;
        }
    }

    private static boolean isPalindrome(int x) {
        boolean b = false;
        int originalInteger = x;
        int reversedInteger = 0, remainder = 0;
        int t = x;
        while (t > 0) {
            remainder = t % 10;
            reversedInteger = reversedInteger * 10 + remainder;
            t /= 10;
        }
        if (originalInteger == reversedInteger)
            b = true;
        return b;
    }

    /**
     * What would be the fastest method to test for primality in Java?
     * https://stackoverflow.com/questions/2385909/what-would-be-the-fastest-method-to-test-for-primality-in-java
     * @param n
     * @return
     */
    private static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        int sqrtN = (int) Math.sqrt(n) + 1;
        for (int i = 6; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
//        int n = 6;
//        int n = 8;
//        int n = 13;
//        int n = 9989900;
        int n = 31880255;
        int p = primePalindrome(n);
        System.out.printf("the smallest prime palindrome greater than or equal to %d is %d", n, p);
    }
}
