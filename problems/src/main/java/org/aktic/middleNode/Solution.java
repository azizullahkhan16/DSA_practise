package org.aktic.middleNode;

import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode [val=" + val + ", next=" + next + "]";
    }
}

public class Solution {
    public static ListNode middleNode(ListNode head) {
        ListNode temp = head;
        int count = 0;

        while (temp != null) {
            temp = temp.next;
            count++;
        }

        int index = 0;
        int max = (count / 2) + 1;
        temp = head;
        
        while (index <= max) {
            temp = temp.next;
            index++;
        }

        return temp;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        System.out.println(middleNode(root));
    }
}
