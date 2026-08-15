package string.minremovetomakevalidparanthesis;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingStackBooleanArray {
    public static void main(String[] args) {
        // String s = ")((())(";
        String s = "lee(t(c)o)de)";

        StringBuilder str = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();

        boolean[] remove = new boolean[s.length()]; // Initially all false
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {

                // If current bracket is ( and top stack is ) then we found valid pair of (), so pop ( from stack 
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    // If the stack is empty, there is no opening bracket available to match the current closing bracket, 
                    // so mark it as invalid.
                    remove[i] = true;
                }
            }
        }

        // Any opening brackets left in the stack do not have a matching closing bracket,
        // so mark their indices as invalid as well.
        while (!stack.isEmpty()) {
            int top = stack.pop();
            remove[top] = true;
        }

        // Traverse from right to left while deleting invalid characters
        for (int i = s.length()-1; i >= 0; i--) {
            if (remove[i]) {
                str.deleteCharAt(i);
            }
        }
        System.out.println(str.toString());
    }
}

// TC: O(N)
// SC: O(N)

// No sorting and no separate invalid-indices list is needed