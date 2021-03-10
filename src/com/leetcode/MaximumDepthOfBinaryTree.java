/*
author: hezhigang
date: 3/9/21
time: 11:14 AM
*/
package com.leetcode;

import java.util.*;

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
    public static int maxDepth_recur(TreeNode root) {
        return recur(root, 0);
    }

    /**
     * Recursion
     * @param node
     * @param h
     * @return
     */
    private static int recur(TreeNode node, int h) {
        if (node != null)
            return Math.max(recur(node.left, h + 1), recur(node.right, h + 1));
        else
            return h;
    }

    public static void dfs(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            dfs(root.left);
            dfs(root.right);
        }
    }

    public static void dfs_preOrder_noRecur(TreeNode root) {
        if (root != null) {
            TreeNode node = root;
            Deque<TreeNode> stk = new LinkedList<TreeNode>();
            while (!stk.isEmpty() || node != null) {
                if (node != null) {
                    System.out.print(node.val+" ");
                    stk.addFirst(node);
                    node = node.left;
                } else {
                    node = stk.peekFirst();
                    node = node.right;
                    stk.removeFirst();
                }
            }
        }
    }

    /**
     * Finding max depth of binary tree without recursion
     * https://stackoverflow.com/questions/19886297/finding-max-depth-of-binary-tree-without-recursion
     * This variant uses two stacks, one for additional nodes to explore (wq) and
     * one always containing the current path from the root (path).
     * When we see the same node on the top of both stacks
     * it means we've explored everything below it and can pop it.
     * This is the time to update the tree depth too.
     * On random or balanced trees the additional space should be O(log n),
     * in the worst case O(n), of course.
     * 39 / 39 test cases passed.
     * Runtime: 3 ms, faster than 5.14% of Java online submissions for Maximum Depth of Binary Tree.
     * Memory Usage: 38.6 MB, less than 96.88% of Java online submissions for Maximum Depth of Binary Tree.
     * @param root
     * @return
     */
    public static int maxDepth(TreeNode root) {
        int depth = 0;
        if (root == null) return 0;
        Deque<TreeNode> wq = new LinkedList<TreeNode>();
        Deque<TreeNode> path = new LinkedList<TreeNode>();

        wq.push(root);
        while (!wq.isEmpty()) {
            root = wq.peek();
            if (!path.isEmpty() && root == path.peek()) {
                if (path.size() > depth)
                    depth = path.size();
                path.pop();
                wq.pop();
            } else {
                path.push(root);
                if (root.right != null)
                    wq.push(root.right);
                if (root.left != null)
                    wq.push(root.left);
            }
        }

        return depth;
    }

    /**
     * Day 39— Max Depth of Binary Tree Using BFS
     * https://medium.com/javarevisited/day-39-max-depth-of-binary-tree-using-bfs-2df05aa8e8c4
     * @param root
     * @return
     */
    public static int maxDepth_bfs(TreeNode root) {
        int h = 0;
        if (root == null) return 0;
        TreeNode node = null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            h++;
        }
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

//        TreeNode rt = new TreeNode(1);
//        TreeNode node2Right = new TreeNode(2);
//        rt.right = node2Right;

//        TreeNode rt = new TreeNode(1);
//        TreeNode node2Left = new TreeNode(2);
//        TreeNode node3LeftLeft = new TreeNode(3);
//        node2Left.left = node3LeftLeft;
//        TreeNode node4LeftLeft = new TreeNode(4);
//        TreeNode node5LeftLeft = new TreeNode(5);
//        node4LeftLeft.left = node5LeftLeft;
//        node3LeftLeft.left = node4LeftLeft;
//        rt.left = node2Left;

        dfs(rt);
        System.out.println();

        String s = levelTraversal(rt);

        int height = maxDepth_recur(rt);

        int h = maxDepth(rt);

        System.out.printf("Maximum Depth of Binary Tree %s = %d", s, height);
        System.out.println();
        System.out.printf("Maximum Depth of Binary Tree %s = %d", s, h);
    }
}