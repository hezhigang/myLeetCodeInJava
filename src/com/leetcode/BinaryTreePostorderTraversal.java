/**
 * 作者: 和志刚
 * 日期: 2018年11月2日
 * 时间: 上午8:49:44
 */
package com.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 145. Binary Tree Postorder Traversal
 */
public class BinaryTreePostorderTraversal {
	
	/**
	 * 
	 * 非递归后序周游二叉树
	 * @param root
	 * @return
	 */
    public static List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> list = new ArrayList<Integer>();
    	
		if (root!=null) {
			StackElement element = null;
			TreeNode ptr = root;
			Stack<StackElement> stk = new Stack<StackElement>();
			while(true) {
				while(ptr!=null) {
					element = new StackElement();
					element.setTreenode(ptr);
					element.setTag(Tags.Left);;
					stk.push(element);
					ptr = ptr.left;
				}
				element = (StackElement) stk.peek();
				stk.pop();
				ptr = element.getTreenode();
				while( element.getTag()==Tags.Right ) {
					list.add(element.getTreenode().val);		
					if (stk.isEmpty())
						return list;
					else {
						element = (StackElement) stk.peek();
						stk.pop();
						ptr = element.getTreenode();
					}
				}
				element.setTag(Tags.Right);;
				stk.push(element);
				ptr = ptr.right;
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
		List<Integer> list = postorderTraversal(rt);
		list.forEach(System.out::println);
	}

}

enum Tags {Left,Right};

/**
 * 用于非递归后序遍历二叉树
 * @author 和志刚
 *
 */
final class StackElement {
	private TreeNode treenode = null;
	private Tags tag;
	
	public Tags getTag() {
		return tag;
	}
	public void setTag(Tags tag) {
		this.tag = tag;
	}
	public TreeNode getTreenode() {
		return treenode;
	}
	public void setTreenode(TreeNode treenode) {
		this.treenode = treenode;
	}
	/**
	 * 
	 */
	public StackElement() {
		super();
	}
	
}