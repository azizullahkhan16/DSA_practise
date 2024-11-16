package org.aktic.hasCycle;

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
    public static boolean hasCycle(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            if(temp.val == Integer.MIN_VALUE) {
                return true;
            }
            temp.val = Integer.MIN_VALUE;
            temp = temp.next;
        }

        return false;


    }


    public static void main(String[] args) {

    }
}
