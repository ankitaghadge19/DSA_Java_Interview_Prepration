package string.easy.findfirstuniquecharinstring;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        String s = "leetcode";

        // count frequency of each character
        HashMap<Character, Integer> count = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        // find first non repeating character
        for (Character ch : s.toCharArray()) {
            if (count.get(ch) == 1) {
                System.out.println(ch);
                break;
            }
        }
    }
}

// TC: O(N)
// SC: O(N)

// Problem Link: https://leetcode.com/problems/first-unique-character-in-a-string/
