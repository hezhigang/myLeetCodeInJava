/*
author: hezhigang
date: 10/26/20
time: 2:26 PM
*/
package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 141. Linked List Cycle
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class LinkedListCycle {

    /**
     * 17 / 17 test cases passed.
     * Runtime: 3 ms, faster than 19.93% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.5 MB, less than 11.80% of Java online submissions for Linked List Cycle.
     * @param head
     * @return
     */
    public static boolean hasCycle_slow(ListNode head) {
        boolean b = false;
        Set<ListNode> coll = new HashSet<ListNode>();
        ListNode node = head;
        while (node != null) {
            if (!coll.contains(node)) {
                coll.add(node);
            } else {
                b = true;
                break;
            }
            node = node.next;
        }
        return b;
    }

    /**
     * Two pointers
     * 17 / 17 test cases passed.
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.3 MB, less than 12.07% of Java online submissions for Linked List Cycle.
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        boolean b = false;
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;
            if (fastPointer != null && fastPointer.next == slowPointer) {
                b = true;
                break;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        // head = 3 -> 2 -> 0 -> -4, pos=1
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(0);
        node2.next = node3;
        ListNode node4 = new ListNode(-4);
        node3.next = node4;
        node4.next = node2;

        // 1
//        ListNode head = new ListNode(1);

//        ListNode head = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        head.next = node2;
//        node2.next = head;

        printLinkedList(head);

        boolean b = hasCycle(head);

        System.out.printf("There is %s cycle in the linked list", b ? "a" : "no");
    }

    private static void printLinkedList(ListNode node) {
        Set<ListNode> coll = new HashSet<ListNode>();
        StringBuilder sb = new StringBuilder();
        while (node != null) {
            if (!coll.contains(node)) {
                coll.add(node);
                sb.append(node.val);
                sb.append("->");
            } else {
                sb.append(node.val);
                break;
            }
            node = node.next;
        }
        System.out.println(sb.toString());
    }
}
