package com.leetcode;

import java.util.Arrays;

/**
 * 704. Binary Search
 * https://leetcode.com/problems/binary-search/
 */
public class BinarySearch {

    /**
     * Binary search
     * https://rosettacode.org/wiki/Binary_search#Java
     * @param nums
     * @param target
     * @return
     */
    public static int search(int[] nums, int target) {
        final int len = nums.length;
        int left=0, right=len-1;
        while(left<=right) {
            int mid = (left+right)/2;
            if (nums[mid]>target) {
                right = mid-1;
            }
            else if (nums[mid]<target){
                left = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    /**
     * Algorithms, 4th Edition
     * Robert Sedgewick and Kevin Wayne
     * @param nums
     * @param target
     * @return
     */
    public static int search_rank(int[] nums, int target) {
        // Array must be sorted.
        int lo = 0;
        int hi = nums.length - 1;
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

    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 2;
        int index = search(nums, target);
        System.out.printf("index of %d in %s=%d", target, Arrays.toString(nums), index);
        System.out.println();
    }
}
