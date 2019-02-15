/**
 * 作者: 和志刚
 * 日期: 2019年2月13日
 * 时间: 下午2:57:56
 */
package com.leetcode;

/**
 * 237. Delete Node in a Linked List
 */
public class DeleteNodeOfLinkedList {
	
	/**
	 * How do I delete a node in a linked list?
	 * https://www.quora.com/How-do-I-delete-a-node-in-a-linked-list
	 * @param node
	 */
    public static void deleteNode(ListNode node) {
    	ListNode temp = node.next;
    	node.val = temp.val;
    	node.next = temp.next;
    	temp = null;
    	
    	// delete next node
//    	ListNode temp = node.next;
//    	if (temp!=null)
//    		node.next = temp.next;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//4->5->1->9
		ListNode head = new ListNode(4);
		ListNode node2=new ListNode(5);
		head.next=node2;
		ListNode node3 = new ListNode(1);
		node2.next=node3;
		ListNode node4 = new ListNode(9);
		node3.next=node4;
		
		printLinkedList(head);
		
//		deleteNode(node2);
		deleteNode(node3);
		
		printLinkedList(head);
	}
	
    public static void printLinkedList(ListNode node) {
    	StringBuilder sb = new StringBuilder();
    	while(node!=null) {
    		sb.append(node.val);
    		node = node.next;
    		sb.append(node!=null?"->":"");
    	}
    	sb.append("->NULL");
    	System.out.println(sb.toString());
    }
}