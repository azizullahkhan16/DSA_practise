package org.aktic.rotateRight;

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
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Step 1: Compute the length of the list
        int count = 1;
        ListNode temp = head;
        while (temp.next != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Handle cases where k >= count
        k = k % count;
        if (k == 0) {
            return head; // No rotation needed
        }

        // Step 3: Connect the tail to the head to form a circular list
        temp.next = head;

        // Step 4: Find the new tail (count - k - 1 steps from the head)
        ListNode newTail = head;
        for (int i = 0; i < count - k - 1; i++) {
            newTail = newTail.next;
        }

        // Step 5: Set the new head and break the circular connection
        head = newTail.next;
        newTail.next = null;

        return head;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        rotateRight(head, 2);
    }
}
