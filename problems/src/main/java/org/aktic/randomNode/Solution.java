package org.aktic.randomNode;

import java.util.List;
import java.util.Random;

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
    private ListNode head;
    private int size;
    private Random rand;
    public Solution(ListNode head) {
        this.head = head;
        this.size = 0;
        this.rand = new Random();
        ListNode temp = head;
        while (temp != null) {
            this.size++;
            temp = temp.next;
        }
    }

    public int getRandom() {
        int index = rand.nextInt(this.size);

        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            if(count == index) {
                return temp.val;
            }
            temp = temp.next;
            count++;
        }

        return -1;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second  = new ListNode(2);
        ListNode third  = new ListNode(3);
        ListNode fourth = new ListNode(4);

        first.next = second;
        second.next = third;
        third.next = fourth;

        Solution solution = new Solution(first);
        System.out.println(solution.getRandom());
    }
}
