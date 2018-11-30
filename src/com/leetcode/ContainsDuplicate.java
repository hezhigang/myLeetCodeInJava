/**
 * 作者: 和志刚
 * 日期: 2018年11月29日
 * 时间: 下午4:58:19
 */
package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 217. Contains Duplicate
 */
public class ContainsDuplicate {
	
    public static boolean containsDuplicate(int[] nums) {
    	boolean r = false;
    	Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    	for(int i=0;i<nums.length;i++) {
    		if (map.containsKey(nums[i])) {
    			int val = map.get(nums[i]);
    			map.put(nums[i], val+1);
    		}
    		else {
    			map.put(nums[i], 1);
    		}
    	}
    	Iterator<Integer> itr = map.values().iterator();
    	while(itr.hasNext()) {
    		if (itr.next().intValue()>1) {
    			r = true;
    			break;
    		}
    	}
    	return r;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] arr1 = {1,2,3,1};
		System.out.println(Arrays.toString(arr1)+"->"+containsDuplicate(arr1));
		final int[] arr2 = {1,2,3,4};
		System.out.println(Arrays.toString(arr2)+"->"+containsDuplicate(arr2));
		final int[] arr3 = {1,1,1,3,3,4,3,2,4,2};
		System.out.println(Arrays.toString(arr3)+"->"+containsDuplicate(arr3));
	}

}
