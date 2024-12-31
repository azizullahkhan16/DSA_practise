package org.aktic.lemonadeChange;

public class Solution {
    public static boolean lemonadeChange(int[] bills) {
        int num5 = 0;
        int num10 = 0;
        int num20 = 0;

        for (int i = 0; i < bills.length; i++) {
            int change = bills[i]-5;
            if(change > 0){
                if(num20 > 0 && num20 >= change/20) {
                    num20 -= change/20;
                    change -= 20*(change/20);
                }
                if(num10 > 0 && num10 >= change/10){
                    num10 -= change/10;
                    change -= 10*(change/10);
                }
                if(num5 > 0 && num5 >= change/5){
                    num5 -= change/5;
                    change -= 5*(change/5);
                }

                if(change != 0) return false;
            }

            if(bills[i] == 5) num5++;
            else if(bills[i] == 10) num10++;
            else if(bills[i] == 20) num20++;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5,5,5,10,20}));
    }
}
