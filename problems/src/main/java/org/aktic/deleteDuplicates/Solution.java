package org.aktic.deleteDuplicates;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode newHead = new ListNode(-1);
        newHead.next = head;
        ListNode curr = newHead;
        while(curr.next != null) {
            ListNode duplicate = curr.next;
            while(duplicate.next != null && duplicate.val == duplicate.next.val) {
                duplicate = duplicate.next;
            }

            if(curr.next != duplicate) curr.next = duplicate.next;
            else curr = curr.next;
        }

        return newHead.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        deleteDuplicates(head);
    }
}
