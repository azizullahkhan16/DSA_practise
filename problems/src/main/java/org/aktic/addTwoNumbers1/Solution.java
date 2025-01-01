package org.aktic.addTwoNumbers1;

import java.math.BigInteger;

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
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        String num1 = "";
        String num2 = "";

        ListNode temp = l1;
        while (temp != null) {
            num1 += temp.val;
            temp = temp.next;
        }
        temp = l2;
        while (temp != null) {
            num2 += temp.val;
            temp = temp.next;
        }

        BigInteger numOne = new BigInteger(num1);
        BigInteger numTwo = new BigInteger(num2);
        BigInteger result = numOne.add(numTwo);
        String res = result.toString();

        ListNode dummyHead = new ListNode();
        ListNode dummy = dummyHead;

        for(char c: res.toCharArray()) {
            dummy.next = new ListNode(Character.getNumericValue(c));
            dummy = dummy.next;
        }

        return dummyHead.next;
    }
}
