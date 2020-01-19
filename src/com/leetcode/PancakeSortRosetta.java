/**
 * 969. Pancake Sorting
 * https://leetcode.com/problems/pancake-sorting/
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hezhigang
 * Sorting algorithms/Pancake sort
 * https://rosettacode.org/wiki/Sorting_algorithms/Pancake_sort
 */
public class PancakeSortRosetta {
	int[] heap;

	public String toString() {
		String info = "";
		for (int x : heap)
			info += x + " ";
		return info;
	}

	public void flip(int n, List<Integer> list) {
		for (int i = 0; i < (n + 1) / 2; ++i) {
			int tmp = heap[i];
			heap[i] = heap[n - i];
			heap[n - i] = tmp;
		}
		list.add(n);
		System.out.println("flip(0.." + n + "): " + toString());
	}

	public int[] minmax(int n) {
		int xm, xM;
		xm = xM = heap[0];
		int posm = 0, posM = 0;

		for (int i = 1; i < n; ++i) {
			if (heap[i] < xm) {
				xm = heap[i];
				posm = i;
			} else if (heap[i] > xM) {
				xM = heap[i];
				posM = i;
			}
		}
		return new int[] { posm, posM };
	}

	public void sort(int n, int dir, List<Integer> list) {
		if (n == 0)
			return;

		int[] mM = minmax(n);
		int bestXPos = mM[dir];
		int altXPos = mM[1 - dir];
		boolean flipped = false;

		if (bestXPos == n - 1) {
			--n;
		} else if (bestXPos == 0) {
			flip(n - 1, list);
			--n;
		} else if (altXPos == n - 1) {
			dir = 1 - dir;
			--n;
			flipped = true;
		} else {
			flip(bestXPos, list);
		}
		sort(n, dir, list);

		if (flipped) {
			flip(n, list);
		}
	}
	
	public List<Integer> pancakeSort(int[] A) {
		List<Integer> list = new ArrayList<Integer>();
		heap = A;
		sort(A.length, 1, list);
		return list;
	}

	public static void main(String[] args) {
		int[] arr = {3, 2, 4, 1};
//		int[] arr = {1, 2, 5, 4, 3, 10, 9, 8, 7};
//		int[] arr = {6, 7, 2, 1, 8, 9, 5, 3, 4};
//		int[] arr = {1,2,3};
		PancakeSortRosetta pancakesort = new PancakeSortRosetta();
		List<Integer> list = pancakesort.pancakeSort(arr);
		System.out.println("["+list.stream().map(Object::toString).collect(Collectors.joining(","))+"]");

		Stream.of(pancakesort.heap).map(Arrays::toString).forEach(System.out::println);
	}
}
