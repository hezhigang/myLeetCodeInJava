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
    public static boolean isPalindrome_v1(ListNode head) {
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

    /**
     * Recursion
     * 26 / 26 test cases passed.
     * Runtime: 1418 ms, faster than 5.02% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 42.7 MB, less than 5.11% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public static boolean isPalindrome_recur(ListNode head) {
        if (head == null)
            return true;
        if (head.next == null)
            return true;
        ListNode secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        if (head.val == secondLast.next.val) {
            secondLast.next = null;
            return isPalindrome(head.next);
        } else {
            return false;
        }
    }

    /**
     * Break and reverse second half
     * https://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
     * 26 / 26 test cases passed.
     * Runtime: 1 ms, faster than 95.13% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 41.7 MB, less than 5.11% of Java online submissions for Palindrome Linked List.
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        ListNode p1 = secondHead;
        ListNode p2 = p1.next;
        while (p1 != null && p2 != null) {
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }
        secondHead.next = null;

        //compare two sublists now
        ListNode p = (p2 == null ? p1 : p2);
        ListNode q = head;
        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }

    public static void main(String[] args) {
        // 1 -> 2 -> 2 -> 1
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        head.next = node2;
        ListNode node3 = new ListNode(2);
        node2.next = node3;
        ListNode node4 = new ListNode(1);
        node3.next = node4;

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