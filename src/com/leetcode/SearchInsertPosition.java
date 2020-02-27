package com.leetcode;

import java.util.Arrays;

/**
 * @author hezhigang
 * 35. Search Insert Position
 * https://leetcode.com/problems/search-insert-position/
 */
public class SearchInsertPosition {
	
    public static int searchInsert(int[] nums, int target) {
        int left=0, right=nums.length-1;
        int mid=0;
        while(left<=right) {
        	mid = (left+right)/2;
        	if (nums[mid]>target) {
        		right = mid-1;
        	}
        	else if (nums[mid]<target){
        		left = mid+1;
        	}
        	else
        		return mid;
        }
        if (target>nums[mid])
        	return mid+1;
        else 
        	return mid;
    }	

	public static void main(String[] args) {
		int[] nums = {1,3,5,6};
		int target = 5;
		
//		int[] nums = {1,3,5,6};
//		int target = 2;
		
//		int[] nums = {1,3,5,6};
//		int target = 7;
		
//		int[] nums = {1,3,5,6};
//		int target = 0;
		
		int index = searchInsert(nums, target);
        System.out.printf("index of %d in %s=%d", target, Arrays.toString(nums), index);
        System.out.println();
	}

}
