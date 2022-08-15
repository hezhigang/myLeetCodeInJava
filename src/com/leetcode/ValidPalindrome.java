/*
author: hezhigang
date: 10/28/20
time: 12:57 PM
*/
package com.leetcode;

/**
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/
 */
public class ValidPalindrome {

    /**
     * Runtime: 2 ms, faster than 98.05% of Java online submissions for Valid Palindrome.
     * Memory Usage: 39 MB, less than 5.64% of Java online submissions for Valid Palindrome.
     * @param s
     * @return
     */
    public static boolean isPalindrome_v1(String s) {
        final int N = s.length();
        char c1, c2;
        for (int i = 0, j = N - 1; i < j; ) {
            c1 = s.charAt(i);
            c2 = s.charAt(j);
            if (!Character.isLetterOrDigit(c1))
                i++;
            else if (!Character.isLetterOrDigit(c2))
                j--;
            else if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * 480 / 480 test cases passed.
     * Runtime: 883 ms, faster than 12.58% of Java online submissions for Valid Palindrome.
     * Memory Usage: 47.3 MB, less than 18.43% of Java online submissions for Valid Palindrome.
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        s = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        int N = s.length();
        for (int i = 0; i < N / 2; i++)
            if (s.charAt(i) != s.charAt(N - 1 - i))
                return false;
        return true;
    }

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        boolean b = isPalindrome(s);
        System.out.printf("%s %s a palindrome", s, b ? "is" : "is not");
    }
}