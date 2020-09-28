package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 */
public class TwoSum {

	/**
	 * brute method
	 * @param nums
	 * @param target
	 * @return
	 */
    public static int[] twoSum_brute(int[] nums, int target) {
        int[] idxArr = {0,0};
        for(int i=0;i<nums.length;i++) 
        	for(int j=nums.length-1;j>i;j--) {
        		if (nums[j]+nums[i]==target) {
        			idxArr[0] = i;
        			idxArr[1] = j;
        			return idxArr;
        		}
        	}
        return idxArr;
    }

	/**
	 * Approach 3: One-pass Hash Table
	 * https://leetcode.com/problems/two-sum/solution/
	 * Sep 28, 2020
	 * @param nums
	 * @param target
	 * @return
	 */
	public static int[] twoSum(int[] nums, int target) {
		int a = 0, b = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				a = i;
				b = map.get(complement);
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[]{a, b};
	}

	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 20, 15};
		int target = 10;
		int[] idxArr = twoSum(nums,target);
//		for (int i=0;i<idxArr.length;i++) {
//			System.out.println(idxArr[i]);
//		}
		System.out.printf("nums=%s, target=%d, Output: %s", Arrays.toString(nums), target, Arrays.toString(idxArr));
	}

}
