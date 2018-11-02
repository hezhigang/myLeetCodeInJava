/**
 * 作者: 和志刚
 * 日期: 2018年11月2日
 * 时间: 上午8:35:47
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 144. Binary Tree Preorder Traversal
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */
public class BinaryTreePreorderTraversal {
	
	/**
	 * 北大数据结构与算法教科书的解法
	 * 非递归深度优先周游二叉树
	 * 非递归前序周游二叉树
	 * @param root
	 * @return
	 */
    public static List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
		if (root!=null) {
			TreeNode ptr = root;
			Stack<TreeNode> stk = new Stack<TreeNode>();
			while(!stk.isEmpty() || ptr != null) {
				if (ptr!=null) {
					list.add(ptr.val);
					stk.push(ptr);
					ptr = ptr.left;
				}
				else {
					ptr = (TreeNode) stk.peek();
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
		List<Integer> list = preorderTraversal(rt);
		list.forEach(System.out::println);
	}

}
