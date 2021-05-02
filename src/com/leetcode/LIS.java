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
	
    public static int lengthOfLIS_1(int[] nums) {
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
	 * 2021-04-25
	 * https://en.wikipedia.org/wiki/Longest_increasing_subsequence
	 * 54 / 54 test cases passed.
	 * Runtime: 5 ms, faster than 75.39% of Java online submissions for Longest Increasing Subsequence.
	 * Memory Usage: 39.2 MB, less than 12.91% of Java online submissions for Longest Increasing Subsequence.
	 * @param nums
	 * @return
	 */
	public static int lengthOfLIS(int[] nums) {
		int N = nums.length;
//		int[] P = new int[N];
		int[] M = new int[N + 1];

		int L = 0;
		for (int i = 0; i < N; i++) {
			// Binary search for the largest positive j ≤ L
			// such that X[M[j]] < X[i]
			int lo = 1;
			int hi = L;
			while (lo <= hi) {
				int mid = new Double(Math.ceil((lo + hi) / 2)).intValue();
				if (nums[M[mid]] < nums[i])
					lo = mid + 1;
				else
					hi = mid - 1;
			}

			// After searching, lo is 1 greater than the
			// length of the longest prefix of X[i]
			int newL = lo;

			// The predecessor of X[i] is the last index of
			// the subsequence of length newL-1
//			P[i] = M[newL - 1];
			M[newL] = i;

			if (newL > L)
				// If we found a subsequence longer than any we've
				// found yet, update L
				L = newL;
		}
		return L;
	}
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
//		int[] nums = {0, 1, 0, 3, 2, 3};
		int[] nums = {7, 7, 7, 7, 7, 7, 7};
		System.out.println("maxlengthOfLIS=" + lengthOfLIS(nums));
	}

}
