/*
author: hezhigang
date: 10/5/20
time: 3:03 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/
 * Follow up:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class RotateArray {

    /**
     * brute force
     * 35 / 35 test cases passed.
     * Runtime: 183 ms, faster than 22.49% of Java online submissions for Rotate Array.
     * Memory Usage: 39.4 MB, less than 96.24% of Java online submissions for Rotate Array.
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int temp;
        final int N = nums.length;
        if (k >= N)
            k = k % N;
        for (; k > 0; k--) {
            temp = nums[N - 1];
            for (int i = N - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
//        int[] nums = {-1, -100, 3, 99};
//        int k = 2;
        System.out.printf("before rotate: %s", Arrays.toString(nums));
        rotate(nums, k);
        System.out.println();
        System.out.printf("after rotate the array to the right by %d steps: %s", k, Arrays.toString(nums));
    }
}