/*
author: hezhigang
date: 5/22/21
time: 6:57 PM
*/
package com.leetcode;

/**
 * 1662. Check If Two String Arrays are Equivalent
 * https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/
 */
public class CheckStringArraysEquivalent {
    /**
     * 109 / 109 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Check If Two String Arrays are Equivalent.
     * Memory Usage: 36.7 MB, less than 88.84% of Java online submissions for Check If Two String Arrays are Equivalent.
     * @param word1
     * @param word2
     * @return
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < word1.length; i++)
            sb1.append(word1[i]);
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word2.length; i++)
            sb2.append(word2[i]);
        return sb1.toString().equals(sb2.toString());
    }
}
