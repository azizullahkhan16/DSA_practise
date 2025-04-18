package org.aktic.countAndSay;

public class Solution {
//    public static String countAndSay(int n) {
//        if (n == 1) return "1";
//
//        String current = "1";
//
//        for (int i = 2; i <= n; i++) {
//            StringBuilder next = new StringBuilder();
//            int count = 1;
//
//            for (int j = 1; j < current.length(); j++) {
//                if (current.charAt(j) == current.charAt(j - 1)) {
//                    count++;
//                } else {
//                    next.append(count).append(current.charAt(j - 1));
//                    count = 1;
//                }
//            }
//
//            next.append(count).append(current.charAt(current.length() - 1));
//
//            current = next.toString();
//        }
//
//        return current;
//    }

//    public static String countAndSay(int n) {
//        if (n == 1) return "1";
//        String prev = "1";
//
//        for (int i = 2; i <= n; i++) {
//            prev = makeRLE(prev);
//        }
//
//        return prev;
//
//    }

    public static String countAndSay(int n) {
        if (n == 1) return "1";

        String s = countAndSay(n - 1);

        return makeRLE(s);
    }

    public static String makeRLE(String num) {
        StringBuilder res = new StringBuilder();
        int count = 1;

        for (int i = 1; i < num.length(); i++) {
            if (num.charAt(i) != num.charAt(i - 1)) {
                res.append(count);
                res.append(num.charAt(i - 1));
                count = 1;
            } else {
                count++;
            }
        }

        res.append(count);
        res.append(num.charAt(num.length() - 1));

        return res.toString();

    }


    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}