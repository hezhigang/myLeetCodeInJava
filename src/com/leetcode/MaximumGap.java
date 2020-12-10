/*
author: hezhigang
date: 11/30/20
time: 1:52 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 164. Maximum Gap
 * https://leetcode.com/problems/maximum-gap/
 * Try to solve it in linear time/space.
 */
public class MaximumGap {

    /**
     * linearithmic
     * 18 / 18 test cases passed.
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Maximum Gap.
     * Memory Usage: 39.3 MB, less than 27.51% of Java online submissions for Maximum Gap.
     * @param nums
     * @return
     */
    public static int maximumGap_by_sort(int[] nums) {
        final int N = nums.length;
        if (N < 2)
            return 0;
        Arrays.sort(nums);
        int d = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i - 1] > d)
                d = nums[i] - nums[i - 1];
        }
        return d;
    }

    public static int maximumGap(int[] nums) {
        final int N = nums.length;
        if (N < 2)
            return 0;
        Arrays.sort(nums);
        int d = nums[1] - nums[0];
        for (int i = 2; i < N; i++) {
            if (nums[i] - nums[i - 1] > d)
                d = nums[i] - nums[i - 1];
        }
        return d;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 6, 9, 1};
//        int[] nums = {8, 2, 11, 4, 9};
        int[] nums = {1, 8, 3, 7, 18};
//        int[] nums = {10};
        int d = maximumGap(nums);
        System.out.printf("the maximum difference of %s is %d", Arrays.toString(nums), d);
    }
}
