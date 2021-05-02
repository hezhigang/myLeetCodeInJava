/*
author: hezhigang
date: 4/26/21
time: 5:04 PM
*/
package com.leetcode;

/**
 * 334. Increasing Triplet Subsequence
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class IncreasingTripletSubsequence {

    /**
     * Increasing triplet subsequence problem
     * https://medium.com/@xiaogegexiao/increasing-triplet-subsequence-problem-995471b338f1
     * 75 / 75 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Increasing Triplet Subsequence.
     * Memory Usage: 39.1 MB, less than 9.26% of Java online submissions for Increasing Triplet Subsequence.
     * @param nums
     * @return
     */
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < first)
                first = nums[i];
            if (nums[i] > first && nums[i] < second) {
                second = nums[i];
            }
            if (nums[i] > second)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 1, 5, 0, 4, 6};
//        int[] nums = {1, 2, 3, 4, 5};
//        int[] nums = {5, 4, 3, 2, 1};
        int[] nums = {0, 4, 2, 1, 0, -1, -3};
        System.out.println("Exist Increasing Triplet Subsequence? : " + increasingTriplet(nums));
    }
}
