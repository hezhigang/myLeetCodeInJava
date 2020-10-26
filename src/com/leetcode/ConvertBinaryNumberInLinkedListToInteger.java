/*
author: hezhigang
date: 10/26/20
time: 1:12 PM
*/
package com.leetcode;

/**
 * 1290. Convert Binary Number in a Linked List to Integer
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 */
public class ConvertBinaryNumberInLinkedListToInteger {

    /**
     * 102 / 102 test cases passed
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * Memory Usage: 36.4 MB, less than 10.97% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * @param head
     * @return
     */
    public static int getDecimalValue(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            n++;
            node = node.next;
        }
        node = head;
        int x = 0;
        for (int i = n - 1; i > 0; i--) {
            x += node.val * (2 << (i - 1));
            node = node.next;
        }
        x += node.val;
        return x;
    }

    public static void main(String[] args) {
        // 1->0->1
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(0);
        head.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;

        System.out.println("Input: head = ");
        printLinkedList(head);

        int i = getDecimalValue(head);
        System.out.printf("the decimal value of the number in the linked list = %d", i);
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
