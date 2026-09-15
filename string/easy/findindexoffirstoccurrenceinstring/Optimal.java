package string.easy.findindexoffirstoccurrenceinstring;

public class Optimal {
    public static void main(String[] args) {
               // index 012345678
        String input = "sadbutsad"; // 9
        String goal = "sad"; // 3

        int n = input.length();
        int m = goal.length();

        // If goal is longer than input then return false
        if (m > n) {
            System.out.println(-1);
        }

        // Check a window of goal's length for every possible starting position
        for (int s = 0; s <= n - m; s++) {
            boolean found = true;

            // Compare each goal character with the character in the current window in input
            for (int e = 0; e < goal.length(); e++) {

                // If any character does not match, goal does not match at this starting position
                if (input.charAt(s + e) != goal.charAt(e)) {
                    found = false;
                }
            }

            // If all characters matched, return starting index
            if (found) {
                System.out.println(s);
                return;
            }
        }

        // No match of goal was found anywhere in input
        System.out.println(-1);
    }
}

// TC: O(M * N)
// Eg. input = aaaaab, goal = aab
// number of positions × comparisons per position
// n × m

// SC: O(1)

// Problem Link:
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/