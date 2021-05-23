/*
author: hezhigang
date: 5/23/21
time: 12:46 AM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * https://leetcode.com/problems/find-all-duplicates-in-an-array/
 */
public class FindDuplicatesInArray {
    /**
     * 28 / 28 test cases passed.
     * Runtime: 6 ms, faster than 50.21% of Java online submissions for Find All Duplicates in an Array.
     * Memory Usage: 64.1 MB, less than 5.07% of Java online submissions for Find All Duplicates in an Array.
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        final int N = nums.length;
        int[] arr = new int[N + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > 1) {
                list.add(i);
            }
        }
        return list;
    }
}
