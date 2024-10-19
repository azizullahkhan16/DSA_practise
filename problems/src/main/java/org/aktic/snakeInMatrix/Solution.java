package org.aktic.snakeInMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for(String com : commands) {
            if(com.equals("UP")) i--;
            else if(com.equals("DOWN")) i++;
            else if(com.equals("LEFT")) j--;
            else if(com.equals("RIGHT")) j++;
        }

        return (i*n) + j;

    }


    public static void main(String[] args) {
        List<String> commands = new ArrayList<String>();
        commands.add("RIGHT");
        commands.add("DOWN");
        System.out.println(finalPositionOfSnake(2, commands));
    }
}
