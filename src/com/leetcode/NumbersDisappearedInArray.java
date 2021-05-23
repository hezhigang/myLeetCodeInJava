/*
author: hezhigang
date: 5/23/21
time: 12:39 AM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
 */
public class NumbersDisappearedInArray {

    /**
     * 33 / 33 test cases passed.
     * Runtime: 6 ms, faster than 37.69% of Java online submissions for Find All Numbers Disappeared in an Array.
     * Memory Usage: 64 MB, less than 5.08% of Java online submissions for Find All Numbers Disappeared in an Array.
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        final int N = nums.length;
        int[] arr = new int[N + 1];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                list.add(i);
            }
        }
        return list;
    }
}
