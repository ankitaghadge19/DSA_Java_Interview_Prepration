package string.easy.ReverseWordsInString;

import java.util.ArrayList;
import java.util.List;

public class UsingCharTraversal {
    public static void main(String[] args) {

        String s = " a good example";

        // Store all extracted words
        List<String> words = new ArrayList<>();

        // Extract current word character by character
        StringBuilder word = new StringBuilder();

        // Traverse string character by character
        for (char ch : s.toCharArray()) {

            if (ch != ' ') {
                // Add character to the current word
                word.append(ch);

            } else if (!word.isEmpty()) {
                // Space found -> current word is complete, so store it
                // Avoids adding empty strings caused by leading/multiple spaces
                words.add(word.toString());

                // Reset StringBuilder for the next word
                word.setLength(0);
            }
        }

        // Add the last word because there may be no space after it
        if (!word.isEmpty()) {
            words.add(word.toString());
        }

        // Build the final string in reverse word order
        StringBuilder reversedString = new StringBuilder();

        // Traverse the list from the last word to the first
        for (int i = words.size() - 1; i >= 0; i--) {

            if (i != 0) {
                // Append a space between words, avoiding a trailing space
                reversedString.append(words.get(i)).append(" ");
            } else {
                // Append the first word without a trailing space
                reversedString.append(words.get(i));
            }
        }

        System.out.println(reversedString);
    }
}

// Approach:
// Traverse string char by char and extract words
// Store extrcated words in list
// Tracerse the list backward, avoid trailing spaces

// TC: O(N)
// SC: O(N)