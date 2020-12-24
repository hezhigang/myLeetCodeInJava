/*
author: hezhigang
date: 12/23/20
time: 5:09 PM
*/
package com.leetcode;

import java.util.Arrays;

public class LongestContinuousIncreasingSubsequence {

    /**
     * 36 / 36 test cases passed.
     * Runtime: 1 ms, faster than 98.29% of Java online submissions for Longest Continuous Increasing Subsequence.
     * Memory Usage: 39.9 MB, less than 41.25% of Java online submissions for Longest Continuous Increasing Subsequence.
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS_my(int[] nums) {
        final int N = nums.length;
        if (N < 2)
            return N;
        int len = 1, tempLen = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] > nums[i - 1]) {
                tempLen++;
            } else {
                if (tempLen > len)
                    len = tempLen;
                tempLen = 1;
            }
        }
        if (tempLen > len)
            len = tempLen;
        return len;
    }

    /**
     * Sliding Window
     * https://leetcode.com/problems/longest-continuous-increasing-subsequence/solution/
     * 36 / 36 test cases passed.
     * Runtime: 1 ms, faster than 98.29% of Java online submissions for Longest Continuous Increasing Subsequence.
     * Memory Usage: 39.7 MB, less than 70.15% of Java online submissions for Longest Continuous Increasing Subsequence.
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        int anchor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] <= nums[i - 1]) anchor = i;
            maxLen = Math.max(maxLen, i - anchor + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {1, 3, 5, 7};
//        int[] nums = {2, 2, 2, 2, 2};
        int[] nums = {1, 3, 5, 4, 2, 3, 4, 5};
        int len = findLengthOfLCIS(nums);
        System.out.printf("nums = %s, the length of the longest continuous increasing subsequence = %d", Arrays.toString(nums), len);
    }
}
