package org.aktic.kthCharacter;

public class Solution {
    public static char kthCharacter(int k) {
        StringBuilder res = new StringBuilder();
        res.append('a');

        while (res.length() < k) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < res.length(); i++) {
                if (res.charAt(i) == 'z') temp.append('a');
                else temp.append(Character.toString(res.charAt(i) + 1));
            }

            res.append(temp);
        }


        return res.charAt(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(kthCharacter(5));
    }
}
