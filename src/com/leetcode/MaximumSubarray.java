/**
 * 作者: 和志刚
 * 日期: 2018年12月1日
 * 时间: 下午10:47:20
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 53. Maximum Subarray
 * If you have figured out the O(n) solution, 
 * try coding another solution using the divide and conquer approach, 
 * which is more subtle.
 */
public class MaximumSubarray {
	
	/**
	 * LeetCode – Maximum Subarray (Java)
	 * https://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
	 * @param nums
	 * @return
	 */
    public static int maxSubArray(int[] nums) {
        int newSum = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++) {
        	newSum = Math.max(newSum+nums[i], nums[i]);
        	max = Math.max(newSum, max);
        }
        return max;
    }
    
    /**
     * Kadane’s algorithm
     * Solving Algorithmic Problems: Maximum Sum of a Contiguous Subarray
     * https://medium.com/solvingalgo/how-to-solve-algorithmic-problems-maximum-sum-of-a-contiguous-subarray-5568adbfc5b
     * @param nums
     * @return
     */
    private static int Kadane(int[] nums) {
    	int max = Integer.MIN_VALUE;
    	int count = 0;
    	for(int i=0;i<nums.length;i++) {
    		count += nums[i];
    		if (count>max)
    			max = count;
    		if (count<0)
    			count = 0;
    	}
    	return max;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		int x = Kadane(arr);
		System.out.printf(Arrays.toString(arr)+"=%d", x);
		System.out.println("");
		System.out.printf(Arrays.toString(arr)+"=%d", maxSubArray(arr));
	}

}
