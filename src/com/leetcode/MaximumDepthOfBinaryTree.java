/*
author: hezhigang
date: 3/9/21
time: 11:14 AM
*/
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104. Maximum Depth of Binary Tree
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class MaximumDepthOfBinaryTree {

    /**
     * 39 / 39 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 39 MB, less than 49.45% of Java online submissions for Maximum Depth of Binary Tree.
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        return dfs(root, 0);
    }

    /**
     * Recursion
     * @param node
     * @param h
     * @return
     */
    private static int dfs(TreeNode node, int h) {
        if (node != null)
            return Math.max(dfs(node.left, h + 1), dfs(node.right, h + 1));
        else
            return h;
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

    public static void main(String[] args) {
        TreeNode rt = new TreeNode(3);

        TreeNode node2Left = new TreeNode(9);
        TreeNode node2Right = new TreeNode(20);

        TreeNode node3RightLeft = new TreeNode(15);
        TreeNode node3RightRight = new TreeNode(7);

        node2Right.left = node3RightLeft;
        node2Right.right = node3RightRight;

        rt.left = node2Left;
        rt.right = node2Right;

//        TreeNode rt = null;

//        TreeNode rt = new TreeNode(0);

        String s = levelTraversal(rt);

        int h = maxDepth(rt);

        System.out.printf("Maximum Depth of Binary Tree %s = %d", s, h);
    }
}
