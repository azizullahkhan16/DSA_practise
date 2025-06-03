package org.aktic.qluPractise;

public class Solution {
    private static int secondHighest(int[] nums) {
        int firstIndex = -1, first = Integer.MIN_VALUE, secondIndex = -1, second = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                secondIndex = firstIndex;

                first = nums[i];
                firstIndex = i;
            } else if (nums[i] < first && nums[i] > second) {
                second = nums[i];
                secondIndex = i;
            }
        }

        return secondIndex;
    }

    private static String longestCommonPrefix(String[] values) {
        if (values == null || values.length == 0) return "";
        if (values.length == 1) return values[0];

        String res = values[0];

        for (int i = 1; i < values.length; i++) {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < Math.min(res.length(), values[i].length()); j++) {
                if (res.charAt(j) == values[i].charAt(j)) {
                    temp.append(res.charAt(j));
                } else {
                    break;
                }
            }

            res = temp.toString();

            if (res.isEmpty()) return "";
        }

        return res;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] magCount = new int[26];
        int[] noteCount = new int[26];

        for (char c : magazine.toCharArray()) {
            magCount[c - 'a']++;
        }

        for (char c : ransomNote.toCharArray()) {
            noteCount[c - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (noteCount[i] > magCount[i]) return false;
        }

        return true;
    }

    public static int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int mid = -1;
        while (low <= high) {
            mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            }
        }

        return low;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 2, 2, 2, 4, 6}, 3));
    }


}
