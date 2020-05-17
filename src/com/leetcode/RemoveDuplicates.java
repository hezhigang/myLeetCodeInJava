/**
 * 作者: 和志刚
 * 日期: 2019年1月21日
 * 时间: 下午12:29:56
 */
package com.leetcode;

import java.util.Arrays;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class RemoveDuplicates {
	
	/**
	 * https://medium.com/@urdreamliu/26-圖解-remove-duplicates-from-sorted-array-cbee5b2d4df8
	 * @param nums
	 * @return
	 */
    public static int removeDuplicates(int[] nums) {
    	if (nums.length<2) return nums.length;
    	int x=0,y=1;
    	while (y<nums.length) {
    		if (nums[x]==nums[y]) {
    			y+=1;
    		}
    		else {
    			x+=1;
    			nums[x]=nums[y];
    			y+=1;
    		}
    	}
        return x+1;
    }
    
    /**
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/discuss/11769/5-lines-Java-solution
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
    	if (nums.length==0) return 0;
    	int j=0;
    	for(int i=0;i<nums.length;i++) {
    		if (nums[i]!=nums[j])
    			nums[++j]=nums[i];
    	}
    	return ++j;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr1 = {1,1,2};
		System.out.printf("new length of %s after removing Duplicates = %d \n", Arrays.toString(arr1), removeDuplicates2(arr1));
		int[] arr2 = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(Arrays.toString(arr2)+"->"+removeDuplicates2(arr2));
	}

}