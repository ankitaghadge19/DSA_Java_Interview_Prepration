package string.medium.minremovetomakevalidparanthesis;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;

public class UsingStackListSort {
    public static void main(String[] args) {
        String s = ")((())(";
        // String s = "lee(t(c)o)de)";

        StringBuilder str = new StringBuilder(s);
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> invalidIndices = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')' &&
                    !stack.isEmpty() &&
                    s.charAt(stack.peek()) == '(') {

                // If current is ( and top stack is ) then we found valid pair (), remove ( from top of stack
                stack.pop();
            } else if (s.charAt(i) == '(' || s.charAt(i) == ')') { // Can we optimize this case?
                // Do not add alphabet index into invalid indices list
                invalidIndices.add(i);
            }
        }

        // Any opening brackets remaining in the stack do not have a matching closing bracket,
        // so their indices are also invalid and need to be removed.
        while (!stack.isEmpty()) {
            invalidIndices.add(stack.pop());
        }

        // Sort in descending order, 
        // Remove indices from right to left so that it will not give index out of bound exception
        // Eg. )((())( -> )((()) -> )(()) -> (())
        invalidIndices.sort(Comparator.reverseOrder());
        for (Integer index : invalidIndices) {
            str.deleteCharAt(index);
        }
        
        System.out.println(str.toString());
    }
}

// TC: O(N) + O(N log N) for sorting the invalid indices
// SC: O(N) for the stack and invalid indices list