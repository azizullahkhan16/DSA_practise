package org.aktic.canPlaceFlowers;

public class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1 && flowerbed[0] == 1 && n > 0) return false;
        else if(flowerbed.length == 1 && flowerbed[0] == 0 && n < 1) return true;
        int i = 0;
        if(flowerbed[0] == 0 && flowerbed[1] == 0) {
            n--;
            i+=2;
        } else i = 1;

        for (; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) i++;
            else if(flowerbed[i] == 0 && flowerbed[i-1] == 0) {
                if(i+1 < flowerbed.length && flowerbed[i+1] == 0) {
                    n -= 1;
                    i++;
                } else if(i+1 >= flowerbed.length) {
                    n -= 1;
                    i++;
                }
            }

            if(n == 0) return true;

        }

        return n == 0;

    }

    public static void main(String[] args) {
        int[] flowerbed = {0,1,0};
        System.out.println(canPlaceFlowers(flowerbed, 1));
    }
}

