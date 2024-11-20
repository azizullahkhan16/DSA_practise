package org.aktic.removeNthFromEnd;

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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        if(n == 0) return head;
        if(head.next == null && n==1) return null;

        int count = 0;
        ListNode temp = head;

        while(temp != null) {
            count++;
            temp = temp.next;
        }

        if(count == n) {
            head = head.next;
            return head;
        }

        temp = head;

        for (int i = 0; i < count-n-1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        return head;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        removeNthFromEnd(head, 2);
    }

}
