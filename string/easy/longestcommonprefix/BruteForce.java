package string.easy.longestcommonprefix;

public class BruteForce {
    public static void main(String[] args) {
        String[] words = { "flower", "flow", "flight" };

        String firstWord = words[0];
        for (int len = firstWord.length()-1; len >=0; len--) {
            String prefix = firstWord.substring(0, len); // flower

            boolean commonPrefix = true;
            for (int i = 0; i < words.length; i++) {
                if (!words[i].startsWith(prefix)) {
                    commonPrefix = false;
                }
            }

            // (Early break) Eg. flower, flow, abc, ana
            if (commonPrefix) {
                System.out.println(prefix);
                break;
            }
        }
    }
}

// Approach:
// Take the first word
// Start with its complete length as possible prefix
// Check weather this prefix is present at the beginning of every other word
// If yes, return it
// If not, remove that last char of prefix and try again
// Continue until you find common prefix or the prefix is empty

// Prefix       Word        Starts_With_Prefix
// flower       flow               X
//              flight             X

// flowe        flow               X
//              flight             X

// flow         flow              yes
//              flight             X

// flo          flow              yes
//              flight             X

// fl           flow              yes
//              flight            yes

// Ans -> Common Prefix: fl

// TC: O(N * M^2)
// SC: O(M)
//
// N = number of words
// M = length of first word / maximum prefix length
//
// Number of prefixes                   → M
// All other wordes to be checked       → N
// Characters compared                  → M
//
// Example:
// flower -> flower, flowe, flow, flo, fl, f   // M prefixes
//
// For every prefix, compare with remaining words:
//
// flower -> flow
// flower -> flight
//
// flowe  -> flow
// flowe  -> flight
//
// flow   -> flow
// flow   -> flight
//
// ...
//
// Hence:
// M prefixes * N words * M character comparisons
// = O(N * M^2)
//
// SC = O(M)
// because the temporary prefix substring can contain at most M characters.
