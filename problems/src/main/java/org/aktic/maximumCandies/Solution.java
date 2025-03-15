package org.aktic.maximumCandies;

public class Solution {
//    public static int maximumCandies(int[] candies, long k) {
//        int max = 0;
//        boolean maxDivided = false;
//
//        while (!maxDivided) {
//            max++;
//            int left = 0;
//            int count = 0;
//            int rem = candies[left];
//            while (count < k) {
//                if (rem >= max) {
//                    rem -= max;
//                } else {
//                    left++;
//                    while (left < candies.length && candies[left] < max) {
//                        left++;
//                    }
//                    if (left >= candies.length) {
//                        maxDivided = true;
//                        break;
//                    }
//                    rem = candies[left];
//                    rem -= max;
//                }
//                count++;
//            }
//        }
//
//
//        return max - 1;
//    }

    public static int maximumCandies(int[] candies, long k) {
        long totalCandies = 0;
        int maxCandy = 0;

        for (int candy : candies) {
            totalCandies += candy;
            maxCandy = Math.max(maxCandy, candy);
        }

        if (totalCandies < k) return 0;

        int low = 1, high = maxCandy, result = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            long count = 0;

            for (int candy : candies) {
                count += candy / mid;
            }

            if (count >= k) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{1, 2, 3, 4, 10}, 5));
    }
}
