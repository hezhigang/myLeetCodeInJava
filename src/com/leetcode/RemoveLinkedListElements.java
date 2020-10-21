/*
author: hezhigang
date: 10/20/20
time: 9:11 PM
*/
package com.leetcode;

/**
 * 203. Remove Linked List Elements
 * https://leetcode.com/problems/remove-linked-list-elements/
 */
public class RemoveLinkedListElements {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    /**
     * Runtime: 1 ms, faster than 82.56% of Java online submissions for Remove Linked List Elements.
     * Memory Usage: 40 MB, less than 10.13% of Java online submissions for Remove Linked List Elements.
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return head;
        ListNode previousNode = head;
        if (head != null) {
            ListNode node = head.next;
            while (node != null) {
                if (node.val == val) {
                    ListNode obsoleteNode = node;
                    previousNode.next = node.next;
                    obsoleteNode = null;
                }
                else
                    previousNode = node;
                node = node.next;
            }
        }
        if (head.val == val) {
            ListNode obsoleteNode = head;
            head = head.next;
            obsoleteNode = null;
        }
        return head;
    }

    public static void main(String[] args) {
        //1->2->6->3->4->5->6->NULL
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(6);
        node2.next = node3;
        ListNode node4 = new ListNode(3);
        node3.next = node4;
        ListNode node5 = new ListNode(4);
        node4.next = node5;
        ListNode node6 = new ListNode(5);
        node5.next = node6;
        ListNode node7 = new ListNode(6);
        node6.next = node7;

//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        head.next = node2;
//        ListNode node3 = new ListNode(1);
//        node2.next = node3;

        printLinkedList(head);

        final int val = 6;
//        final int val = 1;

        ListNode node = removeElements(head, val);

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