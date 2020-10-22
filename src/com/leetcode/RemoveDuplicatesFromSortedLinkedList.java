/*
author: hezhigang
date: 10/22/20
time: 10:58 AM
*/
package com.leetcode;

/**
 * 83. Remove Duplicates from Sorted List
 * https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedLinkedList {
    /**
     * 165 / 165 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
     * Memory Usage: 38.4 MB, less than 10.24% of Java online submissions for Remove Duplicates from Sorted List.
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode node = head;
        while (node != null) {
            if (node.next != null && node.next.val == node.val) {
//                ListNode obsoleteNode = node;
                ListNode obsoleteNode = node.next;
                node.next = node.next.next;
                obsoleteNode = null;
            } else
                node = node.next;
        }
        return head;
    }

    public static void main(String[] args) {
        //1->1->2->3->3->NULL
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(1);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(3);
        node4.next = node5;

        // 1->1->2
//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        head.next = node2;
//        ListNode node3 = new ListNode(2);
//        node2.next = node3;

        printLinkedList(head);

        ListNode node = deleteDuplicates(head);

        printLinkedList(node);
    }

    private static void printLinkedList(ListNode node) {
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            sb.append(node.val);
            node = node.next;
            sb.append(node != null ? "->" : "");
        }
        sb.append("->NULL");
        System.out.println(sb.toString());
    }
}
