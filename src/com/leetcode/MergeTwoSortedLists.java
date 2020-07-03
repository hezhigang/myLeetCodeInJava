/**
 * 作者: 和志刚
 * 日期: 2019年1月18日
 * 时间: 上午6:40:22
 */
package com.leetcode;

/**
 * 21. Merge Two Sorted Lists
 */
public class MergeTwoSortedLists {

	/**
	 * defining a fake head
	 * https://www.programcreek.com/2012/12/leetcode-merge-two-sorted-lists-java/
	 * @param l1
	 * @param l2
	 * @return
	 */
	public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode head = new ListNode(0);
		ListNode p = head;

		ListNode p1 = l1;
		ListNode p2 = l2;
		while (p1 != null && p2 != null) {
			if (p1.val < p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}
			p = p.next;
		}

		if (p1 != null) {
			p.next = p1;
		}

		if (p2 != null) {
			p.next = p2;
		}

		return head.next;
	}
	
	/**
	 * Java, 1 ms, 4 lines codes, using recursion
	 * https://leetcode.com/problems/merge-two-sorted-lists/discuss/9715/Java-1-ms-4-lines-codes-using-recursion
	 * @param l1
	 * @param l2
	 * @return
	 */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	if (l1==null) return l2;
    	if (l2==null) return l1;
    	if (l1.val<l2.val) {
    		l1.next = mergeTwoLists(l1.next,l2);
    		return l1;
    	}
    	else {
    		l2.next = mergeTwoLists(l1,l2.next);
    		return l2;
    	}
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode list1_node1 = new ListNode(1);
		ListNode list1_node2 = new ListNode(2);
		list1_node1.next = list1_node2;
		ListNode list1_node3 = new ListNode(4);
		list1_node2.next = list1_node3;
		
		ListNode list2_node1 = new ListNode(1);
		ListNode list2_node2 = new ListNode(3);
		list2_node1.next = list2_node2;
		ListNode list2_node3 = new ListNode(4);
		list2_node2.next = list2_node3;
		
//		ListNode list = mergeTwoLists(list1_node1,list2_node1);
		ListNode list = mergeTwoLists2(list1_node1,list2_node1);
		
		t(list);
	}
	
	public static void t(ListNode node) {
		while (node != null) {
			if (node!=null) {
				System.out.print(node.val);
				if (node.next!=null)
					System.out.print(" -> ");
			}			
			node = node.next;
		}
	}

}