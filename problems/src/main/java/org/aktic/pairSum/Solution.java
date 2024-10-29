package org.aktic.pairSum;

import java.util.HashMap;
import java.util.Map;

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

    public static int pairSum(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        temp = head;
        for (int i = 0; i < count/2; i++) {
            map.put(i, temp.val);
            temp = temp.next;
        }

        int max = 0;
        for (int i = count/2; i < count; i++) {
            int num = map.get(Math.abs(i-count+1))+temp.val;
            map.put(Math.abs(i-count+1), num);
            max = Math.max(max, num);
            temp = temp.next;
        }

        return max;
    }

    public static void main(String[] args) {
        ListNode fourth = new ListNode(1);
        ListNode third = new ListNode(2, fourth);
        ListNode second = new ListNode(4, third);
        ListNode first = new ListNode(5, second);

        System.out.println(pairSum(first));


    }
}
