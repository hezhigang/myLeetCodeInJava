package com.leetcode;

import java.util.Arrays;

/**
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/
 */
public class MergeSortedArray {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
//            System.arraycopy(nums2, 0, nums1, 0, n);
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }
        int idx = m + n - 1;
        int idx1 = m - 1, idx2 = n - 1;
        for (; idx1 >= 0 && idx2 >= 0; ) {
            if (nums1[idx1] < nums2[idx2]) {
                nums1[idx--] = nums2[idx2];
                idx2--;
            } else {
                nums1[idx--] = nums1[idx1];
                nums1[idx1] = 0;
                idx1--;
            }
        }
        if (idx2 >= 0)
            for (int i = 0; i <= idx2; i++)
                nums1[i] = nums2[i];
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < n; i++)
                nums1[i] = nums2[i];
            return;
        }
        int idx = m + n - 1;
        m--;
        n--;
        for (; m >= 0 && n >= 0; ) {
            if (nums1[m] < nums2[n]) {
                nums1[idx--] = nums2[n];
                n--;
            } else {
                nums1[idx--] = nums1[m];
                m--;
            }
        }
        if (n >= 0)
            for (int i = 0; i <= n; i++)
                nums1[i] = nums2[i];
    }

    public static void main(String[] args) {
//        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
//        int[] nums2 = { 2, 5, 6 };
//        int m = 3, n = 3;

//        int[] nums1 = { 1, 2, 4, 5, 7, 0, 0 };
//        int[] nums2 = { 6, 8 };
//        int m = 5, n = 2;

//        int[] nums1 = { 0 };
//        int[] nums2 = { 1 };
//        int m = 0, n = 1;

//        int[] nums1 = { 2, 0 };
//        int[] nums2 = { 1 };
//        int m = 1, n = 1;

        int[] nums1 = { 4, 5, 6, 0, 0, 0 };
        int[] nums2 = { 1, 2, 3 };
        int m = 3, n = 3;

        System.out.printf("nums1=%s, nums2=%s\n\r", Arrays.toString(nums1), Arrays.toString(nums2));
        merge(nums1, m, nums2, n);
        System.out.printf("Output: %s\n\r", Arrays.toString(nums1));
    }
}
