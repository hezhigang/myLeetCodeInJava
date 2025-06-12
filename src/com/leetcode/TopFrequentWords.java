/*
author: Zhigang He
date: June 11, 2025
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * 692. Top K Frequent Words
 * https://leetcode.com/problems/top-k-frequent-words/description/
 * Runtime 6ms Beats 97.81%
 * Memory 44.79MB Beats 74.46%
 */
public class TopFrequentWords {
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                int n = map.get(words[i]);
                map.put(words[i], n + 1);
            }
        }
        PriorityQueue<WordFreq> pq = new PriorityQueue<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pq.add(new WordFreq(entry.getKey(), entry.getValue()));
        }
        List<String> list = new ArrayList<>();
        for (; k > 0; k--) {
            list.add(pq.poll().word);
        }
        return list;
    }

    public static void main(String[] args) {
        // String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        // int k = 2;
        String[] words = { "the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is" };
        int k = 4;
        List<String> list = topKFrequent(words, k);
        System.out.println("[" + list.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");
    }

    private static class WordFreq implements Comparable<WordFreq> {
        private String word;
        private int freq;

        public WordFreq(String word, int freq) {
            this.word = word;
            this.freq = freq;
        }

        @Override
        public int compareTo(WordFreq that) {
            if (this.freq < that.freq)
                return 1;
            else if (this.freq > that.freq)
                return -1;
            else
                return this.word.compareTo(that.word);
        }
    }
}