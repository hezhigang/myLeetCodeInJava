package com.leetcode;

import java.util.Arrays;

/**
 * 1480. Running Sum of 1d Array
 * https://leetcode.com/problems/running-sum-of-1d-array/
 */
public class RunningSumofArray {

    public static int[] runningSum(int[] nums) {
        final int N = nums.length;
        int[] a = new int[N];
        a[0] = nums[0];
        for (int i = 1; i < N; i++) {
            a[i] = a[i - 1] + nums[i];
        }
        return a;
    }

    public static int[] runningSum_v2(int[] nums) {
        int[] a = new int[nums.length];
        a[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            a[i] = a[i - 1] + nums[i];
        }
        return a;
    }

    public static int[] runningSum_v1(int[] nums) {
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                a[i] += nums[j];
            }
        }
        return a;
    }

    public static void main(String[] args) {
//        int[] nums = { 1, 2, 3, 4 };
//        int[] nums = { 1, 1, 1, 1, 1 };
        int[] nums = { 3, 1, 2, 10, 1 };
        int[] runningSum = runningSum(nums);
        System.out.printf("running sum of %s as %s", Arrays.toString(nums), Arrays.toString(runningSum));
    }
}
