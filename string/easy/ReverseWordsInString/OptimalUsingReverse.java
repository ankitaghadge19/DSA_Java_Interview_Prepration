package string.easy.ReverseWordsInString;

public class OptimalUsingReverse {
    public static void main(String[] args) {
        String s = "  hello world  ";

        // Reverse entire string
        String reversedString = reverse(0, s.length() - 1, s);
        System.out.println(reversedString);

        char[] chars = reversedString.toCharArray();
        StringBuilder word = new StringBuilder();
        StringBuilder result = new StringBuilder();

        // Traverse reversed string and extract words
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                // Build current word
                word.append(chars[i]);
            }

            // Process the word when the word has characters and either we found a space or we've reached the last character.
            if (!word.isEmpty() && (chars[i] == ' ' || i==chars.length - 1)) {
                // Reverse each word
                String reverseWord = reverse(0, word.length() - 1, word.toString());

                if (!result.isEmpty()) {
                    result.append(" ");
                }
                result.append(reverseWord);
                word.setLength(0);
            }
        }

        System.out.println(result.toString());
    }

    private static String reverse(int s, int e, String word) {
        char[] chars = word.toCharArray();

        while (s < e) {
            char temp = chars[s];
            chars[s] = chars[e];
            chars[e] = temp;
            s++;
            e--;
        }
        return new String(chars);
    }
}

// Approach: 
// 1. Reverse the entire string
// 2. Traverse the reversed string and extract each word
// 3. Reverse each extracted word to restore its original order 
// 4. Append each reversed word to the result
// 5. Add spaces only between words to avoid leading/trailing spaces 
 
// TC: O(N) 
// SC: O(N) 

// Problem Link: