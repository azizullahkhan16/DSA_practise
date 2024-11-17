package org.aktic.copyRandomList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {
    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        ArrayList<Node> tempPointers = new ArrayList<Node>();
        Map<Node, Integer> map = new HashMap<Node, Integer>();
        int index = 0;

        Node dummy = new Node(head.val);
        tempPointers.add(dummy);
        map.put(head, index);
        Node temp = dummy;
        Node cur = head.next;
        index = 1;


        while (cur != null) {
            temp.next = new Node(cur.val);
            tempPointers.add(temp.next);
            map.put(cur, index);
            cur = cur.next;
            temp = temp.next;
            index++;
        }

        temp = dummy;
        cur = head;
        while (temp != null) {
            if(cur.random != null) temp.random = tempPointers.get(map.get(cur.random));
            else temp.random = null;
            cur = cur.next;
            temp = temp.next;
        }

        return dummy;

    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);

        // Link the nodes to form the list
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        // Set up random pointers
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        copyRandomList(node1);

    }
}
