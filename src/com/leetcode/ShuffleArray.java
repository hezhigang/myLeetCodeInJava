/**
 * 作者: 和志刚
 * 日期: 2018年12月21日
 * 时间: 下午2:37:25
 */
package com.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 384. Shuffle an Array
 */
public class ShuffleArray {
	/**
	 * Your Solution object will be instantiated and called as such:
	 * Solution obj = new Solution(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
	private Integer[] shuffleArr;
	private int[] originalArr;
	
    public ShuffleArray(int[] nums) {
    	shuffleArr = new Integer[nums.length];
    	for(int i=0;i<nums.length;i++)
    		shuffleArr[i] = nums[i];
    	originalArr = nums.clone();
    	System.out.println(Arrays.toString(originalArr));
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	List<Integer> list = Arrays.asList(shuffleArr); 
    	Collections.shuffle(list);
    	Integer[] a = new Integer[shuffleArr.length];
    	list.toArray(a);
    	int[] r = new int[a.length];
    	for(int i=0;i<a.length;i++)
    		r[i] = a[i];
        return r;
    }
}