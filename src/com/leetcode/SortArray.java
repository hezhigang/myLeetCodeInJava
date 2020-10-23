package com.leetcode;

import java.util.Arrays;

/**
 * 912. Sort an Array
 * https://leetcode.com/problems/sort-an-array/
 */
public class SortArray {

    /**
     * insert sorting
     * @param nums
     * @return
     */
    public static int[] sortArray_insertion(int[] nums) {
        int temp;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
//                    swap(nums, j, j - 1);
                    temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = temp;
                }
            }
        }
        return nums;
    }

    /**
     * by Quicksort
     * @param nums
     * @return
     */
    public static int[] sortArray_quicksort(int[] nums) {
        qsort(0,nums.length-1, nums);
        return nums;
    }

    /**
     * Quicksort
     * Programming Pearls
     * @author John Bentley
     * @param l
     * @param u
     * @param inArr
     */
    public static void qsort(int l, int u, int[] inArr) {
        if (l>=u) return; //数组的元素小于2时，终止递归
        int m=l; //m: 中间值的下标
        for(int i=l+1;i<=u; i++)
            //不变式: x[l+1..m] < x[l] && x[m+1..i-1]>=x[l]
            if (inArr[i]<inArr[l])
                swap(inArr, ++m, i);
        swap(inArr, l, m);
        qsort(l,m-1,inArr);
        qsort(m+1,u,inArr);
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * selection sort
     * @param nums
     * @return
     */
    public static int[] sortArray_selection(int[] nums) {
        final int N = nums.length;
        int temp;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min])
                    min = j;
            }
            temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
        return nums;
    }

    /**
     * shell sort
     * @param nums
     * @return
     */
    public static int[] sortArray_shellsort(int[] nums) {
        final int N = nums.length;
        int h = 1;
        for (; h < N / 3; h = 3 * h + 1) ;
        int temp;
        for (; h >= 1; h /= 3) {
            for (int i = h; i < N; i++) {
                for (int j = i; j >= h; j -= h) {
                    if (nums[j] < nums[j - h]) {
                        temp = nums[j];
                        nums[j] = nums[j - h];
                        nums[j - h] = temp;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * stably merge a[lo .. mid] with a[mid+1 ..hi] using aux[lo .. hi]
     * @author Robert Sedgewick
     * @author Kevin Wayne
     * @param a
     * @param aux
     * @param lo
     * @param mid
     * @param hi
     */
    private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        // copy to aux[]
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // merge back to a[]
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j] < aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

    /**
     * mergesort a[lo..hi] using auxiliary array aux[lo..hi]
     * @author Robert Sedgewick
     * @author Kevin Wayne
     * @param a
     * @param aux
     * @param lo
     * @param hi
     */
    private static void sort(int[] a, int[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    /**
     * top-down, recursive version of mergesort
     * Runtime: 6 ms, faster than 57.85% of Java online submissions for Sort an Array.
     * Memory Usage: 46.3 MB, less than 14.62% of Java online submissions for Sort an Array.
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        final int N = nums.length;
        int[] aux = new int[N];
        sort(nums, aux, 0, N - 1);
        return nums;
    }

    public static void main(String[] args) {
//        int[] nums = {5, 2, 3, 1};
        int[] nums = {5, 1, 1, 2, 0, 0};
        System.out.printf("before sorting as : %s", Arrays.toString(nums) );
        int[] sortedNums = sortArray(nums);
//        int[] sortedNums = sortArray_quicksort(nums);

        System.out.println();
        System.out.printf("after sorting as : %s", Arrays.toString(sortedNums) );
    }
}
