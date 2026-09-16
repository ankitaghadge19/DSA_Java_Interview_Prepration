package string.medium.maxnumberofvowelsinsubstringofgivenlength;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class UsingMap {
    public static void main(String[] args) {
             // index 012345678
        String str = "abciiidef";
        int k = 3;

        // Store all vowels
        List<Character> vowels = new ArrayList<>();
        vowels.addAll(Arrays.asList('a', 'e', 'i', 'o', 'u'));

        int left = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>();

        // Store max vowels found in substring of length k so far
        int maxVowels = 0;

        for (int right = 0; right < str.length(); right++) {
            char currentChar = str.charAt(right);

            // Add vowels to the map
            if (vowels.contains(currentChar)) {
                freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            }

            // If current window size is k
            if ((right - left + 1) == k) {
                int currentVowelCount = 0;

                // Calculate total vowels in current window
                for (int count : freqMap.values()) {
                    currentVowelCount = currentVowelCount + count;
                }

                maxVowels = Math.max(maxVowels, currentVowelCount);

                // Remove the leftmost character before moving the window by one pointer ahead
                char leftChar = str.charAt(left);

                if (vowels.contains(leftChar)) {
                    // If current left character frequency is one then remove character directly from map
                    if (freqMap.get(leftChar) == 1) {
                        freqMap.remove(leftChar);
                    } else {
                        // If current left character frequency is > 1 then decrement its frequency
                        freqMap.put(leftChar, freqMap.getOrDefault(leftChar, 0) - 1);
                    }
                }

                // Move window towards right by one pointer
                left++;
            }
        }
        System.out.println(maxVowels);
    }
}

// TC: O(N)
// We process each char once, and for every window size k, we iterate over HashMap to calculate count
// So, Max HashMap can contain 5 vowels

// SC: O(1)
// Frequency Map can contains at most 5 vowels
