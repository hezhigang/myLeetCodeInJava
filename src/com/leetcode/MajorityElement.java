package com.leetcode;

import java.util.*;

/**
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/
 */
public class MajorityElement {

    public static int majorityElement(int[] nums) {
        final int len = nums.length;
        int halfsize = len >> 1;
        System.out.printf("half size = %d \n", halfsize);

        int major = nums[0];
        return major;
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
    }
}
