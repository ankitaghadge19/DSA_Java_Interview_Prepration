package string.medium.minremovetomakevalidparanthesis;

public class Optimal {
    public static void main(String[] args) {
        String s = ")((())(";
        // String s = "lee(t(c)o)de)";

        boolean[] remove = new boolean[s.length()];
        int cnt = 0;

        StringBuilder str = new StringBuilder(s);
        // Traverse Left to Right and find invalid ')'
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                if (cnt == 0) {
                    // If current char is ')' and cnt == 0 means,
                    // this closing bracket does not have a matching opening bracket to its left,
                    // so it is invalid, need to remove it
                    remove[i] = true;
                } else {
                    cnt--;
                }
            }
        }

        // Traverse Right to Left and find invalid '('
        cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                cnt++;
            } else if (s.charAt(i) == '(') {
                if (cnt == 0) {
                    // If current char is '(' and cnt == 0,
                    // this opening bracket does not have a matching closing bracket to its right,
                    // so it is invalid.
                    remove[i] = true;
                } else {
                    cnt--;
                }
            }
        }

        // Remove invalid indices value from R -> L to avoid index out of bound
        // exception
        for (int i = s.length() - 1; i >= 0; i--) {
            if (remove[i]) {
                str.deleteCharAt(i);
            }
        }
        System.out.println(str.toString());
    }
}

// Problem Link:
// https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/description/
// TC: O(N)
// SC: O(N) Eg. "((("

// Approach:
// L → R
// '(' → cnt++
// ')' → if cnt > 0, cnt--; otherwise invalid

// R → L
// ')' → cnt++
// '(' → if cnt > 0, cnt--; otherwise invalid

// L → R detects extra ')'
// R → L detects extra '('

