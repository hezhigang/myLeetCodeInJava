/*
author: hezhigang
date: 5/22/21
time: 3:15 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 1365. How Many Numbers Are Smaller Than the Current Number
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class Counter1365 {
    /**
     * 103 / 103 test cases passed.
     * Runtime: 4 ms, faster than 66.15% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * Memory Usage: 38.8 MB, less than 84.14% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
     * @param nums
     * @return
     */
    public int[] smallerNumbersThanCurrent(int[] nums) {
        final int N = nums.length;
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = nums[i];
        Arrays.sort(arr);
        int[] r = new int[N];
        for (int i = 0; i < N; i++) {
            int n = 0;
            for (int j = 0; j < N && arr[j] < nums[i]; j++) {
                n++;
            }
            r[i] = n;
        }
        return r;
    }
}
