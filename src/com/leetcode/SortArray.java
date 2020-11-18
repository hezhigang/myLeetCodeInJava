package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

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
    public static int[] sortArray_mergesort_top_down(int[] nums) {
        final int N = nums.length;
        int[] aux = new int[N];
        sort(nums, aux, 0, N - 1);
        return nums;
    }

    /**
     * bottom-up mergesort
     * 11 / 11 test cases passed.
     * Runtime: 7 ms, faster than 34.85% of Java online submissions for Sort an Array.
     * Memory Usage: 46.7 MB, less than 12.67% of Java online submissions for Sort an Array.
     * @param nums
     * @return
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    public static int[] sortArray_mergesort_bottom_up(int[] nums) {
        final int N = nums.length;
        int[] aux = new int[N];
        for (int len = 1; len < N; len *= 2) {
            for (int lo = 0; lo < N - len; lo += len + len) {
                int mid = lo + len - 1;
                int hi = Math.min(lo + len + len - 1, N - 1);
                merge(nums, aux, lo, mid, hi);
            }
        }
        return nums;
    }

    /**
     * exchange a[i] and a[j]
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /**
     * quicksort the subarray a[lo .. hi] using 3-way partitioning
     * @param a
     * @param lo
     * @param hi
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    private static void sort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo, gt = hi;
        int v = a[lo];
        int i = lo + 1;
        while (i <= gt) {
            if (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }

        // a[lo..lt-1] < v = a[lt..gt] < a[gt+1..hi].
        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    /**
     * quicksort with 3-way partitioning
     * 11 / 11 test cases passed.
     * Runtime: 7 ms, faster than 34.98% of Java online submissions for Sort an Array.
     * Memory Usage: 46.5 MB, less than 12.99% of Java online submissions for Sort an Array.
     * @param nums
     * @return
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    public static int[] sortArray_ThreeWay_quicksort(int[] nums) {
        final int N = nums.length;
        long seed = System.currentTimeMillis();
        Random random = new Random(seed);
        for (int i = 0; i < N; i++) {
            int r = i + random.nextInt(N - i);     // between i and N-1
            int temp = nums[i];
            nums[i] = nums[r];
            nums[r] = temp;
        }
        sort(nums, 0, N - 1);
        return nums;
    }

    /**
     * heap sort using jdk PriorityQueue
     * @param nums
     * @return
     */
    public static int[] sortArray_jdk_PriorityQueue(int[] nums) {
        Queue<Integer> q = new PriorityQueue<Integer>();
        for (int num : nums) {
            q.add(num);
        }
        int i = 0;
        while (q.size() > 0)
            nums[i++] = q.poll();
        return nums;
    }

    /**
     * recursion
     * https://www.geeksforgeeks.org/heap-sort/
     * @param pq
     * @param k
     * @param n
     */
    private static void sink_recur(int[] pq, int k, int n) {
        int largest = k; // Initialize largest as root
        int l = 2 * k + 1; // left = 2*i + 1
        int r = 2 * k + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && pq[l] > pq[largest])
            largest = l;

        // If right child is larger than largest so far
        if (r < n && pq[r] > pq[largest])
            largest = r;

        // If largest is not root
        if (largest != k) {
//            int swap = pq[k];
//            pq[k] = pq[largest];
//            pq[largest] = swap;
            exch(pq, k, largest);
            // Recursively heapify the affected sub-tree
            sink_recur(pq, largest, n);
        }
    }

    /**
     * Helper functions to restore the heap invariant.
     * iterative
     * @param pq
     * @param k
     * @param n
     * @author Robert Sedgewick
     * @author Kevin Wayne
     */
    private static void sink(int[] pq, int k, int n) {
        while (2 * k <= (n - 1)) {
            int j = 2 * k;
            if (j < (n - 1) && pq[j] < pq[j + 1]) j++;
            if (!(pq[k] < pq[j])) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /**
     * heapsort
     * @param nums
     * @return
     */
    public static int[] sortArray(int[] nums) {
        int n = nums.length;

        // heapify phase
        for (int k = (n - 1) / 2; k >= 0; k--)
            sink(nums, k, n);

        // sortdown phase
        for (int k = n - 1; k > 0; k--) {
            exch(nums, 0, k);
            sink(nums, 0, k);
        }

        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 3, 1};
//        int[] nums = {5, 1, 1, 2, 0, 0};
//        int[] nums = {5, 2, 6};
//        int[] nums = {8, 3};
        System.out.printf("before sorting as : %s", Arrays.toString(nums) );
        int[] sortedNums = sortArray(nums);
//        int[] sortedNums = sortArray_quicksort(nums);

        System.out.println();
        System.out.printf("after sorting as : %s", Arrays.toString(sortedNums) );
    }
}
