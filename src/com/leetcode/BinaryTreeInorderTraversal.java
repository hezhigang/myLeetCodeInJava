/**
 * 作者: 和志刚
 * 日期: 2018年10月31日
 * 时间: 下午8:11:54
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 94. Binary Tree Inorder Traversal
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreeInorderTraversal {
	
	/**
	 * 北大数据结构与算法教科书的解法
	 * 非递归深度优先周游二叉树
	 * 非递归中序周游二叉树
	 * @param root
	 * @return
	 */
    public static List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
		if (root!=null) {
			TreeNode ptr = root;
			Stack<TreeNode> stk = new Stack<TreeNode>();
			while(!stk.isEmpty() || ptr != null) {
				if (ptr!=null) {
					stk.push(ptr);
					ptr = ptr.left;
				}
				else {
					ptr = (TreeNode) stk.peek();
					list.add(ptr.val);
					ptr = ptr.right;
					stk.pop();
				}
			}			
		}
		return list;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode rt = new TreeNode(1);
		TreeNode l2r = new TreeNode(2);
		TreeNode l3leaf = new TreeNode(3);
		l2r.left=l3leaf;
		rt.right=l2r;
		List<Integer> list = inorderTraversal(rt);
		list.forEach(System.out::println);
	}

}
