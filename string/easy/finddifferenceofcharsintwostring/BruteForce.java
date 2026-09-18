package string.easy.finddifferenceofcharsintwostring;

import java.util.HashMap;

public class BruteForce {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcd";

        HashMap<Character, Integer> freqOfCharsMap = new HashMap<>();

        // Store each char frequency of string s into map
        for (char ch : s.toCharArray()) {
            freqOfCharsMap.put(ch, freqOfCharsMap.getOrDefault(ch, 0) + 1);
        }

        // Check if string t also has same chars with same frequency
        for (char ch : t.toCharArray()) {
            // If t has char which is not present in s
            if (!freqOfCharsMap.containsKey(ch)) {
                System.out.println(ch);
                break;
            }

            // If both the strings has same char but frequency is different
            // Decrement frequency of char in map eg. (s = a, t = aa)
            freqOfCharsMap.put(ch, freqOfCharsMap.get(ch) - 1);

            // After decrementing frequency if it becomes 0 then remove that char from map
            if (freqOfCharsMap.get(ch) == 0) {
                freqOfCharsMap.remove(ch);
            }
        }
    }
}

// TC: O(N), length of of largest string
// SC: O(K), where k is number of distinct characters
