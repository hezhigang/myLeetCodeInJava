/*
author: hezhigang
date: 10/27/20
time: 11:22 AM
*/
package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 234. Palindrome Linked List
 * https://leetcode.com/problems/palindrome-linked-list/
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {
    /**
     * 26 / 26 test cases passed.
     * Runtime: 2 ms, faster than 39.06% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 42.8 MB, less than 5.11% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        List<ListNode> list = new ArrayList<ListNode>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        int n = list.size();
        for (int i = 0; i < n / 2; i++) {
            if (list.get(i).val != list.get(n - 1 - i).val)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
//        ListNode node3 = new ListNode(2);
//        node2.next = node3;
//        ListNode node4 = new ListNode(1);
//        node3.next = node4;

        printLinkedList(head);
        boolean b = isPalindrome(head);
        System.out.printf("This singly linked list %s a palindrome.", b ? "is" : "is not");
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