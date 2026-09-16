package string.medium.maxnumberofvowelsinsubstringofgivenlength;

public class UsingCounterVariable {
    public static void main(String[] args) {
             // index 012345678
        String str = "abciiidef";
        int k = 3;

        // Number of vowels in the current window
        int vowelCount = 0;

        // Maximum number of vowels found in any window of size k
        int maxVowels = 0;

        int left = 0;

        // Find the maximum number of vowels in any window of size k
        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            // If current character is vowel then increase the vowel count for current window
            if (isVowel(currentChar)) {
                vowelCount++;
            }

            // If current window size is k
            if ((right - left + 1) == k) {

                // Check if current window has max no of vowels
                maxVowels = Math.max(maxVowels, vowelCount);

                // If leftmost character is vowel then decrement vowel count before moving window ahead by one pointer
                char leftChar = str.charAt(left);
                if (isVowel(leftChar)) {
                    vowelCount--;
                }

                // Slide the window one position to the right
                left++;
            }
        }
        System.out.println(maxVowels);
    }

    // Returns true if the given character is a vowel
    private static boolean isVowel(Character ch) {
        if (ch == 'a' ||
                ch == 'e' ||
                ch == 'i' ||
                ch == 'o' ||
                ch == 'u') {
            return true;
        }
        return false;
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
