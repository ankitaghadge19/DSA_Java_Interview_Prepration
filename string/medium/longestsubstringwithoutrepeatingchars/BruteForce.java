package string.medium.longestsubstringwithoutrepeatingchars;

import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public static void main(String[] args) {
        // index 01234567
        String str = "abcabcbb";

        // Track maximum length substring with unique characters found so far
        int maxLen = 0;

        // Generate all possible substrings starting from each index
        for (int i = 0; i < str.length(); i++) {

            // Track unique characters in the current window
            Set<Character> count = new HashSet<>();

            // Generate all possible substrings starting with particular index
            for (int j = i; j < str.length(); j++) {

                // Duplicate character found, so stop this window
                if (count.contains(str.charAt(j))) {
                    break;
                }

                // Add current character to the set
                count.add(str.charAt(j));

                // Update maximum length
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        System.out.println(maxLen);
    }
}

// TC: O(N^2)
// SC: O(N) Eg. "abcd" -> Set will contain all the chars 
