package array.medium.RemoveOutermostParantheses;

public class Optimal {
    public static void main(String[] args) {
        String s = "(()())(())";

        int balance = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char currectChar = s.charAt(i);
            if (currectChar == '(') {
                balance++;

                // Skip first "(" of each group
                if (balance > 1) {
                    result.append(currectChar);
                }
            } else {
                // If char = ")"
                balance--;

                // Skip last ")" of each group
                if (balance != 0) {
                    result.append(currectChar);
                }
            }
        }
        System.out.println(result.toString());
    }
}

// "(()())(())" -> "(()())" + "(())"
// Result =          ()()   +   ()

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/remove-outermost-parentheses/description/