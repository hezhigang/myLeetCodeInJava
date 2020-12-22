/*
author: hezhigang
date: 12/21/20
time: 3:30 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    /**
     * Approach 1: Two Pointers
     * https://leetcode.com/problems/remove-element/solution/
     * 113 / 113 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 37.6 MB, less than 48.38% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement_v1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /**
     * Approach 2: Two Pointers - when elements to remove are rare
     * https://leetcode.com/problems/remove-element/solution/
     * 113 / 113 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Element.
     * Memory Usage: 37.7 MB, less than 48.38% of Java online submissions for Remove Element.
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        int n = nums.length;
        for (int i = 0; i < n; ) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else
                i++;
        }
        return n;
    }

    public static void main(String[] args) {
//        int[] nums = {3, 2, 2, 3};
//        int val = 3;
//        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
//        int val = 2;
//        int[] nums = {1};
//        int val = 1;
//        int[] nums = {3, 3};
//        int val = 3;
        int[] nums = {2};
        int val = 3;

        System.out.printf("%s", Arrays.toString(nums));
        System.out.println();

        int n = removeElement(nums, val);
        System.out.printf("%s, the new length = %d", Arrays.toString(nums), n);
    }
}