/*
author: hezhigang
date: 10/23/20
time: 4:30 PM
*/
package com.leetcode;

import java.util.Deque;
import java.util.LinkedList;
//import java.util.Stack;

/**
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionTwoLinkedLists {
    /**
     * 46 / 46 test cases passed.
     * Runtime: 2 ms, faster than 38.55% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 42.6 MB, less than 11.53% of Java online submissions for Intersection of Two Linked Lists.
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
//        Stack<ListNode> stkA = new Stack<ListNode>();
        Deque<ListNode> stkA = new LinkedList<ListNode>();
        ListNode node = headA;
        while (node != null) {
            stkA.push(node);
            node = node.next;
        }
//        Stack<ListNode> stkB = new Stack<ListNode>();
        Deque<ListNode> stkB = new LinkedList<ListNode>();
        node = headB;
        while (node != null) {
            stkB.push(node);
            node = node.next;
        }
        while (!stkA.isEmpty() && !stkB.isEmpty()) {
            if (stkA.peek() == stkB.peek()) {
                node = stkA.pop();
                stkB.pop();
            } else
                break;
        }
        return node;
    }

    public static void main(String[] args) {
        //4->1->8->4->5
        ListNode nodeC1 = new ListNode(8);
        ListNode nodeC2 = new ListNode(4);
        nodeC1.next = nodeC2;
        ListNode nodeC3 = new ListNode(5);
        nodeC2.next = nodeC3;

        ListNode headA = new ListNode(4);
        ListNode nodeA2 = new ListNode(1);
        headA.next = nodeA2;
        nodeA2.next = nodeC1;

        // 5->6->1->8->4->5
        ListNode headB = new ListNode(5);
        ListNode nodeB2 = new ListNode(6);
        headB.next = nodeB2;
        ListNode nodeB3 = new ListNode(1);
        nodeB2.next = nodeB3;
        nodeB3.next = nodeC1;

        System.out.println("list A: ");
        printLinkedList(headA);
        System.out.println();
        System.out.println("list B: ");
        printLinkedList(headB);
        System.out.println();

        ListNode node = getIntersectionNode(headA, headB);
        System.out.println("Intersection of Two Linked Lists: ");
        printLinkedList(node);
    }

    /**
     * traverse linked list in reverse order
     * Recursive
     * @param node
     */
    private static void printBack(ListNode node) {
        if (node == null)
            return;
        printBack(node.next);
        System.out.printf("%d->",node.val);
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