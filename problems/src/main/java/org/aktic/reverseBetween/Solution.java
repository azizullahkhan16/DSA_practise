package org.aktic.reverseBetween;

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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
//        if(head == null) return null;
//        if(head.next == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        int count = 1;



        return dummy.next;
    }
}
