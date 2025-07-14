package org.aktic.getDecimalValue;

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
    public static int getDecimalValue(ListNode head) {
        String binary = "";

        ListNode temp = head;

        while (temp != null) {
            binary += temp.val;
            temp = temp.next;
        }

        int pow = 0;
        int res = 0;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') res += Math.pow(2, pow);
            pow++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
