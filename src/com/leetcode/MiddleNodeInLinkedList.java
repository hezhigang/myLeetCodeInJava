/*
author: hezhigang
date: 10/21/20
time: 5:21 PM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 876. Middle of the Linked List
 * https://leetcode.com/problems/middle-of-the-linked-list/
 */
public class MiddleNodeInLinkedList {
    /**
     *
     * @param head
     * @return
     */
    public static ListNode middleNode_v1(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while(node!=null) {
            list.add(node);
            node = node.next;
        }
        int n = list.size();
        return list.get(n/2);
    }

    /**
     *
     * @param head
     * @return
     */
    public static ListNode middleNode_v2(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        node = head;
        n /= 2;
        while (n > 0) {
            node = node.next;
            n--;
        }
        return node;
    }

    /**
     * Two pointers
     * 15 / 15 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
     * Memory Usage: 36 MB, less than 9.03% of Java online submissions for Middle of the Linked List.
     * @param head
     * @return
     */
    public static ListNode middleNode(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
        }
        return slowPointer;
    }

    public static void main(String[] args) {
        //1->2->6->3->4->5->6->NULL
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
//        ListNode node6 = new ListNode(6);
//        node5.next = node6;

        printLinkedList(head);

        ListNode node = middleNode(head);

        System.out.println("middle node of linked list: ");
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
