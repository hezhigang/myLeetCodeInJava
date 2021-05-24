/*
author: hezhigang
date: 5/23/21
time: 10:42 PM
*/
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 701. Insert into a Binary Search Tree
 * https://leetcode.com/problems/insert-into-a-binary-search-tree/
 */
public class InsertIntoBST {
    /**
     * 35 / 35 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
     * Memory Usage: 39.1 MB, less than 98.22% of Java online submissions for Insert into a Binary Search Tree.
     * @param root
     * @param val
     * @return
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        return recur(root, val);
    }

    /**
     * Robert Sedgewick and Kevin Wayne
     * @param node
     * @param val
     * @return
     */
    private static TreeNode recur(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (val < node.val) {
            node.left = recur(node.left, val);
        } else if (val > node.val) {
            node.right = recur(node.right, val);
        } else {
            node.val = val;
        }
        return node;
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

        int val = 5;

        TreeNode node = insertIntoBST(rt, val);
        String s = levelTraversal(node);
        System.out.printf("Binary Search Tree after insert: %s", s);
    }

    /**
     * 广度优先周游
     * @param rt
     */
    public static String levelTraversal(TreeNode rt) {
        String s = "";
        if (rt == null) return s;
        TreeNode ptr = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(rt);
        while (!queue.isEmpty()) {
            ptr = queue.poll();
            s += ptr.val + " ";
            if (ptr.left != null)
                queue.offer(ptr.left);
            if (ptr.right != null)
                queue.offer(ptr.right);
        }
        return s;
    }
}
