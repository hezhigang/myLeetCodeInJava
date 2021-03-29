/*
author: hezhigang
date: 10/1/20
time: 8:39 PM
*/
package com.leetcode;

import java.util.Arrays;

/**
 * 4. Median of Two Sorted Arrays
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * Follow up: The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfTwoSortedArrays {

    private static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[m + n];
        if (m == 0) {
            for (int i = 0; i < n; i++)
                aux[i] = nums2[i];
            return aux;
        } else {
            for (int i = 0; i < m; i++)
                aux[i] = nums1[i];
        }
        int idx = m + n - 1;
        m--;
        n--;
        for (; m >= 0 && n >= 0; ) {
            if (nums1[m] < nums2[n]) {
                aux[idx--] = nums2[n];
                n--;
            } else {
                aux[idx--] = nums1[m];
                m--;
            }
        }
        if (n >= 0) {
            for (int i = 0; i <= n; i++)
                aux[i] = nums2[i];
        }
        return aux;
    }

    /**
     * 2091 / 2091 test cases passed.
     * Runtime: 2 ms, faster than 99.73% of Java online submissions for Median of Two Sorted Arrays.
     * Memory Usage: 40.1 MB, less than 10.39% of Java online submissions for Median of Two Sorted Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays_v1(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        if (m == 0)
            return (n & 1) == 1 ? nums2[n / 2] : (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
        if (n == 0)
            return (m & 1) == 1 ? nums1[m / 2] : (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;
        int[] aux = merge(nums1, m, nums2, n);
        double median = ((m + n) & 1) == 1 ? aux[(m + n) / 2] : (aux[(m + n) / 2 - 1] + aux[(m + n) / 2]) / 2.0;
        return median;
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int m = nums1.length;
        final int n = nums2.length;
        if (m == 0)
            return (n & 1) == 1 ? nums2[n / 2] : (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0;
        if (n == 0)
            return (m & 1) == 1 ? nums1[m / 2] : (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0;

        int min1 = nums1[0], max1 = nums1[m - 1];
        int min2 = nums2[0], max2 = nums2[n - 1];
        int left = Math.max(min1, min2);
        int right = Math.min(max1, max2);
        System.out.printf("left=%d, right=%d", left, right);

        double median = 0.0d;
        int len = m + n;
        if ((len & 1) == 1) {

        } else {

        }

        return median;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 3}, nums2 = {2};
//        int[] nums1 = {1, 2}, nums2 = {3, 4};
//        int[] nums1 = {0, 0}, nums2 = {0, 0};
//        int[] nums1 = {}, nums2 = {1};
//        int[] nums1 = {2}, nums2 = {};
        int[] nums1 = {1, 7, 10}, nums2 = {5, 8};
//        int[] nums1 = {}, nums2 = {2, 3};

        double median = findMedianSortedArrays(nums1, nums2);

        System.out.printf("Input: nums1 = %s, nums2 = %s\n\r", Arrays.toString(nums1), Arrays.toString(nums2));
        System.out.println();
        System.out.printf("the median of the two sorted arrays = %f", median);
        System.out.println();
    }
}