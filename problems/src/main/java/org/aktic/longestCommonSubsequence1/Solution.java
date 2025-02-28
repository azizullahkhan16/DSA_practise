package org.aktic.longestCommonSubsequence1;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(target), i};
            } else {
                map.put(target - nums[i], i);
            }
        }

        return null;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        if (nums[left] > 0) return new ArrayList<>();

        while (left + 1 < right) {
            if (nums[left] + nums[left + 1] + nums[right] == 0) {
                res.add(Arrays.asList(nums[left], nums[left + 1], nums[right]));
            } else if (nums[left] + nums[right - 1] + nums[right] == 0) {
                res.add(Arrays.asList(nums[left], nums[right - 1], nums[right]));
            }

            if (nums[left] > 0) break;

            if (-nums[left] > nums[right]) {
                left++;
            } else {
                right--;
            }
        }

        return res;

    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];


        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = dp[i].length - 2; j >= 0; j--) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];

    }

    public static int[] twoSum2(int[] numbers, int target) {

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum > target) {
                right--;
            } else if (sum < target) {
                left++;
            } else return new int[]{left + 1, right + 1};
        }

        return null;
    }

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int threeSum = nums[i] + nums[left] + nums[right];

                if (threeSum < target) {
                    left++;
                } else if (threeSum > target) {
                    right--;
                } else return threeSum;

                if (Math.abs(target - threeSum) < Math.abs(target - res)) res = threeSum;
            }
        }

        return res;
    }

    public static String decodeString(String s) {
        return helper(s, new int[]{0}); // Use an index array to track position
    }

    private static String helper(String s, int[] index) {
        StringBuilder res = new StringBuilder();
        int num = 0;

        while (index[0] < s.length()) {
            char c = s.charAt(index[0]);

            if (Character.isDigit(c)) {
                // Build the number (handle multiple digits like "23[a]")
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                // Move index past '[' and decode the substring recursively
                index[0]++;
                String sub = helper(s, index);
                // Repeat and append the decoded substring
                while (num > 0) {
                    res.append(sub);
                    num--;
                }
            } else if (c == ']') {
                // End of recursion, return the built string
                return res.toString();
            } else {
                // Normal character, just append to result
                res.append(c);
            }

            index[0]++; // Move to the next character
        }

        return res.toString();
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = -1;
        int diff = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                max = -1;
                min = prices[i];
            } else if (prices[i] > max) {
                max = prices[i];
                if (min != Integer.MAX_VALUE) diff = Math.max(diff, max - min);
            }
        }

        return diff;
    }

    public static boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sChar[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            tChar[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sChar[i] != tChar[i]) return false;
        }

        return true;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = 0;
        int right = 0;
        int count = 0;
        int[] res = new int[nums1.length];

        while (left < m && right < n) {
            if (nums1[left] > nums2[right]) {
                res[count] = nums2[right];
                right++;
            } else {
                res[count] = nums1[left];
                left++;
            }

            count++;
        }

        while (left < m) {
            res[count] = nums1[left];
            count++;
            left++;
        }

        while (right < n) {
            res[count] = nums2[right];
            count++;
            right++;
        }

        for (int i = 0; i < res.length; i++) {
            nums1[i] = res[i];
        }
    }


    public static int removeDuplicates(int[] nums) {
        int place = 1;

        for (int i = 1; i < nums.length; i++) {
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length) break;
            nums[place] = nums[i];
            place++;
        }

        return place;

    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;
        Map<Character, Integer> map = new HashMap<>();
        int max = 1;

        int left = 0;
        int right = 0;

        for (; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                for (; left < map.get(s.charAt(right)); left++) {
                    map.remove(s.charAt(left));
                }
                left = map.get(s.charAt(right)) + 1;
                map.put(s.charAt(right), right);
            } else {
                map.put(s.charAt(right), right);
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abba"));
    }
}
