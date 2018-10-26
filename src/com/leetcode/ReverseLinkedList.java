/**
 * 作者: 和志刚
 * 日期: 2018年10月24日
 * 时间: 下午1:06:48
 */
package com.leetcode;

/**
 * 206. Reverse Linked List
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
	
	/**
	 * iteratively
	 * @param head
	 * @return
	 */
    public static ListNode reverseList(ListNode head) {
    	ListNode prev = null;
    	ListNode current = head;
    	ListNode next = null;
    	while(current!=null) {
    		next = current.next;
    		current.next = prev;
    		prev = current;
    		current = next;
    	}
    	head = prev;
        return head;
    }
    
    /**
     * recursively
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {
    	if (head==null || head.next==null)
    		return head;
    	ListNode p = reverseList2(head.next);
    	head.next.next=head;
    	head.next=null;
        return p;
    }
    
    /**
     * Tail Recursive
     * @param curr
     * @param prev
     * @return
     */
    public static ListNode reverseUtil(ListNode curr, ListNode prev) {
    	ListNode head = null;
    	if (curr.next==null) {
    		head = curr;
    		curr.next=prev;
    		return head;
    	}
    	
    	ListNode next1 = curr.next;
    	curr.next=prev;
    	head = reverseUtil(next1,curr);
    	return head;
    }
    
    public static ListNode reverseList3(ListNode head) {
        if (head!=null)
          return reverseUtil(head,null);        
        else
            return null;
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

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//1->2->3->4->5->NULL
		ListNode head = new ListNode(1);
		ListNode node2=new ListNode(2);
		head.next=node2;
		ListNode node3 = new ListNode(3);
		node2.next=node3;
		ListNode node4 = new ListNode(4);
		node3.next=node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		printLinkedList(head);
		
//		ListNode reversedHead = reverseList(head);
//		printLinkedList(reversedHead);
		
//		ListNode head2 = reverseList2(head);
//		printLinkedList(head2);
		
//		ListNode head3 = reverseUtil(head,null);
		ListNode head3 = reverseList3(head);
		printLinkedList(head3);
	}
}