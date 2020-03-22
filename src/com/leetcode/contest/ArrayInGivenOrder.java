package com.leetcode.contest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hezhigang
 * 5364. Create Target Array in the Given Order
 * weekly-contest-181
 */
public class ArrayInGivenOrder {
	
	public static int[] createTargetArray(int[] nums, int[] index) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums.length; i++)
			list.add(index[i], nums[i]);
		return list.stream().mapToInt(Integer::intValue).toArray();
	}

	public static void main(String[] args) {
//		int[] nums = {0,1,2,3,4}, index = {0,1,2,2,1};
//		int[] nums = {1,2,3,4,0}, index = {0,1,2,3,0};
		int[] nums = {1}, index = {0};
		int[] target = createTargetArray(nums, index);
		System.out.println(Arrays.toString(target));
	}

}
