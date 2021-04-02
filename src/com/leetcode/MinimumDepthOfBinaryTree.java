/*
author: hezhigang
date: 4/1/21
time: 3:31 PM
*/
package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthOfBinaryTree {

    /**
     * bfs
     * 52 / 52 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Depth of Binary Tree.
     * Memory Usage: 59.3 MB, less than 77.17% of Java online submissions for Minimum Depth of Binary Tree.
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;
        int h = 0;
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                if (node.left == null && node.right == null)
                    return h + 1;
            }
            h++;
        }
        return h;
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

//        TreeNode rt = new TreeNode(2);
//        TreeNode node2right = new TreeNode(3);
//        TreeNode node3rightright = new TreeNode(4);
//        node2right.right = node3rightright;
//        TreeNode node4rightright = new TreeNode(5);
//        TreeNode node5rightright = new TreeNode(6);
//        node4rightright.right = node5rightright;
//        node3rightright.right = node4rightright;
//        rt.right = node2right;

        dfs(rt);
        System.out.println();

        String s = levelTraversal(rt);

        int h = minDepth(rt);

        System.out.printf("Minimum Depth of Binary Tree %s = %d", s, h);
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

    public static void dfs(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            dfs(root.left);
            dfs(root.right);
        }
    }
}
