/*
author: hezhigang
date: 5/19/21
time: 1:18 PM
*/
package com.leetcode;

/**
 * 147. Insertion Sort List
 * https://leetcode.com/problems/insertion-sort-list/
 */
public class InsertionSortList {

    /**
     *
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        for (ListNode node = head; node != null; node = node.next) {

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        ListNode list_node2 = new ListNode(2);
        head.next = list_node2;
        ListNode list_node3 = new ListNode(1);
        list_node2.next = list_node3;
        ListNode list_node4 = new ListNode(3);
        list_node3.next = list_node4;
        t(head);
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
