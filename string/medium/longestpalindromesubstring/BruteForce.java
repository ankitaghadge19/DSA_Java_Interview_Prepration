package string.medium.longestpalindromesubstring;

public class BruteForce {
    public static void main(String[] args) {
        String s = "babaa";

        // Store start and end index of longest palindrome substring
        int start = 0;
        int end = 0;

        // Generate all possible substrings starting with each index
        for (int l = 0; l < s.length(); l++) {

            // Generate all possible substrings starting with particular index
            for (int r = l; r < s.length(); r++) {

                // Check if current substring is palindrome
                boolean isPalindrome = isPlaindrome(l, r, s);

                // If current substring is palindrome and its length is graeter than length of
                // palindrome substring found so far
                if (isPalindrome &&
                        ((r - l + 1) > (end - start + 1))) {

                    // Update start and end index
                    start = l;
                    end = r;
                }
            }
        }

        // Extract longest palindrome substring
        System.out.println(s.substring(start, end + 1));
    }

    // Check if current substring (l to r) is palindrome
    private static boolean isPlaindrome(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

// TC: O(N^3)
// SC: O(1)