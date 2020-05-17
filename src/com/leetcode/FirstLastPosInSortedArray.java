package com.leetcode;

import java.util.Arrays;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 */
public class FirstLastPosInSortedArray {

    /**
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo<=hi) {
            int mid = lo + (hi - lo) / 2;
            if (target < nums[mid])
                hi = mid-1;
            else if (target > nums[mid])
                lo = mid+1;
            else {
                int startPos = mid;
                int endPos = mid;
                while(startPos>=0 && nums[startPos]==nums[mid]) startPos--;
                while(endPos<=nums.length - 1 && nums[endPos]==nums[mid]) endPos++;
                int[] r = new int[2];
                r[0] = startPos+1;
                r[1] = endPos-1;
                return r;
            }
        }

        int[] r = {-1, -1};
        return r;
    }

    public static void main(String[] args) {
        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;
//        int[] nums = { 5, 7, 7, 8, 8, 10 };
//        int target = 6;
//        int[] nums = { 1 };
//        int target = 1;
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;

        int[] index = searchRange(nums, target);
        System.out.printf("index of %d in %s=%s", target, Arrays.toString(nums), Arrays.toString(index));
        System.out.println();
    }
}
