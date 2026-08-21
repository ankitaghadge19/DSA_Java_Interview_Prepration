package array.medium.RemoveOutermostParantheses;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        // String s = "(()())(())";

        int open = 0;
        int close = 0;

        int start = 0;
        List<Integer> indexToRemove = new ArrayList<>();
        for (int end = 0; end < s.length(); end++) {
            if (s.charAt(end) == '(') {
                open++;
            } else if (s.charAt(end) == ')') {
                close++;
            }

            if (open == close) {
                indexToRemove.add(start);
                indexToRemove.add(end);
                start = end + 1;
            }
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }
        System.out.println(result.toString());
    }
}

// (()())(()) -> "(()())" + "(())"