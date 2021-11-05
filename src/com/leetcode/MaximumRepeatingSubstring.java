/*
author: hezhigang
date: 11/5/21
time: 10:41 AM
*/
package com.leetcode;

/**
 * 1668. Maximum Repeating Substring
 * https://leetcode.com/problems/maximum-repeating-substring/
 */
public class MaximumRepeatingSubstring {

    private static int countByPrefix(String sequence, String word) {
        int maxCount = 0;
        int tempCount = 0;
        int word_len = word.length();
        for (int i = 0; i <= sequence.length() - word_len; i++) {
            String str = sequence.substring(i, i + word_len);
            if (str.equals(word)) {
                tempCount++;
                i += word_len - 1;
            } else {
                tempCount = 0;
            }
            if (tempCount > maxCount)
                maxCount = tempCount;
        }
        return maxCount;
    }

    private static int countBySuffix(String sequence, String word) {
        int maxCount = 0;
        int tempCount = 0;
        int word_len = word.length();
        for (int i = sequence.length(); i > word_len - 1; i--) {
            String str = sequence.substring(i - word_len, i);
            if (str.equals(word)) {
                tempCount++;
                i = i - word_len + 1;
            } else {
                tempCount = 0;
            }
            if (tempCount > maxCount)
                maxCount = tempCount;
        }
        return maxCount;
    }

    /**
     * 212 / 212 test cases passed.
     * Runtime: 1 ms, faster than 82.84% of Java online submissions for Maximum Repeating Substring.
     * Memory Usage: 37.5 MB, less than 50.50% of Java online submissions for Maximum Repeating Substring.
     * @param sequence
     * @param word
     * @return
     */
    public static int maxRepeating(String sequence, String word) {
        int maxCount_prefix = countByPrefix(sequence, word);
        int maxCount_suffix = countBySuffix(sequence, word);
        return maxCount_prefix > maxCount_suffix ? maxCount_prefix : maxCount_suffix;
    }

    public static void main(String[] args) {
//        String sequence = "ababc";
//        String word = "ab";

//        String sequence = "ababc";
//        String word = "ba";

//        String sequence = "ababc";
//        String word = "ac";

//        String sequence = "aaabaaaabaaabaaaabaaaabaaaabaaaaba";
//        String word = "aaaba";

//        String sequence = "a";
//        String word = "a";

        String sequence = "abaabaabaababaabaaba";
        String word = "aba";

        int n = maxRepeating(sequence, word);
        System.out.printf("the maximum k-repeating value of %s in %s = %d", word, sequence, n);
        System.out.println();
    }
}