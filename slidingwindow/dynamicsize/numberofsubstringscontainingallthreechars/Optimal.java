package slidingwindow.dynamicsize.numberofsubstringscontainingallthreechars;

public class Optimal {
    public static void main() {
        // 012345
        String str = "aacbbcac";

        int count = 0;
        int lastA = -1;
        int lastB = -1;
        int lastC = -1;

        for (int e = 0; e < str.length(); e++) {
            char ch = str.charAt(e);
            if (ch == 'a') {
                lastA = e;
            }
            if (ch == 'b') {
                lastB = e;
            }
            if (ch == 'c') {
                lastC = e;
            }

            if (lastA != -1 && lastB != -1 && lastC != -1) {
                // valid window found
                // Calculate no of valid substrings ending at 'e'
                // look back and find very last time you saw 'a', 'b', 'c'
                // find leftmost possible starting position that still include all three chars
                // which will be min(lastA, lastB, lastC)
                count += Math.min(lastA, Math.min(lastC, lastB)) + 1;

            }

        }
        System.out.println(count);
    }
}

// TC: O(N)
// SC: O(1)
// Problem Link: https://leetcode.com/problems/number-of-substrings-containing-all-three-characters

// Approach:
// Don't shrink the window after you find valid window
// Eg.
// 0 1 2 3 4 5 6 7
// a a c b b c a c

// a
// a c
// a c b            -> 1 (acb)
// a c b b          -> 1 (acbb)
// a c b b c        -> 1 (acbbc)
// a c b b c a      -> 4 (acbbca, cbbca, bbca, bca)
// a c b b c a c    -> 4 (acbbca, cbbcac, bbcac, bcac)

// At every index e, look back to find the closest position that completes the set of all three characters 
// Every index from the start of the string up to that position is a valid starting point