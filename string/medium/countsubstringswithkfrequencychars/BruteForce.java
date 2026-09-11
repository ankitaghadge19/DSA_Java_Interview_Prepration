package string.medium.countsubstringswithkfrequencychars;

import java.util.HashMap;

public class BruteForce {
    public static void main(String[] args) {
        String str = "abacb";
        int k = 2;

        // Total number of substrings where atleast one char occurred >= k frequency
        int totalNoOfSubstrings = 0;

        // Generate all possible substrings starting with each index
        for (int s = 0; s < str.length(); s++) {

            // Store frequency of each chars present in current substring
            HashMap<Character, Integer> charCountMap = new HashMap<>();

            // Expand substring towards right from current starting index 
            for (int e = s; e < str.length(); e++) {
                // Get currect char
                char currentChar = str.charAt(e);

                // Add current char into map and increase its frequency
                charCountMap.put(currentChar, charCountMap.getOrDefault(currentChar, 0) + 1);

                // Check if any char occurred k or more than k times
                for (Integer count : charCountMap.values()) {
                    if (count >= k) {
                        totalNoOfSubstrings++;
                        break;
                    }
                }
            }
        }
        System.out.println(totalNoOfSubstrings);
    }
}

// TC: O(N^3) -> Two for loops with map.values()
// SC: O(N) -> HasMap used to store frequecy of chars