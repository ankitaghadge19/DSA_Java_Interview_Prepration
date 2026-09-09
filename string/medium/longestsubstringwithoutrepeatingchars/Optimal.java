package string.medium.longestsubstringwithoutrepeatingchars;

import java.util.HashSet;

public class Optimal {
    public static void main(String[] args) {
        // Index      012345678
        String str = "abcabcbb";
        // bbbb
        // acbcadb

        // Start pointer of window
        int s = 0;

        // Stores max length of substring without repeating chars
        int maxLen = 0;

        // Stores chars present in current window
        HashSet<Character> charSet = new HashSet<>();

        // End pointer of sliding window
        for (int e = 0; e < str.length(); e++) {
            char ch = str.charAt(e);

            // If current char is alredy present then shrink wingdow from left
            if (charSet.contains(ch)) {
                while (charSet.contains(ch)) {
                    charSet.remove(str.charAt(s));
                    s++;
                }
            }

            // Add current char to the window
            charSet.add(str.charAt(e));

            // Update max length
            maxLen = Math.max(maxLen, e - s + 1);
        }
        System.out.println(maxLen);
    }
}

// TC: O(N)
// SC: O(N) (HashSet can store up to N chars)

// Approach:
// Sliding Window + HashSet
// Use set to store chars in current window
// Move end pointer forward
// If the current char is already present in the Set, it means the current char is a duplicate
// Move S forward until the current window does not contain the current char
// Add current char to set
// Upddate max length

