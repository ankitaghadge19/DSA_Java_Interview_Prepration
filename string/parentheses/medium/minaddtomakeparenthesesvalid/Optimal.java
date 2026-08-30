package string.parentheses.medium.minaddtomakeparenthesesvalid;

public class Optimal {
    public static void main(String[] args) {
        String s = "())))(((";
        // )))(((
        // (())(

        // If "(" -> balance++;
        // If ")" -> balance--;

        int balance = 0;
        int unMatchedClose = 0;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                balance++;
            } else { // ch == ')'
                if (balance > 0) {
                    balance--;
                } else {
                    unMatchedClose++; // no "(" available to match ")"
                }
            }
        }

        // Unmatched open brackets + unmatched close brackets
        System.out.println(balance + unMatchedClose);
    }
}

// TC: O(N)
// SC: O(1)
// Problem Link: https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/description/

// Note: For every ")", first check if its respective open bracket present. If yes, match it. If not, this ")" is extra and requires us to add "("

// Approach:
// Maintain two counters:
// balance -> count of unmatched '('
// unmatchedClose -> count of unmatched ')'
// If '(' -> balance++
// If ')' and balance > 0 -> balance--
//                because it matches an '('
// -> Current close bracket has its respective open bracket in string
// If ')' and balance == 0 -> unmatchedClose++
//                because there is no '(' to match it
// -> Current close bracket does not have its respective open bracket in string