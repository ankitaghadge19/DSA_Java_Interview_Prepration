package string.easy.findindexoffirstoccurrenceinstring;

import java.util.ArrayList;
import java.util.List;

public class BruteForce1 {
    public static void main(String[] args) {
             // index 012345678
        String str = "sadbutsad"; // 9
        String goal = "sad"; // 3

        // 9 - 3 = 6 (0 to 6)
        List<Integer> indexes = new ArrayList<>();

        // Check each possible substring of str having the same length as goal
        for (int i = 0; i <= str.length() - goal.length(); i++) {

            // Extract a substring of goal's length starting from index i
            String subString = str.substring(i, i + goal.length());

            // Check if extracted substring from str equals to goal
            if (subString.equals(goal)) {
                indexes.add(i);
            }
        }
        System.out.println(indexes);
    }
}

// TC: O(N * M)
// N is length of str and M is length of goal
// Eg. str = "abcda", goal = "a"
// Outer loop will run N times and each iteration will do M comparison
// For this example outer loop will run 5 time and each iteration will do 1 (length of goal) time comaprison

// SC: O(N)
// List stores all matching indexes → O(N) Eg. str = "aaa", goal = "a"
// Length of extracted string will be equal to length of goal string -> O(M)
// Overall -> O(N + M) = O(N)

// Problem Link: https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
