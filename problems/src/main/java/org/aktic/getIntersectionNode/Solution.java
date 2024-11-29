package org.aktic.getIntersectionNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> setA = new HashSet<>();

        ListNode cur = headA;

        while (cur != null) {
            setA.add(cur);
            cur = cur.next;
        }

        cur = headB;

        while (cur != null) {
            if (setA.contains(cur)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public static void main(String[] args) {

    }
}
