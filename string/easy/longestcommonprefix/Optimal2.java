package string.easy.longestcommonprefix;

public class Optimal2 {
    public static void main(String[] args) {
        String[] words = { "flower", "flow", "flight" };

        String commonPrefix = words[0]; // "flower"

        for (int i = 1; i < words.length; i++) {
            int j = 0;
            while (j < commonPrefix.length() &&
                    j < words[i].length() &&
                    commonPrefix.charAt(j) == words[i].charAt(j)) {
                j++;
            }
            commonPrefix = commonPrefix.substring(0, j);

            // (Early break) Eg. flower, flow, abc, ana
            if (commonPrefix.isEmpty()) {
                break;
            }
        }
        System.out.println(commonPrefix);
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/longest-common-prefix/description/

// Approach:
// Take the first word as initial prefix
// Compare this prefix with each remaining words one by one
// Compare chars from left to right, until chars dont match or one of the string ends
// Matched part becomes the new prefix
// Repeat the same process for all words
// If prefix becomes empty stop early because there cant be common prefix