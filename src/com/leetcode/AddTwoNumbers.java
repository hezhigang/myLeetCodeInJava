/**
 * 作者: 和志刚
 * 日期: 2018年5月6日
 * 时间: 上午4:08:55
 */
package com.leetcode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n13 = new ListNode(3);
		 
		ListNode n12 = new ListNode(4);
		n12.next = n13;
		
		ListNode n1 = new ListNode(2);
		n1.next = n12;
		
//		ListNode n0 = new ListNode(5);
//		n0.next = n1;
		
		System.out.println("----------n1------------");
		t(n1);
		
		ListNode n2 = new ListNode(5);
		ListNode n22 = new ListNode(6);
		n2.next = n22;
		ListNode n23 = new ListNode(4);
		n22.next = n23;
		
		System.out.println("----------n2------------");
		t(n2);
		
		ListNode r = addTwoNumbers(n1,n2);
		System.out.println("----------sum as below------------");
		t(r);
	}
	
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode node1 = l1, node2 = l2;
    	ListNode node = null, tmpNode = null;
    	int sum = 0;
    	boolean b = false;
		while (node1 != null || node2!=null) {
//			System.out.println("--------------------");
//			if (node1!=null) {
//				System.out.println(node1.val);
//			}
//			if (node2 != null) {
//				System.out.println(node2.val);
//			}
//			System.out.println("--------------------");
			node = new ListNode(0);
			sum = (node1!=null?node1.val:0) + (node2!=null?node2.val:0);
			if (b) sum++;
			node.val = sum<10?sum:sum%10;
			b = sum>=10 ? true : false;
			if (tmpNode!=null)
				node.next = tmpNode;
//				tmpNode.next = node;
			if (node1!=null)
			  node1 = node1.next;
			if (node2!=null)
			  node2 = node2.next;
			tmpNode = node;
		}
		if (b) {
			ListNode node3 = node;
			node = new ListNode(1);
			node.next = node3;
//			ListNode node3 = new ListNode(1);
//			node.next = node3;
		}
    	ListNode prev = null;
    	ListNode current = node;
    	ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }
    
    /* Function to reverse the linked list */
    private static ListNode reverse(ListNode node) {
    	ListNode prev = null;
    	ListNode current = node;
    	ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }    
    
	public static void t(ListNode node) {
		while (node != null) {
			if (node!=null) {
				System.out.println(node.val);
			}			
			node = node.next;
		}
	}    	
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}