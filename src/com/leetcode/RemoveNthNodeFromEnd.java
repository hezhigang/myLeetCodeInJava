/**
 * 作者: 和志刚
 * 日期: 2019年2月15日
 * 时间: 下午10:26:14
 */
package com.leetcode;

/**
 * 19. Remove Nth Node From End of List
 */
public class RemoveNthNodeFromEnd {
	
	/**
	 * https://rafal.io/posts/leetcode-19-remove-nth-node-from-end-of-list.html
	 * @param head
	 * @param n
	 * @return
	 */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode fast = head, slow = head;
    	for(int i=0;i<n;i++)
    		fast = fast.next;
    	if (fast==null)
    		head = head.next;
    	else {
    		while(fast.next!=null) {
    			fast = fast.next;
    			slow = slow.next;
    		}
    		ListNode p = slow.next;
    		slow.next = p.next;
    		p.next = null;
    	}
        return head;
    }	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 1->2->3->4->5
		ListNode head = new ListNode(1);
		ListNode node2=new ListNode(2);
		head.next=node2;
		ListNode node3 = new ListNode(3);
		node2.next=node3;
		ListNode node4 = new ListNode(4);
		node3.next=node4;
		ListNode node5 = new ListNode(5);
		node4.next = node5;
		
		int n=2;
//		int n=1;
		
		printLinkedList(head);
		
		removeNthFromEnd(head,n);
		
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
