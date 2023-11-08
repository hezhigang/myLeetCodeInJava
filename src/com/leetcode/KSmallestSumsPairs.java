package com.leetcode;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 373. Find K Pairs with Smallest Sums
 * https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
 * Oct 24, 2023
 */
public class KSmallestSumsPairs {

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        PriorityQueue<Node> pq = new PriorityQueue<Node>(k);
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                Node node = new Node();
                node.setSumUp(nums1[i] + nums2[j]);
                node.setElements(Arrays.asList(nums1[i], nums2[j]));
                pq.add(node);
                if (pq.size() > k)
                    pq.poll();
            }
        }
        Node node = null;
        while (list.size() < k) {
            node = pq.poll();
            if (node != null)
                list.add(node.getElements());
        }
        List<List<Integer>> rlist = new ArrayList<List<Integer>>();
        for (int i = list.size() - 1; i >= 0; i--) {
            rlist.add(list.get(i));
        }
        return rlist;
    }

    public static void main(String[] args) {
//        int[] nums1 = {1, 7, 11};
//        int[] nums2 = {2, 4, 6};
//        int k = 3;

        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 3, 4};
        int k = 3;

        List<List<Integer>> list = kSmallestPairs(nums1, nums2, k);
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining("\n")));
    }
}

class Node implements Comparable<Node> {
    private Integer sumUp;

    private Integer getSumUp() {
        return sumUp;
    }

    public Node() {
    }

    public void setSumUp(Integer sumUp) {
        this.sumUp = sumUp;
    }

    public List<Integer> getElements() {
        return elements;
    }

    public void setElements(List<Integer> elements) {
        this.elements = elements;
    }

    public List<Integer> elements;

    @Override
    public int compareTo(Node that) {
        int eval1 = this.sumUp;
        int eval2 = that.sumUp;
        if (eval1 < eval2)
            return 1;
        else if (eval1 > eval2)
            return -1;
        else
            return 0;
    }
}
