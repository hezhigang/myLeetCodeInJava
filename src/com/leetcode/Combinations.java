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
 * 77. Combinations
 * https://leetcode.com/problems/combinations/
 * Given two integers n and k, 
 * return all possible combinations of k numbers out of 1 ... n.
 */
public class Combinations {
	
	public static List<List<Integer>> combine_draft(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

//		List<Integer> combination = new ArrayList<Integer>();
		Integer[] combination = new Integer[k];
		for (int i = 0; i < k; i++) {
			combination[i] = i;
//			combination.add(i);
		}

		while (combination[k - 1] < n) {
			combinations.add(new ArrayList<Integer>(Arrays.asList(combination)));
			int t = k - 1;
			while (t != 0 && combination[t] == n - k + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < k; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}
		
		/*
		while (combination.get(k - 1) < n) {
			combinations.add(new ArrayList<Integer>(combination));
			int t = k - 1;
			while (t != 0 && combination.get(t) == n - k + t) {
				t--;
			}
			int w = combination.get(t).intValue();
			combination.set(t, w++);
			for (int i = t + 1; i < k; i++) {
				combination.set(i, combination.get(i - 1) + 1);
			}
		}
		*/

		return combinations;
	}
	
	/**
	 * Iterative Algorithm
	 * Generate Combinations in Java
	 * https://www.baeldung.com/java-combinations-algorithm
	 * @param n
	 * @param k
	 * @return
	 */
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();

		int[] combination = new int[k];
		for (int i = 0; i < k; i++) {
			combination[i] = i;
		}

		while (combination[k - 1] < n) {
			List<Integer> comblist = new ArrayList<Integer>();
			for(int i=0; i<combination.length; i++) {
				comblist.add(combination[i]+1);
			}
			combinations.add(comblist);
			int t = k - 1;
			while (t != 0 && combination[t] == n - k + t) {
				t--;
			}
			combination[t]++;
			for (int i = t + 1; i < k; i++) {
				combination[i] = combination[i - 1] + 1;
			}
		}

		return combinations;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 4, k = 2;
		List<List<Integer>> list = combine(n, k);
		System.out.println(list.stream().map(Object::toString).collect(Collectors.joining("\n")));
	}

}
