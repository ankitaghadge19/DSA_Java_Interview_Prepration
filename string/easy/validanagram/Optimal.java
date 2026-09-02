package string.easy.validanagram;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String word1 = "cat";
        String word2 = "act";

        // "cat", "ca"
        if (word1.length() != word2.length()) {
            System.out.println(false);
        }

        // count no of each chars from word1
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (Character ch : word1.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // check word2 has same frequency of each chars as like word1
        for (Character ch : word2.toCharArray()) {
            if (!freqMap.containsKey(ch) ||
                    freqMap.get(ch) == 0) {
                System.out.println(false);
                break;
            }
            freqMap.put(ch, freqMap.get(ch) - 1);
        }
        System.out.println(true);
    }
}

// Two words are anagrams if they conatins exactly same chars with exactly same frequency but order can be different.

// Approach:
// Find the frequensy of each char of first string
// Store how many times each character appears
// Traverse second string
// Second string should also contain the same characters with the same frequency as the first string
// If not matched, then return false

// TC: O(N)
// SC: O(N)

// Problem Link: https://leetcode.com/problems/valid-anagram/description/
