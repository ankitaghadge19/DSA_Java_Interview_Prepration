package string.easy.reversewordsinsstring;

public class UsingSplit {
    public static void main(String[] args) {

        String s = "a good   example";

        // Split the string using one or more spaces.
        // "\\s+" means one or more whitespace characters.
        String[] words = s.trim().split("\\s+");

        StringBuilder reversedString = new StringBuilder();

        // Traverse the words array from right to left.
        for (int i = words.length - 1; i >= 0; i--) {

            reversedString.append(words[i]);

            // Add a space only between words.
            if (i != 0) {
                reversedString.append(" ");
            }
        }

        System.out.println(reversedString);
    }
}

// Approach:
// Remove leading and trailing spaces using trim().
// Split the string using \\s+.
// \\s → whitespace
// + → one or more occurrences
// Traverse the resulting words array from the last word to the first.
// Append each word to StringBuilder

// TC: O(N) (Splitting string in words)
// SC: O(N) (Stroring extracted words in array) For Eg. "apple"
