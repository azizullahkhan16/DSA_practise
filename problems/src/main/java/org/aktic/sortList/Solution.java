package org.aktic.sortList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", next=" + next + "]";
    }
}

public class Solution {
//    public static ListNode sortList(ListNode head) {
//        if(head == null || head.next == null) return head;
//        List<Integer> list = new ArrayList<Integer>();
//        ListNode cur = head;
//
//        while (cur != null) {
//            list.add(cur.val);
//            cur = cur.next;
//        }
//
//        Collections.sort(list);
//
//        ListNode newHead = new ListNode(list.get(0));
//        cur = newHead;
//
//        for (int i = 1; i < list.size(); i++) {
//            cur.next = new ListNode(list.get(i));
//            cur = cur.next;
//        }
//
//        return newHead;
//
//    }

    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode middle = getMiddle(head);
        ListNode nextOfMiddle = middle.next;

        middle.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMiddle);

        return merge(left, right);
    }

    public static ListNode getMiddle(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev != null ? prev : head;
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if(left == null) return right;
        if(right == null) return left;

        ListNode result;

        if(left.val <= right.val) {
            result = left;
            result.next = merge(left.next, right);
        }else {
            result = right;
            result.next = merge(left, right.next);
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(3);

        sortList(head);
    }
}
