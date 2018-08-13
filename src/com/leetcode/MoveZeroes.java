/**
 * 作者: 和志刚
 * 日期: 2018年8月12日
 * 时间: 上午9:01:20
 */
package com.leetcode;

/**
 * 283. Move Zeroes
 */
public class MoveZeroes {
	
    public static void moveZeroes(int[] nums) {
		for(int i=nums.length-1;i>=0;i--) {
			if (nums[i]==0) {
				for(int j=i+1; j<nums.length; j++) {
					nums[j-1]=nums[j];
				}
				nums[nums.length-1]=0;
			}
		}
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		int[] arr = {0,1,0,3,12};
//		int[] arr = {1};
//		int[] arr = {0,0,1};
//		int[] arr = {0,0,1,0,3,12};
		int[] arr = {0,0,0,1,0,0,3,0,0,8,12};
		System.out.println(print(arr));
		
//		for(int i=0;i<arr.length;i++) {
//			if (arr[i]==0) {
//				for(int j=i+1; j<arr.length; j++) {
//					arr[j-1]=arr[j];
//				}				
//				arr[arr.length-1]=0;
//			}
//		}		
		
//		for(int i=arr.length-1;i>=0;i--) {
//			if (arr[i]==0) {
//				for(int j=i+1; j<arr.length; j++) {
//					arr[j-1]=arr[j];
//				}				
//				arr[arr.length-1]=0;
//			}
//		}
		
		moveZeroes(arr);
		System.out.println(print(arr));
	}
	
	private static String print(int[] arr) {
		StringBuilder sb = new StringBuilder();
		if (arr!=null && arr.length>0) {
			for(int i=0;i<arr.length;i++) {
				sb.append(arr[i]);
				if (i<arr.length-1) sb.append(",");
			}
		}
		return sb.toString();
	}

}
