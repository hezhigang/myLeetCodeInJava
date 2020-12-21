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
     *
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence_dp(String text1, String text2) {
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

    /**
     * Recursive LCS
     * https://www.ics.uci.edu/~eppstein/161/960229.html
     * 17 / 43 test cases passed.
     * Time Limit Exceeded
     * @param text1
     * @param text2
     * @return
     */
    public static int lcs_length(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty())
            return 0;
        else if (text1.charAt(0) == text2.charAt(0))
            return 1 + lcs_length(text1.substring(1), text2.substring(1));
        else
            return Math.max(lcs_length(text1.substring(1), text2), lcs_length(text1, text2.substring(1)));
    }

    /**
     * Hunt-Szymanski Algorithm(Match-List, 1977)
     * http://par.cse.nsysu.edu.tw/~lcs/Hunt-Szymanski%20Algorithm.php
     * @param stringA
     * @param stringB
     * @param m
     * @param n
     * @return
     */
    private static int huntSzymanski_lcs(char[] stringA, char[] stringB, int m, int n) {
        final int alphabet_size = 256;
        int i, j, k, LCS, high, low, mid;
        int[][] matchlist = new int[alphabet_size][];
        int[] L;
        for (i = 0; i < alphabet_size; i++) {
            matchlist[i] = new int[n + 2];
        }
        L = new int[n + 1];

        // make the matchlist
        for (i = 0; i < m; i++) {
            if (matchlist[stringA[i]][0] == 0) {
                matchlist[stringA[i]][0] = 0;

                for (k = 1, j = n - 1; j >= 0; j--) {
                    if (stringA[i] == stringB[j]) {
                        matchlist[stringA[i]][k] = j + 1;
                        k++;
                    }
                    matchlist[stringA[i]][k] = -1;
                }
            }
        }

        // finding the LCS
        for (LCS = 0, i = 0; i < m; i++) {
            for (j = 0; matchlist[stringA[i]][j] != -1; j++) {
                // if the number bigger then the biggest number in the L, LCS + 1
                if (matchlist[stringA[i]][j] > L[LCS]) {
                    LCS++;
                    L[LCS] = matchlist[stringA[i]][j];
                }
                // else, do the binary search to find the place to insert the number
                else {
                    high = LCS;
                    low = 0;
                    k = 0;
                    while (true) {
                        mid = low + ((high - low) / 2);
                        if (L[mid] == matchlist[stringA[i]][j]) {
                            k = 1;
                            break;
                        }
                        if (high - low <= 1) {
                            mid = high;
                            break;
                        }
                        if (L[mid] > matchlist[stringA[i]][j]) {
                            high = mid;
                        } else if (L[mid] < matchlist[stringA[i]][j]) {
                            low = mid;
                        }
                    }
                    if (k == 0) {
                        L[mid] = matchlist[stringA[i]][j];
                    }
                }
            }
        }
        return LCS;
    }

    /**
     * 43 / 43 test cases passed.
     * Runtime: 12 ms, faster than 32.13% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 39.2 MB, less than 92.10% of Java online submissions for Longest Common Subsequence.
     * @param text1
     * @param text2
     * @return
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        final int LEN1 = text1.length(), LEN2 = text2.length();
        return huntSzymanski_lcs(text1.toCharArray(), text2.toCharArray(), LEN1, LEN2);
    }

    public static void main(String[] args) {
//        String text1 = "abcde", text2 = "ace";
//        String text1 = "abcdefg", text2 = "dfh";
//        String text1 = "abc", text2 = "abc";
//        String text1 = "abc", text2 = "def";
//        String text1 = "bl", text2 = "yby";
//        String text1 = "psnw", text2 = "vozsh";
//        String text1 = "bsbininm", text2 = "jmjkbkjkv";
        String text1 = "pmjghexybyrgzczy", text2 = "hafcdqbgncrcbihkd";
        int len = longestCommonSubsequence(text1, text2);
        System.out.printf("text1 = %s, text2 = %s, the length of their longest common subsequence = %d", text1, text2, len);
    }
}