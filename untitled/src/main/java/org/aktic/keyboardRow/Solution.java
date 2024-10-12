package org.aktic.keyboardRow;

import java.util.*;

public class Solution {
    public static String[] findWords(String[] words) {
        String[] row = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};

        List<String> result = new ArrayList<String>();

        boolean found;

        for(String key : words) {
            found = false;
            for (int i = 0; i < row.length; i++) {
                if(found)  break;

                for (int j = 0; j < key.length(); j++) {
                    if(!row[i].contains(key.toLowerCase().substring(j, j+1))) {
                        found = false;
                        break;
                    } else found = true;
                }
            }
            if(found) result.add(key);
        }



        return result.toArray(new String[0]);

    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"asdfghjkla","qwertyuiopq","zxcvbnzzm","asdfghjkla","qwertyuiopq","zxcvbnzzm"})));
    }
}
