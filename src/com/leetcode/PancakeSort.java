/**
 * 969. Pancake Sorting
 * https://leetcode.com/problems/pancake-sorting/
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Solution Approach 1: Sort Largest to Smallest
 * @author hezhigang
 * https://leetcode.com/problems/pancake-sorting/solution/
 */
public class PancakeSort {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> ans = new ArrayList<Integer>();
        int N = A.length;

        Integer[] B = new Integer[N];
        for (int i = 0; i < N; ++i)
            B[i] = i+1;
        Arrays.sort(B, (i, j) -> A[j-1] - A[i-1]);

        for (int i: B) {
            for (int f: ans)
                if (i <= f)
                    i = f+1 - i;
            ans.add(i);
            ans.add(N--);
        }

        return ans;
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 1 };
		PancakeSort pancakesort = new PancakeSort();
		List<Integer> list = pancakesort.pancakeSort(arr);
		System.out.println("[" + list.stream().map(Object::toString).collect(Collectors.joining(",")) + "]");
	}

}
