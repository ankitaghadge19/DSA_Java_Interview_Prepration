package string.medium.maxnestingdepthofparentheses;

public class Optimal {
    public static void main(String[] args) {
        String s = "(1+(2*3)+((8)/4))+1";

        int count = 0;
        int maxDepth = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                maxDepth = Math.max(maxDepth, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        System.out.println(maxDepth);
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
