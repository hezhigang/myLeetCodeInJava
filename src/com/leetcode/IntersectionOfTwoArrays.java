package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 */
public class IntersectionOfTwoArrays {

    /**
     * 60 / 60 test cases passed.
     * Runtime: 8 ms, faster than 11.36% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 39.9 MB, less than 54.69% of Java online submissions for Intersection of Two Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection_naive(int[] nums1, int[] nums2) {
        final int len1 = nums1.length;
        final int len2 = nums2.length;

        Set<Integer> ret = new HashSet<Integer>();
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (nums1[i] == nums2[j])
                    ret.add(nums1[i]);
            }
        }
        int[] r = new int[ret.size()];
        int k = 0;
        for (Integer e : ret)
            r[k++] = e.intValue();
        return r;
    }

    /**
     * 60 / 60 test cases passed.
     * Runtime: 2 ms, faster than 99.40% of Java online submissions for Intersection of Two Arrays.
     * Memory Usage: 39.4 MB, less than 90.00% of Java online submissions for Intersection of Two Arrays.
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> set2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++)
            set1.add(nums1[i]);
        for (int i = 0; i < nums2.length; i++)
            set2.add(nums2[i]);
        set1.retainAll(set2);
        int[] r = new int[set1.size()];
        int k = 0;
        for (Integer e : set1)
            r[k++] = e.intValue();
        return r;
    }

    public static void main(String[] args) {
//        int[] nums1 = { 1, 2, 2, 1 }, nums2 = { 2, 2 };
        int[] nums1 = { 4, 9, 5 }, nums2 = { 9, 4, 9, 8, 4 };
        System.out.printf("Input: nums1 = %s, nums2 = %s\n\r", Arrays.toString(nums1),Arrays.toString(nums2));
        int[] intersection = intersection(nums1,nums2);
        System.out.printf("Output: %s\n\r", Arrays.toString(intersection));
    }
}