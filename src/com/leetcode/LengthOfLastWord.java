/*
author: hezhigang
date: 4/16/21
time: 2:26 PM
*/
package com.leetcode;

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */
public class LengthOfLastWord {

    /**
     * 58 / 58 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
     * Memory Usage: 37.3 MB, less than 49.80% of Java online submissions for Length of Last Word.
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {
        int len = 0;
        s = s.trim();
        String w = s.substring(s.lastIndexOf(" ") + 1);
        if (w != null && !w.isEmpty())
            len = w.length();
        return len;
    }

    public static void main(String[] args) {
//        String s = "Hello World";
//		String s = " ";
//		String s = "Algorithms in a Nutshell";
        String s = "a ";
        System.out.printf("Length of Last Word %s: %d", s, lengthOfLastWord(s));
        System.out.println();
    }
}
