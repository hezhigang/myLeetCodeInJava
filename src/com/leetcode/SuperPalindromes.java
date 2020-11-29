/*
author: hezhigang
date: 11/28/20
time: 5:34 PM
*/
package com.leetcode;

/**
 * 906. Super Palindromes
 * https://leetcode.com/problems/super-palindromes/
 */
public class SuperPalindromes {

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

    public static boolean isPalindrome(final int x) {
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

    public static int superpalindromesInRange_TimeLimitExceeded(String L, String R) {
        int n = 0;
        int lo = Integer.parseInt(L);
        int hi = Integer.parseInt(R);
        for (int i = lo; i <= hi; i++) {
            if (isPalindrome(i) && isPerfectSquare(i) && isPalindrome(mySqrt2(i))) {
                n++;
            }
        }
        return n;
    }

    /**
     * Palindromic Square Numbers
     * http://www.fengyuan.com/palindrome.html
     * 48 / 48 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Super Palindromes.
     * Memory Usage: 36.8 MB, less than 97.83% of Java online submissions for Super Palindromes.
     * @param L
     * @param R
     * @return
     */
    public static int superpalindromesInRange(String L, String R) {
        long[] superPalindromes = {1, 4, 9, 121, 484, 10201, 12321, 14641, 40804, 44944, 1002001,
                1234321, 4008004, 100020001, 102030201, 104060401, 121242121, 123454321, 125686521,
                400080004, 404090404, 10000200001L, 10221412201L, 12102420121L, 12345654321L, 40000800004L,
                1000002000001L, 1002003002001L, 1004006004001L, 1020304030201L, 1022325232201L, 1024348434201L,
                1210024200121L, 1212225222121L, 1214428244121L, 1232346432321L, 1234567654321L, 4000008000004L,
                4004009004004L, 100000020000001L, 100220141022001L, 102012040210201L, 102234363432201L,
                121000242000121L, 121242363242121L, 123212464212321L, 123456787654321L, 400000080000004L,
                10000000200000001L, 10002000300020001L, 10004000600040001L, 10020210401202001L, 10022212521222001L,
                10024214841242001L, 10201020402010201L, 10203040504030201L, 10205060806050201L, 10221432623412201L,
                10223454745432201L, 12100002420000121L, 12102202520220121L, 12104402820440121L, 12122232623222121L,
                12124434743442121L, 12321024642012321L, 12323244744232321L, 12343456865434321L, 12345678987654321L,
                40000000800000004L, 40004000900040004L};
        int n = 0;
        long lo = Long.parseLong(L);
        long hi = Long.parseLong(R);
        for (int i = 0; i < superPalindromes.length; i++) {
            if (superPalindromes[i]>=lo && superPalindromes[i]<=hi)
                n++;
        }
        return n;
    }

    public static void main(String[] args) {
//        String L = "4", R = "1000";
//        String L = "92904622", R = "232747148";
        String L = "398904669", R = "13479046850";
        int n = superpalindromesInRange(L, R);
        System.out.printf("the number of superpalindromes in the inclusive range [%s, %s] = %d", L, R, n);
    }
}