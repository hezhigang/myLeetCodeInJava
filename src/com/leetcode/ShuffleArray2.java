/**
 * 作者: 和志刚
 * 日期: 2018年12月22日
 * 时间: 上午7:12:16
 */
package com.leetcode;

import java.util.Random;

/**
 * 384. Shuffle an Array
 */
public class ShuffleArray2 {
	private int[] shuffleArr;
	private int[] originalArr;
	
    public ShuffleArray2(int[] nums) {
    	originalArr = nums.clone();
    	shuffleArr = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return originalArr;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	Random random = new Random();
    	int temp = 0;
    	int randomPosition = 0;
    	final int N = shuffleArr.length;
    	for(int i=shuffleArr.length-1;i>0;i--) {
    		randomPosition = random.nextInt(N);
    		temp = shuffleArr[i];
    		shuffleArr[i] = shuffleArr[randomPosition];
    		shuffleArr[randomPosition] = temp;
    	}
        return shuffleArr;        
    }	
}
