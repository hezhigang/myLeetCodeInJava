package com.leetcode;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    private static int[] removeDuplicates(int[] input) {
        if (input == null || input.length <= 0) {
            return input;
        }
        Set<Integer> aSet = new HashSet<>(input.length);
        for (int i : input) {
            aSet.add(i);
        }
        int[] a = new int[aSet.size()];
        int i=0;
        for(Integer x : aSet)
            a[i++] = x;
        return a;
    }

    /**
     *
     * Your algorithm should run in O(n) complexity.
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int[] arr = removeDuplicates(nums);
        System.out.printf("remove duplicate elements array as : %s", Arrays.toString(arr) );
        System.out.println();
        int N = arr.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
            if (!map.containsKey(arr[i]-1)) map.put(arr[i]-1, i);
            if (!map.containsKey(arr[i]+1)) map.put(arr[i]+1, i);
        }
        int len = 0;
        UF uf = new UF(N);
        for(int i=0; i<N; i++) {
            if (map.containsKey(arr[i])) {
                uf.union(i, map.get(arr[i]));
            }
        }
        System.out.printf("count of components = %d \n", uf.count());
        int[] parent = uf.parent();
        System.out.printf("parent index as : %s", Arrays.toString(parent) );
        System.out.println();
        Map<Integer,Integer> tmpMap = new HashMap<Integer, Integer>();
        int k;
        for(int i=0; i<parent.length; i++) {
            k = parent[i];
            if (tmpMap.containsKey(parent[i]))
                tmpMap.put(k, tmpMap.get(k)+1);
            else
                tmpMap.put(k, 1);
        }
        for(Integer n : tmpMap.values()) {
            if (n>len)
                len = n;
        }

        return len;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {4, 2, 3, 11, 12, 9, 10, 900};
//        int[] nums = {0, 0, -1};
        int[] nums = {1, -8, 7, -2, -4, -4, 6, 3, -4, 0, -7, -1, 5, 1, -9, -3};
        System.out.printf("unsorted array as : %s", Arrays.toString(nums) );
        System.out.println();
        int len = longestConsecutive(nums);
        System.out.printf("the length of the longest consecutive elements sequence = %d", len);
    }
}
