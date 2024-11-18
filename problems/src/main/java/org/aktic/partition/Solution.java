package org.aktic.partition;

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
    public static ListNode partition(ListNode head, int x) {
        if (head == null) return null;

        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        while (head != null) {
            if (head.val < x) {
                less.next = head;
                less = less.next;
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }

        greater.next = null;
        less.next = greaterHead.next;

        return lessHead.next;
    }

    public static void main(String[] args) {
        ListNode sixth = new ListNode(2);
        ListNode fifth = new ListNode(5, sixth);
        ListNode fourth = new ListNode(2, fifth);
        ListNode third = new ListNode(3, fourth);
        ListNode second = new ListNode(4, third);
        ListNode first = new ListNode(1, second);

        partition(first, 3);
    }
}
