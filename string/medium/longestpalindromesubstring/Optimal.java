package string.medium.longestpalindromesubstring;

public class Optimal {
    public static void main(String[] args) {
                 // 012345
        String s = "babaa";
        // bab -> Odd
        // baab -> Even

        int start = 0;
        int end = 0;

        // Consider every index as possible center of palindrome
        for (int i = 0; i < s.length(); i++) {

            // Check for odd-legth palindrome with i as the center
            int odd = isPalindrome(s, i, i);

            // Check for even-length palindrome with i and i+1 as center
            int even = isPalindrome(s, i, i + 1);

            // Get the length of longest palindrome
            int maxLen = Math.max(odd, even);

            // If the current palindrome is longer, update its start and end indexes
            if (maxLen > (end - start + 1)) {
                start = i - ((maxLen - 1) / 2);
                end = i + (maxLen / 2);
            }
        }
        System.out.println(s.substring(start, end + 1));
    }

    private static int isPalindrome(String s, int l, int r) {
        int maxLen = 0;

        // Expand left and right while characters are equal
        while (l >= 0 && r < s.length()) {
            // Stop expanding if characters are different
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            l--;
            r++;
        }
        return maxLen;
    }
}

// Approach:
// Consider every index as center of palindrome
// Possible Palindrome:- Even: aba, odd: abba
// Center i i
// Considering each char as center we check weather we can form longest odd
// palindrome or even palindrome string
// Expand left and right from the center as long as the characters are equal
// Keep track of longest palindrome found so far

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/longest-palindromic-substring/description/
