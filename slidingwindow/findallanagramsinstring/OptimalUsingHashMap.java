package slidingwindow.findallanagramsinstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class OptimalUsingHashMap {
    public static void main() {
        String str = "cbaebabacd";
        String p = "abc";

        HashMap<Character, Integer> anagram = new HashMap<>();
        for (char ch : p.toCharArray()) {
            anagram.put(ch, anagram.getOrDefault(ch, 0) + 1);
        }

        HashMap<Character, Integer> count = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        int s = 0;

        char[] input = str.toCharArray();
        // 0 1 2 3 4 5 6 7 8 9
        // c b a e b a b a c d

        for (int e = 0; e < input.length; e++) {
            // Add the current character to the window
            count.put(input[e], count.getOrDefault(input[e], 0) + 1);

            // Check if the window size matches p.length()
            if ((e - s + 1) == p.length()) {
                if (anagram.equals(count)) {
                    result.add(s);
                }

                // Slide the window: Remove the character at index 's'
                int cnt = count.get(input[s]);
                if (cnt > 1) {
                    count.put(input[s], cnt - 1);
                } else {
                    count.remove(input[s]);
                }
                // Move the start pointer forward
                s++;
            }
        }
        System.out.println(result);
    }
}

// TC: O(1)
// SC: O(1)
// Problem Link: https://leetcode.com/problems/find-all-anagrams-in-a-string