/*
author: hezhigang
date: 5/21/21
time: 3:40 PM
*/
package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 389. Find the Difference
 * https://leetcode.com/problems/find-the-difference/
 */
public class FindTheDifference {

    /**
     * 54 / 54 test cases passed.
     * Runtime: 8 ms, faster than 16.46% of Java online submissions for Find the Difference.
     * Memory Usage: 37.5 MB, less than 35.41% of Java online submissions for Find the Difference.
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference_hashmap(String s, String t) {
        char r = ' ';
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char c = ' ';
        for (int i = 0; i < t.length(); i++) {
            c = t.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }
        for (int i = 0; i < s.length(); i++) {
            c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) - 1);
        }
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() > 0)
                r = e.getKey();
        }
        return r;
    }

    /**
     * 54 / 54 test cases passed.
     * Runtime: 2 ms, faster than 49.97% of Java online submissions for Find the Difference.
     * Memory Usage: 37.4 MB, less than 50.18% of Java online submissions for Find the Difference.
     * @param s
     * @param t
     * @return
     */
    public static char findTheDifference(String s, String t) {
        char c = ' ';
        s += t;
        int x = (int) (s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            x ^= (int) (s.charAt(i));
        }
        c = (char) x;
        return c;
    }

    public static void main(String[] args) {
//        String s = "abcd", t = "abcde";
//        String s = "", t = "y";
//        String s = "a", t = "aa";
        String s = "ae", t = "aea";
        System.out.printf("s=%s, the letter that was added to t=%s : %c", s, t, findTheDifference(s, t));
    }
}
