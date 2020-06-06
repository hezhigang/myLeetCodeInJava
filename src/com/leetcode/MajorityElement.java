package com.leetcode;

import java.util.*;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    /**
     * Boyer-Moore Voting Algorithm
     * https://leetcode.com/problems/majority-element/solution/
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count=0;
        int candidate = nums[0];
        for(int num : nums) {
            if (count==0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static int majorityElement_sorting(int[] nums) {
        final int len = nums.length;
        int halfsize = len >> 1;
        System.out.printf("half size = %d \n", halfsize);
        Arrays.sort(nums);
        return nums[halfsize];
    }

    public static int majorityElement_brute(int[] nums) {
        final int len = nums.length;
        int halfsize = len >> 1;
        System.out.printf("half size = %d \n", halfsize);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : nums) {
            Integer k = new Integer(i);
            if (map.containsKey(k)) {
                map.put(k, map.get(k)+1);
            }
            else {
                map.put(k, 1);
            }
        }
        int major = nums[0];
        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue()>halfsize) {
                major = e.getKey();
                break;
            }
        }
        return major;
    }

    public static void main(String[] args) {
//        int[] nums = { 3, 2, 3 };
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        System.out.printf("the majority element of %s = %d \n", Arrays.toString(nums), majorityElement_brute(nums));

        System.out.printf("the majority element of %s = %d \n", Arrays.toString(nums), majorityElement_sorting(nums));

        System.out.printf("the majority element of %s = %d \n", Arrays.toString(nums), majorityElement(nums));
    }
}
