/**
 * 
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hezhigang
 * 46. Permutations
 * https://leetcode.com/problems/permutations/
 */
public class Permutations {
	/**
	 * 
	 * @param nums
	 * @return
	 */
    public static List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> list = new ArrayList<List<Integer>>();
//    	permutation_remove(nums,nums.length,list);
    	permutation_heaps(nums,nums.length,list);
    	return list;
    }
    
    /**
     * GENERATING PERMUTATIONS
     * BASIC ALGORITHM 1: REMOVE
     * https://www.topcoder.com/generating-permutations/
     * @param a
     * @param n
     * @param list
     */
	private static void permutation_remove(int[] a, int n, List<List<Integer>> list) {
		if (n == 1) {
//			System.out.println(Arrays.toString(a));
			List<Integer> x = new ArrayList<Integer>();
			for(int i=0;i<a.length;i++)
				x.add(new Integer(a[i]));
			list.add(x);
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			permutation_remove(a, n - 1, list);
			swap(a, i, n - 1);
		}
	}
    
    /**
     * BASIC ALGORITHM 1: REMOVE
     * https://www.topcoder.com/generating-permutations/
     * @param a
     * @param n
     */
	private static void permutation1(int[] a, int n) {
		if (n == 1) {
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = 0; i < n; i++) {
			swap(a, i, n - 1);
			permutation1(a, n - 1);
			swap(a, i, n - 1);
		}
	}
    
	private static final void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
	 * HEAP'S ALGORITHM
	 * @param a
	 * @param n
	 */
	public static void heaps_algorithm(int[] a, int n) {
		if (n == 1) {
			System.out.println(Arrays.toString(a));
			return;
		}
		for (int i = 0; i < (n - 1); i++) {
			heaps_algorithm(a, n - 1);
			if (n % 2 == 0)
				swap(a, n - 1, i);
			else
				swap(a, n - 1, 0);
		}
		heaps_algorithm(a, n - 1);
	}
	
	private static void permutation_heaps(int[] a, int n, List<List<Integer>> list) {
		if (n == 1) {
			List<Integer> x = new ArrayList<Integer>();
			for(int i=0;i<a.length;i++)
				x.add(new Integer(a[i]));
			list.add(x);
			return;
		}
		for (int i = 0; i < (n - 1); i++) {
			permutation_heaps(a, n - 1, list);
			if (n % 2 == 0)
				swap(a, n - 1, i);
			else
				swap(a, n - 1, 0);
		}
		permutation_heaps(a, n - 1, list);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {1,2,3};
//		permutation1(nums,nums.length);
//		heaps_algorithm(nums,nums.length);
		List<List<Integer>> list = permute(nums);
		System.out.println(list.stream().map(Object::toString).collect(Collectors.joining("\n")));
	}
}