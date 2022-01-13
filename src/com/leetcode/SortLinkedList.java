/*
author: hezhigang
date: 6/7/21
time: 11:01 PM
*/
package com.leetcode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 */
public class SortLinkedList {

    public static ListNode sortList(ListNode head) {
        return head;
    }

    private static int getLength(ListNode head) {
        if (head == null)
            return 0;
        int n = 1;
        for (ListNode node = head; node.next != null; node = node.next)
            n++;
        return n;
    }

    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
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

    public static void main(String[] args) {
        //4->2->1->3->NULL
        ListNode head = new ListNode(4);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;

        printLinkedList(head);
        System.out.println("len=" + getLength(head));

//        System.out.println("sorted: ");
//		ListNode head2 = sortList(head);
//		printLinkedList(head2);
    }

    private static void printLinkedList(ListNode node) {
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