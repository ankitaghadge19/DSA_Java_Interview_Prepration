package string.medium.countsubstringswithkfrequencychars;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String str = "abacb";
        int n = str.length();
        int k = 2;

        // Total no of substrings where at least one char occurred k or more than k times
        int totalNoOfSubstrings = 0;

        // Generate all possible substrings starting with each index
        for (int s = 0; s < str.length(); s++) {

            // Store frequency of each char in current substring 
            HashMap<Character, Integer> freqCharMap = new HashMap<>();

            // Expand substring towards right from current starting index
            for (int e = s; e < str.length(); e++) {

                char currentChar = str.charAt(e);

                // Increase frequency of current char
                int freqCurrentChar = freqCharMap.getOrDefault(currentChar, 0) + 1;
                freqCharMap.put(currentChar, freqCurrentChar);

                // If current char reaches k frequency, current substring becomes valid
                if (freqCurrentChar == k) {

                    // All other substrings starting from the current starting index and ending at or after e will also be valid
                    totalNoOfSubstrings = totalNoOfSubstrings + (n - e);

                    // No need to check further substrings for the current starting index.
                    break;
                }
            }
        }
        System.out.println(totalNoOfSubstrings);
    }
}

// TC: O(^2)
// SC: O(N)

// Problem Link: https://leetcode.com/problems/count-substrings-with-k-frequency-characters-i/description/