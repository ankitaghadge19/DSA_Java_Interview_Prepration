```java
package string.easy.isomorphicstring;

import java.util.HashMap;

public class Optimal {

    public static void main(String[] args) {

        String s = "egg";
        String t = "add";

        // Both strings must have the same length.
        // Example: e -> a, g -> d
        if (s.length() != t.length()) {
            System.out.println(false);
            return;
        }

        // Store the mapping from characters of s to characters of t.
        HashMap<Character, Character> map = new HashMap<>();

        // Traverse both strings at the same time.
        for (int i = 0; i < s.length(); i++) {

            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // If sChar is already mapped,
            // tChar must be the same mapped value.
            if (map.containsKey(sChar)) {

                char value = map.get(sChar);

                // Same sChar cannot map to a different tChar.
                if (tChar != value) {
                    System.out.println(false);
                    return;
                }

            // If tChar is already mapped to another sChar,
            // two different characters from s would map to the same character in t.
            // Example: "ac", "dd"
            // a -> d
            // c -> d  ❌
            } else if (map.containsValue(tChar)) {

                System.out.println(false);
                return;

            } else {

                // Create a new mapping: sChar -> tChar.
                map.put(sChar, tChar);
            }
        }

        System.out.println(true);
    }
}

// Isomorphic Strings:
// Two strings are called isomorphic when characters in one string can be replaced to get the other string
// Two strings are isomorphic if their characters follow the same pattern, 
// where each character maps to exactly one character in the other string, and vice versa.

// Rules:
// 1. One character from s can map to only one character in t
// 2. One character from t can map to only one character in s

// TC: O(N) for a fixed character set
// SC: O(N)

// Problem Link:

