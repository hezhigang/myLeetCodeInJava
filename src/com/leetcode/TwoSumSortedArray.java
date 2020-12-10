/*
author: hezhigang
date: 12/9/20
time: 9:13 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 167. Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 */
public class TwoSumSortedArray {

    public static int search_rank(int[] nums, int lo, int hi, int target) {
        // Array must be sorted.
        while (lo <= hi) {
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid])
                hi = mid - 1;
            else if (target > nums[mid])
                lo = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    /**
     * 17 / 17 test cases passed.
     * Runtime: 2 ms, faster than 21.89% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 39.2 MB, less than 45.66% of Java online submissions for Two Sum II - Input array is sorted.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        final int N = numbers.length;
        int[] idxArr = {0, 0};
        for (int index1 = 0; index1 < N / 2 + 1; index1++) {
            int diff = target - numbers[index1];
            int lo = 0;
            int hi = index1 - 1;
            if (diff >= numbers[index1]) {
                lo = index1 + 1;
                hi = N - 1;
            }
            int index2 = search_rank(numbers, lo, hi, diff);
            if (index2 > -1) {
                idxArr[0] = index1 + 1;
                idxArr[1] = index2 + 1;
                return idxArr;
            }
        }
        return idxArr;
    }

    /**
     * 17 / 17 test cases passed.
     * Runtime: 191 ms, faster than 7.92% of Java online submissions for Two Sum II - Input array is sorted.
     * Memory Usage: 39.6 MB, less than 16.46% of Java online submissions for Two Sum II - Input array is sorted.
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum_brute_force(int[] numbers, int target) {
        final int N = numbers.length;
        int[] idxArr = {0, 0};
        for (int i = 0; i < N; i++)
            for (int j = N - 1; j > i; j--) {
                if (numbers[j] + numbers[i] == target) {
                    idxArr[0] = i + 1;
                    idxArr[1] = j + 1;
                    return idxArr;
                }
            }
        return idxArr;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
//        int[] nums = {2, 3, 4};
//        int target = 6;
//        int[] nums = {-1, 0};
//        int target = -1;
//        int[] nums = {1, 2, 3, 4, 4, 9, 56, 90};
//        int target = 8;
//        int[] nums = {5, 25, 75};
//        int target = 100;

        int[] idxArr = twoSum(nums, target);
        System.out.printf("nums=%s, target=%d, Output: %s", Arrays.toString(nums), target, Arrays.toString(idxArr));
    }
}
