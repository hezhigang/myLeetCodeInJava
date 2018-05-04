package com.leetcode;

public class TwoSum {
	/**
	 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
	 * @param args
	 */
	
    public static int[] twoSum(int[] nums, int target) {
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

	public static void main(String[] args) {
		int[] nums = {1, 7, 3, 6, 20, 15};
		int target = 10;
		int[] idxArr = twoSum(nums,target);
		for (int i=0;i<idxArr.length;i++) {
			System.out.println(idxArr[i]);
		}
	}

}
