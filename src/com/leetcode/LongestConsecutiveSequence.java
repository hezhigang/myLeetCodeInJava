package com.leetcode;

import java.util.*;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/
 */
public class LongestConsecutiveSequence {

    /**
     *
     * Your algorithm should run in O(n) complexity.
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int N = nums.length;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<N; i++) {
            map.put(nums[i]-1, i);
            map.put(nums[i]+1, i);
        }
        int len = 0;
        UF uf = new UF(N);
        for(int i=0; i<N; i++) {
            if (map.containsKey(nums[i])) {
                uf.union(i, map.get(nums[i]));

            }
        }
        System.out.printf("count of components = %d \n", uf.count());
        return len;
    }

    public static void main(String[] args) {
//        int[] nums = {100, 4, 200, 1, 3, 2};
        int[] nums = {4, 2, 3, 11, 12, 9, 10, 900};
        System.out.printf("unsorted array as : %s", Arrays.toString(nums) );
        System.out.println();
        int len = longestConsecutive(nums);
        System.out.printf("the length of the longest consecutive elements sequence = %d", len);
    }
}
