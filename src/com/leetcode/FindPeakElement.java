package com.leetcode;

import java.util.Arrays;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/
 */
public class FindPeakElement {

    /**
     * eager approach
     * O(n)
     * 63 / 63 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 41.3 MB, less than 66.17% of Java online submissions for Find Peak Element.
     * @param nums
     * @return
     */
    public static int findPeakElement_eager(int[] nums) {
        final int len = nums.length;
        for (int i = 1; i < len - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return nums[0] < nums[len - 1] ? len - 1 : 0;
    }

    /**
     * https://leetcode.com/problems/find-peak-element/solution/
     * Approach 3: Iterative Binary Search
     * O(log n)
     * 63 / 63 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 43.2 MB, less than 17.58% of Java online submissions for Find Peak Element.
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1])
                right = mid;
            else
                left = mid + 1;
        }
        return left;
    }

    /**
     * Divide and Conquer Approach
     * Find Peak Element in an Array
     * https://iq.opengenus.org/peak-element-in-array/
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private static int recur(int[] nums, int left, int right) {
        if (left == right)
            return left;
        else if (left + 1 == right) {
            if (nums[left] > nums[right])
                return left;
            else
                return right;
        } else {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;
            else if (nums[mid] < nums[mid - 1] && nums[mid] > nums[mid + 1])
                return recur(nums, left, mid - 1);
            else
                return recur(nums, mid + 1, right);
        }
    }

    /**
     * 63 / 63 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Peak Element.
     * Memory Usage: 42.5 MB, less than 49.41% of Java online submissions for Find Peak Element.
     * @param nums
     * @return
     */
    public static int findPeakElement_recur(int[] nums) {
        return recur(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
//        int[] nums = {1, 2};
//        int[] nums = {1};
//        int[] nums = {140, 150, 5, 2, 8, 80, 122, 180};
//        int[] nums = {6, 5, 4, 3, 2, 3, 2};
//        int[] nums = {8, 7, 6, 5, 4};
        int index = findPeakElement(nums);
        System.out.printf("one of peak elements in %s is %d", Arrays.toString(nums), nums[index]);
        System.out.println();
    }
}