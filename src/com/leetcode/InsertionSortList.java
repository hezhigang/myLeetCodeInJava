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
     * https://www.enjoyalgorithms.com/blog/sort-linked-list-using-insertion-sort
     * Accepted
     * Runtime 18ms Beats 63.20% of users with Java
     * Memory 42.99mb Beats 90.09% of users with Java
     * @param head
     * @return
     */
    public static ListNode insertionSortList(ListNode head) {
        ListNode node = head;
        ListNode sortedHead = null;
        while (node != null) {
            ListNode nextNode = node.next;
            sortedHead = sortedInsert(sortedHead, node);
            node = nextNode;
        }
        return sortedHead;
    }

    /**
     * https://www.enjoyalgorithms.com/blog/sort-linked-list-using-insertion-sort
     * @param sortedHead
     * @param node
     * @return
     */
    private static ListNode sortedInsert(ListNode sortedHead, ListNode node) {
        if (sortedHead == null || sortedHead.val >= node.val) {
            node.next = sortedHead;
            return node;
        } else {
            ListNode temp = sortedHead;
            while (temp.next != null && temp.next.val < node.val) {
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
        }
        return sortedHead;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(6);
        ListNode list_node2 = new ListNode(5);
        head.next = list_node2;
        ListNode list_node3 = new ListNode(3);
        list_node2.next = list_node3;
        ListNode list_node4 = new ListNode(1);
        list_node3.next = list_node4;
        ListNode list_node5 = new ListNode(8);
        list_node4.next = list_node5;
        ListNode list_node6 = new ListNode(7);
        list_node5.next = list_node6;
        ListNode list_node7 = new ListNode(2);
        list_node6.next = list_node7;
        ListNode list_node8 = new ListNode(4);
        list_node7.next = list_node8;

//        head = insertionSortList(head);

//        ListNode head = new ListNode(4);
//        ListNode list_node2 = new ListNode(2);
//        head.next = list_node2;
//        ListNode list_node3 = new ListNode(1);
//        list_node2.next = list_node3;
//        ListNode list_node4 = new ListNode(3);
//        list_node3.next = list_node4;

        t(head);

        System.out.println();

        head = insertionSortList(head);

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