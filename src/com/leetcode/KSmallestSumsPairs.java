package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 373. Find K Pairs with Smallest Sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * Oct 24, 2023
 */
public class KSmallestSumsPairs {
    /**
     * Accepted
     * Runtime 83ms Beats 14.24% of users with Java
     * Memory 56.03MB Beats 93.45% of users with Java
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<String> visited = new HashSet<String>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
        visited.add("0,0");
        String key = "";
        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1];
            int j = top[2];

            list.add(Arrays.asList(nums1[i], nums2[j]));
            key = Integer.toString(i + 1) + "," + j;
            if (i + 1 < len1 && !visited.contains(key)) {
                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add(key);
            }

            key = i + "," + Integer.toString(j + 1);
            if (j + 1 < len2 && !visited.contains(key)) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(key);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

//        int[] nums1 = {1, 2, 3};
//        int[] nums2 = {2, 3, 4};
//        int k = 3;

        List<List<Integer>> list = kSmallestPairs(nums1, nums2, k);
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }
}
