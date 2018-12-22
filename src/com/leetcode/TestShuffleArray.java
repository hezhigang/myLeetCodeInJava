/**
 * 作者: 和志刚
 * 日期: 2018年12月22日
 * 时间: 上午7:02:41
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 
 */
public class TestShuffleArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		ShuffleArray shuffleArray = new ShuffleArray(nums);
		System.out.println(Arrays.toString(shuffleArray.shuffle()));
		System.out.println(Arrays.toString(shuffleArray.reset()));
	}

}
