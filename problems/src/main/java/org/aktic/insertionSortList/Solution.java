package org.aktic.insertionSortList;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
//    public static ListNode insertionSortList(ListNode head) {
//        ListNode temp = head.next;
//        ListNode prev = head;
//
//        while(temp != null) {
//            if(head.val >= temp.val) {
//                ListNode inter = temp.next;
//                temp.next = head;
//                prev.next = inter;
//                head = temp;
//                temp = inter;
//            }else {
//                ListNode start = head;
//                ListNode startPrev = null;
//                while(start.val < temp.val) {
//                    startPrev = start;
//                    start = start.next;
//                }
//                if(temp == start) {
//                    prev = temp;
//                    temp = temp.next;
//                    continue;
//                }
//                ListNode inter = temp.next;
//                temp.next = start;
//                startPrev.next = temp;
//                prev.next = inter;
//                temp = inter;
//            }
//        }
//
//        return head;
//
//
//    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Dummy node to act as a new head for the sorted part of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = head.next;  // The current node to be inserted.
        head.next = null;  // End the sorted list.

        while (curr != null) {
            ListNode prev = dummy;  // Start from the beginning of the sorted list.
            ListNode next = curr.next;  // Save the next node to be processed.

            // Find the correct position to insert the current node.
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert the current node in its correct position.
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node.
            curr = next;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-1);
        head.next = new ListNode(5);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(0);


        insertionSortList(head);
    }
}
