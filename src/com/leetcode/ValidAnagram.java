/*
author: hezhigang
date: 9/22/20
time: 9:47 AM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    /**
     * 16. Write Algorithms to Check if Two String are Anagram
     * https://dev.to/javinpaul/20-basic-algorithms-problems-from-coding-interviews-4o76
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram_sortchararray(String s, String t) {
        final int len_s = s.length();
        final int len_t = t.length();
        if (len_s != len_t)
            return false;
        char[] arr_s = s.toCharArray();
        char[] arr_t = t.toCharArray();
        Arrays.sort(arr_s);
        Arrays.sort(arr_t);
        for (int i = 0; i < len_s; i++) {
            if (arr_s[i] != arr_t[i])
                return false;
        }
        return true;
    }

    /**
     * HashMap
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram_hashmap(String s, String t) {
        final int len_s = s.length();
        final int len_t = t.length();
        if (len_s != len_t)
            return false;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            Character k = s.charAt(i);
            if (map.containsKey(k)) {
                Integer num = map.get(k);
                map.put(k, ++num);
            }
            else {
                map.put(k, 1);
            }
        }
        for (int i = 0; i < t.length(); i++) {
            Character k = t.charAt(i);
            if (map.containsKey(k)) {
                Integer num = map.get(k);
                map.put(k, --num);
            } else {
                return false;
            }
        }
        for (Integer count : map.values()) {
            if (count.intValue() != 0)
                return false;
        }
        return true;
    }

    /**
     * Approach #2 (Hash Table)
     * https://leetcode.com/problems/valid-anagram/solution/
     * @param s
     * @param t
     * @return
     */
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counter = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
//        String s = "rat", t = "car";
//        String s = "Army", t = "Mary";
        boolean b = isAnagram(s, t);
        System.out.printf("%s %s an anagram of %s", t, b ? "is" : "is not", s);
    }
}
