package string.medium.longestpalindromesubstring;

public class UsingSubstringMethod {
    public static void main(String[] args) {
                 // 012345
        String s = "babaa";
        // bab -> Odd
        // baab -> Even

        String maxPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String odd = isOddPalindrome(s, i, i);
            String even = isOddPalindrome(s, i, i + 1);

            if (odd.length() > maxPalindrome.length()) {
                maxPalindrome = odd;
            }
            if (even.length() > maxPalindrome.length()) {
                maxPalindrome = even;
            }
        }
        System.out.println(maxPalindrome);
    }

    private static String isOddPalindrome(String s, int l, int r) {
        int maxLen = 0;
        String palindrome = "";
        while (l >= 0 && r < s.length()) {
            if (s.charAt(l) != s.charAt(r)) {
                break;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            palindrome = s.substring(l, r + 1);
            l--;
            r++;
        }
        return palindrome;
    }
}

// TC: O(N^2)
// SC: O(N)
