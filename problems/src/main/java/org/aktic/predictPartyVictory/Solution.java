package org.aktic.predictPartyVictory;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<Integer>();
        Queue<Integer> dire = new LinkedList<Integer>();

        for (int i = 0; i < senate.length(); i++) {
            if(senate.charAt(i) == 'R') {
                radiant.add(i);
            }else if(senate.charAt(i) == 'D') {
                dire.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if(radiant.peek() < dire.peek()) {
                dire.poll();
                if(!radiant.isEmpty()) radiant.add(radiant.poll()+senate.length());
            }else if(radiant.peek() > dire.peek()) {
                radiant.poll();
                if(!dire.isEmpty()) dire.add(dire.poll()+senate.length());
            }
        }

        return radiant.isEmpty() ? "Dire" : "Radiant";
        


    }


    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }
}
