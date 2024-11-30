package org.aktic.detectCycle;

import java.util.HashSet;
import java.util.List;
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
//    public static ListNode detectCycle(ListNode head) {
//        Set<ListNode> set = new HashSet<>();
//
//        ListNode curr = head;
//
//        while (curr != null) {
//            if (set.contains(curr.next)) {
//                return curr.next;
//            }
//
//            set.add(curr);
//            curr = curr.next;
//        }
//
//        return null;
//    }

    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) return null;

        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        // Create nodes for the linked list
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        detectCycle(node1);

    }
}
