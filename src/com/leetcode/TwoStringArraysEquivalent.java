package com.leetcode;

/**
 * 1662. Check If Two String Arrays are Equivalent
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent
 */
public class TwoStringArraysEquivalent {

    /**
     * Accepted
     * Runtime 0ms Beats 100.00%of users with Java
     * Memory 40.73MB Beats 22.03%of users with Java
     * @param word1
     * @param word2
     * @return
     */
    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++)
            sb1.append(word1[i]);
        for (int j = 0; j < word2.length; j++)
            sb2.append(word2[j]);
        return sb1.toString().equals(sb2.toString());
    }

    public static void main(String[] args) {
        String[] word1 = {"ab", "c"};
        String[] word2 = {"a", "bc"};
        System.out.println(arrayStringsAreEqual(word1, word2));
    }
}
