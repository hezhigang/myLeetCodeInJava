package com.leetcode;

import java.util.Arrays;

/**
 * 1470. Shuffle the Array
 * https://leetcode.com/problems/shuffle-the-array/
 */
public class ShuffleTheArray {

    public static int[] shuffle(int[] nums, int n) {
        int[] r = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            r[i] = (i & 1) == 1 ? nums[n + i / 2] : nums[i / 2];
        return r;
    }

    public static int[] shuffle_v1(int[] nums, int n) {
        int[] r = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            r[i] = nums[(i & 1) * n + i / 2];
        return r;
    }

    public static int[] shuffle_v3(int[] nums, int n) {
        int[] r = new int[2 * n];
        for (int i = 0; i < 2 * n; i++)
            r[i] = nums[((i & 1) == 1 ? n : 0) + i / 2];
        return r;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 5, 1, 3, 4, 7 };
        int n = 3;
        int[] shuffleArr = shuffle_v3(nums, n);
        System.out.printf("Output: %s\n\r", Arrays.toString(shuffleArr));
    }

    public static int[] shuffle_v2(int[] nums, int n) {
        int[] r = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            if ((i & 1) == 1) {
                r[i] = nums[n + i / 2];
            } else {
                r[i] = nums[i / 2];
            }
        }
        return r;
    }
}
