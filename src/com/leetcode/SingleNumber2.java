/*
author: hezhigang
date: 12/15/20
time: 10:13 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 137. Single Number II
 * https://leetcode.com/problems/single-number-ii/
 * Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber2 {

    /**
     * LeetCode #137 Single Number II
     * https://lenchen.medium.com/leetcode-137-single-number-ii-31af98b0f462
     *
     * Python Bitwise Solution with Explanation
     * https://leetcode.com/problems/single-number-ii/discuss/936917/Python-Bitwise-Solution-with-Explanation
     *
     * 14 / 14 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Single Number II.
     * Memory Usage: 38.8 MB, less than 49.17% of Java online submissions for Single Number II.
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int lowBits = 0, highBits = 0;
        for (int num : nums) {
            lowBits = ~highBits & (lowBits ^ num);
            highBits = ~lowBits & (highBits ^ num);
        }
        return lowBits;
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 3, 2};
//        int[] nums = {0, 1, 0, 1, 0, 1, 99};
        int[] nums = {2, 9, 55, 256, 55, 2, 9, 2, 9, 55};
        int i = singleNumber(nums);
        Arrays.sort(nums);
        System.out.printf("%s", Arrays.toString(nums));
        System.out.println();
        System.out.printf("one element which appears only once=%d", i);
//        System.out.println();
//        System.out.printf("2^9^55^256=%d", 2 ^ 9 ^ 55 ^ 256);
    }
}