package org.aktic.addTwoNumbers;

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
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        StringBuilder num1 = new StringBuilder();
//        StringBuilder num2 = new StringBuilder();
//
//        while (l1 != null) {
//            num1.append(l1.val);
//            l1 = l1.next;
//        }
//
//        while (l2 != null) {
//            num2.append(l2.val);
//            l2 = l2.next;
//        }
//
//        num1 = num1.reverse();
//        num2 = num2.reverse();
//
//        BigInteger a = new BigInteger(num1.toString());
//        BigInteger b = new BigInteger(num2.toString());
//        BigInteger result = a.add(b);
//        StringBuilder num3 = new StringBuilder();
//        num3.append(result);
//        num3 = num3.reverse();
//        String res = num3.toString();
//
//        ListNode head = new ListNode(res.charAt(0)-'0');
//        ListNode cur = head;
//
//        for (int i = 1; i < res.length(); i++) {
//            cur.next = new ListNode(res.charAt(i)-'0');
//            cur = cur.next;
//        }
//
//        return head;
//    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;

        while (l1 != null || l2 != null || carry > 0) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);

        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);

    }


}
