package dsa.with.shagun.leetcode.Stack;

import java.util.Stack;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }


    public static String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>();
        boolean[] vis = new boolean[26];
        int[] cnt = new int[26];

        //store the count of each character in the string
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }

        for (char c : s.toCharArray()) {
            //decrement the count
            cnt[c - 'a']--;

            //if character is already visited
            if (vis[c - 'a']) {
                continue;
            }

            //condition check
            // 1. if stack is non-empty
            // 2. if char in string is smaller than top of stack then replace
            // 3.Also check if char in top of stack has more count or not
            while (!stack.isEmpty() && c < stack.peek() && cnt[stack.peek() - 'a'] > 0) {
                // remove top of stack char and mark them unvisited
                vis[stack.pop() - 'a'] = false;
            }
            stack.push(c);
            vis[c - 'a'] = true;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(char c : stack){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }
}
