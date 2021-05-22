/*
author: hezhigang
date: 5/22/21
time: 1:06 PM
*/
package com.leetcode;

/**
 * 1528. Shuffle String
 * https://leetcode.com/problems/shuffle-string/
 */
public class ShuffleString {
    /**
     * 399 / 399 test cases passed.
     * Runtime: 2 ms, faster than 28.58% of Java online submissions for Shuffle String.
     * Memory Usage: 41.9 MB, less than 5.19% of Java online submissions for Shuffle String.
     * @param s
     * @param indices
     * @return
     */
    public String restoreString(String s, int[] indices) {
        char[] t = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            t[indices[i]] = s.charAt(i);
        }
        return new String(t);
    }
}
