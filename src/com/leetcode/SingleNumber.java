/*
author: hezhigang
date: 12/14/20
time: 2:32 PM
*/
package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 136. Single Number
 * https://leetcode.com/problems/single-number/
 * Follow up: Could you implement a solution with a linear runtime complexity and without using extra memory?
 */
public class SingleNumber {

    /**
     * 61 / 61 test cases passed.
     * Runtime: 8 ms, faster than 42.20% of Java online submissions for Single Number.
     * Memory Usage: 39.8 MB, less than 22.36% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber_jdk(int[] nums) {
        Set<Integer> c = new HashSet<Integer>();
        for (int i : nums) {
            if (c.contains(i))
                c.remove(i);
            else
                c.add(i);
        }
        return c.iterator().next();
    }

    /**
     * 61 / 61 test cases passed.
     * Runtime: 5 ms, faster than 54.05% of Java online submissions for Single Number.
     * Memory Usage: 39.2 MB, less than 69.77% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber_bysort(int[] nums) {
        Arrays.sort(nums);
        final int N = nums.length;
        if (N == 1)
            return nums[0];
        if (nums[0] != nums[1])
            return nums[0];
        if (nums[N - 1] != nums[N - 2])
            return nums[N - 1];
        for (int i = 1; i < N - 1; i++) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i - 1]) {
                return nums[i];
            }
        }
        return nums[0];
    }

    /**
     * 61 / 61 test cases passed.
     * Runtime: 1 ms, faster than 94.97% of Java online submissions for Single Number.
     * Memory Usage: 39.1 MB, less than 79.60% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber_v1(int[] nums) {
        int r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            r = r ^ nums[i];
        }
        return r;
    }

    /**
     * 61 / 61 test cases passed.
     * Runtime: 1 ms, faster than 94.97% of Java online submissions for Single Number.
     * Memory Usage: 39.2 MB, less than 60.02% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber_v2(int[] nums) {
        int r = 0;
        for (int i : nums) {
            r = r ^ i;
        }
        return r;
    }

    /**
     * jdk8 stream
     * 61 / 61 test cases passed.
     * Runtime: 2 ms, faster than 55.66% of Java online submissions for Single Number.
     * Memory Usage: 39.2 MB, less than 69.77% of Java online submissions for Single Number.
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
//        return Arrays.stream(nums).map(e -> e).reduce((a, b) -> a ^ b).getAsInt();
        return Arrays.stream(nums).reduce(0, (a, b) -> a ^ b);
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 1};
//        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {1};
        int[] nums = {2, 1, 3, 4, 2, 4, 1};
        int i = singleNumber(nums);
        System.out.printf("%s", Arrays.toString(nums));
        System.out.println();
        System.out.printf("one element which appears only once=%d", i);
    }
}
