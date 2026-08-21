package string.easy.validparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class Optimal {
    public static void main(String[] args) {
        // String s = "(()[{}])";
        String s = "]";
        // String s = "(])";
        Deque<Character> stack = new ArrayDeque<>();

        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == '(' ||
        //             s.charAt(i) == '[' ||
        //             s.charAt(i) == '{') {
        //         stack.push(s.charAt(i));
        //     } else {
        //         if (stack.isEmpty()) {  // "]"
        //             return;
        //         }
        //         if ((s.charAt(i) == ')' && stack.peek() == '(') ||
        //                 (s.charAt(i) == ']' && stack.peek() == '[') ||
        //                 (s.charAt(i) == '}' && stack.peek() == '{')) {
        //             stack.pop();
        //         } else {
        //             System.out.println(false); // "(])"
        //             return;
        //         }
        //     }
        // }

        // More easier approach
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                // If string has only closing bracket or
                // Closing bracket has no corresponding opening bracket
                if (stack.isEmpty()) { 
                    System.out.println(false); // Eg "]", "(])"
                    return;
                }
                char top = stack.pop();

                // If the current bracket is ')', the top of the stack should be '('
                if (ch == ')' && top != '(') {
                    System.out.println(false);
                    return;
                }
                if (ch == ']' && top != '[') {
                    System.out.println(false);
                    return;
                }
                if (ch == '}' && top != '{') {
                    System.out.println(false);
                    return;
                }
            }
        }

        System.out.println(stack);
        System.out.println(stack.isEmpty());
    }
}

// TC: O(N)
// SC: O(N)

// Problem Link: https://leetcode.com/problems/valid-parentheses/description/

// Approach:
// 1. Read the string character by character.
// 2. If it is an opening bracket '(', '[', or '{', push it into the stack.
// 3. If it is a closing bracket, check if it matches the opening bracket at the top of the stack.
// 4. If it does not match, the parentheses sequence is invalid.
// 5. If the stack is empty when a closing bracket is encountered, return false.
// 6. After processing the entire string, if the stack is empty, return true; otherwise, return false.