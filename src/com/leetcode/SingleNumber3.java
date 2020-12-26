/*
author: hezhigang
date: 12/17/20
time: 10:28 PM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 260. Single Number III
 * https://leetcode.com/problems/single-number-iii/
 * Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 */
public class SingleNumber3 {

    /**
     * Single Number III
     * https://www.bookstack.cn/read/solve-leetcode-problems/problems-Single%20Number%20III.md
     * XOR with bitmask
     * https://leetcode.com/problems/single-number-iii/discuss/982092/Python3-XOR-with-bitmask
     * 32 / 32 test cases passed.
     * Runtime: 1 ms, faster than 96.24% of Java online submissions for Single Number III.
     * Memory Usage: 38.9 MB, less than 94.46% of Java online submissions for Single Number III.
     * @param nums
     * @return
     */
    public static int[] singleNumber(int[] nums) {
        int xorResult = 0, firstNum = 0, secondNum = 0;
        for (int num : nums) {
            xorResult ^= num;
        }

        int bitMask = xorResult & (~xorResult + 1);
//        int bitMask = result & (-result);

        for (int num : nums) {
            if ((bitMask & num) != 0)
                firstNum ^= num;
            else
                secondNum ^= num;
        }

        return new int[]{firstNum, secondNum};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2, 5};
//        int[] nums = {-1, 0};
//        int[] nums = {0, 1};
        int[] arr = singleNumber(nums);
        System.out.printf("%s", Arrays.toString(nums));
        System.out.println();
        System.out.printf("%s", Arrays.toString(arr));
        System.out.println();
    }
}
