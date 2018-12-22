/**
 * 作者: 和志刚
 * 日期: 2018年12月22日
 * 时间: 上午7:42:49
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 
 */
public class TestShuffleArray2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3};
		ShuffleArray2 shuffleArray2 = new ShuffleArray2(nums);
		System.out.println(Arrays.toString(shuffleArray2.shuffle()));
		System.out.println(Arrays.toString(shuffleArray2.reset()));
	}

}
