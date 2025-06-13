/*
author: Zhigang He
date: June 12, 2025
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 451. Sort Characters By Frequency
 * https://leetcode.com/problems/sort-characters-by-frequency/description/
 * done by claude
 * Runtime 11ms Beats 89.04%
 * Memory 45.68MB Beats 65.87%
 */
public class SortCharsByFreq {
    /**
     * claude's solution
     * @param s
     * @return
     */
    public static String frequencySort(String s) {
        // Count frequency of each character
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        
        // Create a list of characters and sort by frequency (descending)
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        chars.sort((a, b) -> freqMap.get(b) - freqMap.get(a));
        
        // Build result string
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            int freq = freqMap.get(c);
            for (int i = 0; i < freq; i++) {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        // String s = "tree";
        // String s = "cccaaa";
        String s = "Aabb";
        System.out.println("Output: " + frequencySort(s));
    }
}