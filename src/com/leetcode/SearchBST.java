/*
author: hezhigang
date: 5/22/21
time: 5:51 PM
*/
package com.leetcode;

import java.util.List;

/**
 * 700. Search in a Binary Search Tree
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchBST {

    /**
     * 36 / 36 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Search in a Binary Search Tree.
     * Memory Usage: 39.7 MB, less than 16.71% of Java online submissions for Search in a Binary Search Tree.
     * @param root
     * @param val
     * @return
     */
    public static TreeNode searchBST(TreeNode root, int val) {
        return recur(root, val);
    }

    private static TreeNode recur(TreeNode node, int val) {
        if (node.val == val)
            return node;
        else if (val < node.val) {
            if (node.left == null)
                return null;
            else
                return recur(node.left, val);
        } else {
            if (node.right == null)
                return null;
            else
                return recur(node.right, val);
        }
    }

    public static void main(String[] args) {
        TreeNode rt = new TreeNode(4);
        TreeNode l2L = new TreeNode(2);
        TreeNode l2R = new TreeNode(7);
        rt.left = l2L;
        rt.right = l2R;
        TreeNode l3L = new TreeNode(1);
        TreeNode l3R = new TreeNode(3);
        l2L.left = l3L;
        l2L.right = l3R;

        int val = 2;

        TreeNode node = searchBST(rt, val);
        System.out.printf("Search %d in a Binary Search Tree: %s", val, node != null ? node.val : "null");
    }
}
