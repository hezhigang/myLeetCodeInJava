/**
 * 作者: 和志刚
 * 日期: 2019年3月28日
 * 时间: 上午11:45:48
 */
package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 215. Kth Largest Element in an Array
 * tag: Divide and Conquer, heap
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestInArray {
	
	/**
	 * solution 1: Sorting
	 * @param nums
	 * @param k
	 * @return
	 */
    public static int findKthLargest_jdk(Integer[] nums, int k) {
    	// method one
//        Arrays.sort(nums, Collections.reverseOrder());
//        return nums[k-1];
        // method two
		Arrays.sort(nums);
		return nums[nums.length - k];
    }
    
    /**
     * solution 2: min heap
     * https://www.programcreek.com/2014/05/leetcode-kth-largest-element-in-an-array-java/
     * @param nums
     * @param k
     * @return
     */
    public static int findKthLargest_minHeap(Integer[] nums, int k) {
    	PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(k);
    	for(int i : nums) {
    		minHeap.offer(i);
    		if (minHeap.size()>k)
    			minHeap.poll();
    	}
    	return minHeap.peek();
    }
    
    /**
     * a similar method like quick sort
     * @param nums
     * @param k
     * @return
     */
	public static int findKthLargest(Integer[] nums, int k) {
		if (k < 1 || nums == null) {
			return 0;
		}
		return getKth(nums.length - k + 1, nums, 0, nums.length - 1);
	}
    
	public static int getKth(int k, Integer[] nums, int start, int end) {
		int pivot = nums[end];
		int left = start;
		int right = end;
		while (true) {
			while (nums[left] < pivot && left < right) {
				left++;
			}

			while (nums[right] >= pivot && right > left) {
				right--;
			}

			if (left == right) {
				break;
			}

			swap(nums, left, right);
		}

		swap(nums, left, end);

		if (k == left + 1) {
			return pivot;
		} else if (k < left + 1) {
			return getKth(k, nums, start, left - 1);
		} else {
			return getKth(k, nums, left + 1, end);
		}
	}
    
	public static void swap(Integer[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	/**
	 * http://www.geekviewpoint.com/java/search/quickselect
	 * @param a
	 * @param left
	 * @param right
	 * @param k
	 * @return
	 */
	private static int quickselect(int[] a, int left, int right, int k) {
		if (left <= right) {
			int pivot = partition(a, left, right);
			if (pivot == k) {
				return a[k];
			}
			if (pivot > k) {
				return quickselect(a, left, pivot - 1, k);
			}
			return quickselect(a, pivot + 1, right, k);
		}
		return Integer.MIN_VALUE;
	}

	/**
	 * http://www.geekviewpoint.com/java/search/quickselect
	 * @param a
	 * @param lo
	 * @param hi
	 * @return
	 */
	private static int partition(int[] a, int lo, int hi) {
		int pivot = lo + new Random().nextInt(hi - lo + 1);
		exch(a, hi, pivot);
		for (int i = lo; i < hi; i++) {
			if (a[i] > a[hi]) {
				exch(a, i, lo);
				lo++;
			}
		}
		exch(a, lo, hi);
		return lo;
	}

	private static void exch(int[] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}

	/**
	 * 32 / 32 test cases passed.
	 * Runtime: 1 ms, faster than 98.04% of Java online submissions for Kth Largest Element in an Array.
	 * Memory Usage: 39.3 MB, less than 11.22% of Java online submissions for Kth Largest Element in an Array.
	 * @param nums
	 * @param k
	 * @return
	 */
	public static int findKthLargest(int[] nums, int k) {
		return quickselect(nums, 0, nums.length - 1, k - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Integer[] nums = {3,2,1,5,6,4};
//		int k = 2;
//		Integer[] nums = {3,2,3,1,2,4,5,5,6};
//		int k = 4;		
//		System.out.printf("%dth Largest Element in an Array %s is %d", k, Arrays.toString(nums), findKthLargest_jdk(nums,k));
//		System.out.println();
//		System.out.printf("%dth Largest Element in an Array %s is %d", k, Arrays.toString(nums), findKthLargest_minHeap(nums,k));
//		System.out.println();
//		System.out.printf("%dth Largest Element in an Array %s is %d", k, Arrays.toString(nums), findKthLargest(nums,k));
//		System.out.println();

		int[] nums = {3, 2, 1, 5, 6, 4};
		int k = 2;

//		int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
//		int k = 4;

//		int[] nums = {2, 1};
//		int k = 1;

		System.out.printf("%dth Largest Element in an Array %s is %d", k, Arrays.toString(nums), findKthLargest(nums,k));
	}

}