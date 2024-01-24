/*
author: hezhigang
date: 6/7/21
time: 11:01 PM
*/
package com.leetcode;

/**
 * 148. Sort List
 * https://leetcode.com/problems/sort-list/
 * A version of bottom-up mergesort is the method of choice for sorting data organized
 * in a linked list. Consider the list to be sorted sublists of size 1, then pass through to
 * make sorted subarrays of size 2 linked together, then size 4, and so forth. This method
 * rearranges the links to sort the list in place (without creating any new list nodes).
 * Both the top-down and bottom-up approaches to implementing a divide-andconquer
 * algorithm are intuitive.
 */
public class SortLinkedList {

    public static ListNode sortList(ListNode head) {
        final int len = getLength(head);
//        System.out.printf("length of linked list = %d", len);
        ListNode left = head;
        ListNode right = null;
        for (int sz = 1; sz < len; sz *= 2) {
            left = head;
            for (int lo = 0; lo < len - sz; lo += sz + sz) {
                int mid = lo + sz - 1;
                int hi = Math.min(lo + sz + sz - 1, len - 1);
                right = left.next;
                left = mergeTwoLists(left, right);
            }
        }
        head = left;
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

    /**
     * How To Merge Two Sorted Lists
     * https://hackernoon.com/how-to-merge-two-sorted-lists
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        if (l1 != null) {
            current.next = l1;
        }

        if (l2 != null) {
            current.next = l2;
        }

        return dummy.next;
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

        System.out.println("sorted: ");
		ListNode head2 = sortList(head);
		printLinkedList(head2);
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