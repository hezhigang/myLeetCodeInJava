/*
author: hezhigang
date: 12/16/20
time: 10:36 AM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 268. Missing Number
 * https://leetcode.com/problems/missing-number/
 */
public class MissingNumber {

    /**
     * Bitwise operators — Facts and Hacks
     * 1. Compute XOR from 1 to n (direct method)
     * https://medium.com/@shashankmohabia/bitwise-operators-facts-and-hacks-903ca516f28c
     * @param n
     * @return
     */
    private static int computeXOR(int n) {
        if (n % 4 == 0) return n;
        if (n % 4 == 1) return 1;
        if (n % 4 == 2) return n + 1;
        else return 0;
    }

    /**
     * 122 / 122 test cases passed.
     * Runtime: 1 ms, faster than 40.83% of Java online submissions for Missing Number.
     * Memory Usage: 48 MB, less than 5.40% of Java online submissions for Missing Number.
     * @param nums
     * @return
     */
    public static int missingNumber_v1(int[] nums) {
        final int N = nums.length;
        int x = computeXOR(N);
        x = 0 ^ x;
        int y = nums[0];
        for (int i = 1; i < N; i++) {
            y = y ^ nums[i];
        }
        return x ^ y;
    }

    /**
     * That XOR Trick
     * Application 2: Finding the Missing Number
     * 122 / 122 test cases passed.
     * Runtime: 1 ms, faster than 40.83% of Java online submissions for Missing Number.
     * Memory Usage: 48.1 MB, less than 5.40% of Java online submissions for Missing Number.
     * https://florian.github.io/xor-trick/
     * @param nums
     * @return
     */
    public static int missingNumber_v2(int[] nums) {
        final int N = nums.length;
        int r = 0;
        for (int i = 1; i <= N; i++)
            r ^= i;
        for (int i = 0; i < N; i++) {
            r ^= nums[i];
        }
        return r;
    }

    /**
     * Approach #3 Bit Manipulation
     * https://leetcode.com/problems/missing-number/solution/
     * 122 / 122 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Number.
     * Memory Usage: 47.8 MB, less than 5.40% of Java online submissions for Missing Number.
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        final int N = nums.length;
        int r = N;
        for (int i = 0; i < N; i++)
            r ^= i ^ nums[i];
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
//        int[] nums = {0, 1};
//        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        int[] nums = {0};
        int i = missingNumber(nums);
        System.out.printf("%s", Arrays.toString(nums));
        System.out.println();
        System.out.printf("the only number in the range that is missing from the array=%d", i);
    }
}
