package org.aktic.isPalindromeI;

import java.util.Stack;

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
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        Stack<Integer> stack = new Stack<>();

        ListNode curr = head;
        int count = 0;

        while (curr != null) {
            count++;
            curr = curr.next;
        }

        int mid = count / 2;
        curr = head;

        for (int i = 0; i < count; i++) {
            if(i < count/2) stack.push(curr.val);
            else if(i > count/2 || (count % 2 == 0)) {
                if(stack.peek() != curr.val) return false;
                else stack.pop();
            }
            curr = curr.next;

        }

        return stack.isEmpty();

    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        isPalindrome(head);
    }
}
