/*
author: hezhigang
date: 10/20/20
time: 8:58 AM
*/
package com.leetcode;

import java.util.*;

/**
 * 414. Third Maximum Number
 * https://leetcode.com/problems/third-maximum-number/
 * The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {

    /**
     * 26 / 26 test cases passed.
     * Runtime: 1 ms, faster than 90.82% of Java online submissions for Third Maximum Number.
     * Memory Usage: 39.2 MB, less than 7.88% of Java online submissions for Third Maximum Number.
     * @param nums
     * @return
     */
    public static int thirdMax_my(int[] nums) {
        final int N = nums.length;
        int max = nums[0];
        for (int i = 1; i < N; i++) {
            if (nums[i] > max)
                max = nums[i];
        }
        int m2 = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (nums[i] < max && nums[i] > m2)
                m2 = nums[i];
        }
        long m3 = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (nums[i] < m2 && nums[i] > m3)
                m3 = nums[i];
        }
        return m3 > Long.MIN_VALUE ? new Long(m3).intValue() : max;
    }

    /**
     * PriorityQueue + HashSet
     * 26 / 26 test cases passed.
     * Runtime: 5 ms, faster than 21.06% of Java online submissions for Third Maximum Number.
     * Memory Usage: 38.7 MB, less than 10.02% of Java online submissions for Third Maximum Number.
     * @param nums
     * @return
     */
    public static int thirdMax_v2(int[] nums) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                q.add(i);
            }
            if (q.size() > 3) {
                set.remove(q.poll());
            }
        }
        if (q.size() < 3) {
            while (q.size() > 1)
                q.poll();
        }
        return q.peek();
    }

    /**
     * SortedSet, TreeSet
     * 26 / 26 test cases passed.
     * Runtime: 4 ms, faster than 39.33% of Java online submissions for Third Maximum Number.
     * Memory Usage: 38.6 MB, less than 10.02% of Java online submissions for Third Maximum Number.
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        SortedSet<Integer> treeSet = new TreeSet<Integer>();
        for (int num : nums) {
            treeSet.add(num);
            if (treeSet.size() > 3)
                treeSet.remove(treeSet.first());
        }
        return treeSet.size() < 3 ? treeSet.last() : treeSet.first();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
//        int[] nums = {1, 2};
//        int[] nums = {2, 2, 3, 1};
//        int[] nums = {-2147483648, 1, 1};
//        int[] nums = {3, 3, 4, 3, 4, 3, 0, 3, 3};
//        int[] nums = {1, 1, 2};
//        int[] nums = {1, 2, -2147483648};
//        int[] nums = {1, 1, 1};
        int m3 = thirdMax(nums);
        System.out.printf("the third maximum number in %s is %d", Arrays.toString(nums), m3);
    }
}
