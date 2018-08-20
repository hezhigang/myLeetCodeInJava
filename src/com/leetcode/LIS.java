/**
 * 作者: 和志刚
 * 日期: 2018年8月17日
 * 时间: 上午11:44:28
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * Longest Increasing Subsequence using Dynamic Programming
 * http://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/
 */
public class LIS {
	
    public static int lengthOfLIS(int[] nums) {
    	if (nums.length==0)
    		return 0;
    	int[] L = new int[nums.length];
    	L[0]=1;
    	for(int i=1;i<nums.length;i++) {
    		for(int j=0;j<i;j++) {
    			if(nums[j]<nums[i] && L[j]>L[i])
    				L[i] = L[j];
    		}
    		L[i]++;
    	}
    	return Arrays.stream(L).max().getAsInt();
    }
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {10,9,2,5,3,7,101,18};
		System.out.println("maxlengthOfLIS="+lengthOfLIS(nums));
	}

}
