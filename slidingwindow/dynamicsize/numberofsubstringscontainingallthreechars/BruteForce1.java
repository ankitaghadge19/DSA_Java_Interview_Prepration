package slidingwindow.dynamicsize.numberofsubstringscontainingallthreechars;

import java.util.HashSet;
import java.util.Set;

public class BruteForce1 {
    public static void main(String[] args) {
        String str = "abcabc";

        // Input string will have only three types of chars (a, b, c)
        // Valid Substring = At least one occurrance of (a, b, c) 
        // Valid substring will have String only 3 unique chars

        int totalNoOfSubStrings = 0;

        // Generate all possible substrings starting with each index
        for (int s = 0; s < str.length(); s++) {

            // Store the unique characters present in the current window
            Set<Character> charsSet = new HashSet<>();

            // Expand substring towards right from current starting index
            for (int e = s; e < str.length(); e++) {

                // Add current char to the set
                charsSet.add(str.charAt(e));

                // If size of set is 3 it means current window contains all the three chars (a, b, c)
                if (charsSet.size() == 3) {
                    totalNoOfSubStrings++;
                }
            }
        }
        System.out.println(totalNoOfSubStrings);
    }
}

// TC: O(N^2)
// SC: O(N) Eg. "abc" -> Set will store N chars
