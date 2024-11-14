package org.aktic.simplifyPath;

import java.util.Stack;

public class Solution {
    public static String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        path = path.substring(1);
        String[] parts = path.split("/");

        Stack<String> stack = new Stack<>();

        for (int i = 0; i < parts.length; i++) {
           if(parts[i].equals("..")) {
               int temp = 0;
               while(!stack.isEmpty() && temp < 2) {
                   stack.pop();
                   temp++;
               }
           }else if(!parts[i].equals(".")) {
               stack.push("/");
               stack.push(parts[i]);
           }
        }

        if(stack.isEmpty()) stack.push("/");

        StringBuilder sb = new StringBuilder();
        for(String s : stack) {
            sb.append(s);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));
    }
}
