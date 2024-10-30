package org.aktic.deleteMiddle;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {
//    public static ListNode deleteMiddle(ListNode head) {
//        if(head == null || head.next == null){
//            return null;
//        }
//
//        int count = 0;
//        ListNode temp = head;
//
//        while (temp != null) {
//            count++;
//            temp = temp.next;
//        }
//
//        if(count == 0 || count == 1) return null;
//
//        temp = head;
//
//        for (int i = 0; i < count/2-1; i++) {
//            temp = temp.next;
//        }
//
//        temp.next = temp.next.next;
//
//        return head;
//    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = new ListNode(0, head);
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(deleteMiddle(head));
    }
}