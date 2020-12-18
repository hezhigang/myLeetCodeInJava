/*
author: hezhigang
date: 12/18/20
time: 1:24 PM
*/
package com.leetcode;

import java.util.PriorityQueue;

/**
 * 703. Kth Largest Element in a Stream
 * https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargestElementInStream {

    public static void main(String[] args) {
//        int k = 3;
//        int[] nums = {4, 5, 8, 2};
        int k = 1;
        int[] nums = {};
        KthLargest obj = new KthLargest(k, nums);
//        int val = 3;
        int val = -3;
        int param_1 = obj.add(val);
        System.out.printf("%d", param_1);
        System.out.println();
//        int param_2 = obj.add(5);
        int param_2 = obj.add(-2);
        System.out.printf("%d", param_2);
        System.out.println();
//        int param_3 = obj.add(10);
        int param_3 = obj.add(-4);
        System.out.printf("%d", param_3);
        System.out.println();
//        int param_4 = obj.add(9);
        int param_4 = obj.add(0);
        System.out.printf("%d", param_4);
        System.out.println();
        int param_5 = obj.add(4);
        System.out.printf("%d", param_5);
        System.out.println();
    }
}

/**
 * 10 / 10 test cases passed.
 * Runtime: 17 ms, faster than 49.28% of Java online submissions for Kth Largest Element in a Stream.
 * Memory Usage: 44.3 MB, less than 60.24% of Java online submissions for Kth Largest Element in a Stream.
 */
class KthLargest {
    private int k;
    private PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<Integer>(k);
        for(int i : nums) {
            minHeap.offer(i);
            if (minHeap.size()>k)
                minHeap.poll();
        }
    }

    public int add(int val) {
        minHeap.offer(val);
        if (minHeap.size()>k)
            minHeap.poll();
        return minHeap.peek();
    }
}
