/*
author: hezhigang
date: 4/15/21
time: 12:31 PM
*/
package com.leetcode;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 * https://leetcode.com/problems/top-k-frequent-elements/
 */
public class TopKFrequent {

    /**
     * Priority queues with comparators
     * 21 / 21 test cases passed.
     * Runtime: 11 ms, faster than 37.93% of Java online submissions for Top K Frequent Elements.
     * Memory Usage: 41.2 MB, less than 96.44% of Java online submissions for Top K Frequent Elements.
     * @param nums
     * @param k
     * @return
     */
    public static int[] topKFrequent(int[] nums, int k) {
        int[] a = new int[k];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>(k, Map.Entry.<Integer, Integer>comparingByValue().reversed());
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            maxHeap.offer(e);
        }

        while (k > 0) {
            a[--k] = maxHeap.poll().getKey();
        }

        return a;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 2, 2, 3};
//        int k = 2;
//        int[] nums = {1};
//        int k = 1;
//        int[] nums = {1, 2};
//        int k = 2;
        int[] nums = {1, 2, 1, 2, 3, 4, 5, 3, 5, 4, 2, 1, 5};
        int k = 3;

        int[] a = topKFrequent(nums, k);
        System.out.printf("Top %d Frequent Elements of %s is %s", k, Arrays.toString(nums), Arrays.toString(a));
    }
}
