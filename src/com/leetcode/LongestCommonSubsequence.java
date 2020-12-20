/*
author: hezhigang
date: 12/19/20
time: 11:00 AM
*/
package com.leetcode;

/**
 * 1143. Longest Common Subsequence
 * https://leetcode.com/problems/longest-common-subsequence/
 */
public class LongestCommonSubsequence {

    /**
     * Longest common subsequence problem
     * Computing the length of the LCS
     * https://en.wikipedia.org/wiki/Longest_common_subsequence_problem
     * 43 / 43 test cases passed.
     * Runtime: 18 ms, faster than 17.54% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 42.8 MB, less than 51.59% of Java online submissions for Longest Common Subsequence.
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        final int LEN1 = text1.length(), LEN2 = text2.length();
        int[][] C = new int[LEN1 + 1][LEN2 + 1];
        for (int i = 1; i <= LEN1; i++) {
            for (int j = 1; j <= LEN2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    C[i][j] = C[i - 1][j - 1] + 1;
                } else {
                    C[i][j] = C[i - 1][j] > C[i][j - 1] ? C[i - 1][j] : C[i][j - 1];
                }
            }
        }
        return C[LEN1][LEN2];
    }

    public static void main(String[] args) {
//        String text1 = "abcde", text2 = "ace";
//        String text1 = "abcdefg", text2 = "dfh";
//        String text1 = "abc", text2 = "abc";
//        String text1 = "abc", text2 = "def";
//        String text1 = "bl", text2 = "yby";
//        String text1 = "psnw", text2 = "vozsh";
        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        int len = longestCommonSubsequence(text1, text2);
        System.out.printf("text1 = %s, text2 = %s, the length of their longest common subsequence = %d", text1, text2, len);
    }
}