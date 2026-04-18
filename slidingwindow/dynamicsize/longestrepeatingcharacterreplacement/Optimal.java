package slidingwindow.dynamicsize.longestrepeatingcharacterreplacement;

import java.util.Collections;
import java.util.HashMap;

public class Optimal {
    public static void main() {
                     // 012345678910
        String input = "XAAYBABZBBA";
        int k = 2;

        int s = 0;
        int maxLen = 0;
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> count = new HashMap<>();

        for (int e = 0; e < chars.length; e++) {
            count.put(chars[e], count.getOrDefault(chars[e], 0) + 1);
            int frequentChar = Collections.max(count.values());

            while ((e - s + 1) - frequentChar > k) {
                if (count.get(chars[s]) > 0) {
                    count.put(chars[s], count.get(chars[s]) - 1);
                }
                s++;
                frequentChar = Collections.max(count.values());
            }
            maxLen = Math.max(maxLen, (e -s + 1));
        }
        System.out.println(maxLen);
    }
}

// TC: O(N) -> start and end pointer moves 0 to n-1, start never resets or move backward
// SC: O(1)
// Problem Link: https://leetcode.com/problems/longest-repeating-character-replacement