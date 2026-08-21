package string.medium.maxnestingdepthofparentheses;

import java.util.ArrayDeque;
import java.util.Deque;

public class UsingStack {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        Deque<Character> stack = new ArrayDeque<>();
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push('(');
                maxDepth = Math.max(maxDepth, stack.size());
            } else if (ch == ')') {
                stack.pop();
            }
        }
        System.out.println(maxDepth);
    }
}

// TC: O(N)
// SC: O(N)