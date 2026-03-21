package slidingwindow.longestrepeatingcharacterreplacement;

import java.util.Collections;
import java.util.HashMap;

public class BruteForce {
    public static void main() {
                     // 012345678910
        String input = "XAAYBABZBBA";
        int k = 2;

        char[] chars = input.toCharArray();
        int maxLen = 0;
        HashMap<Character, Integer> count = new HashMap<>();

        for (int s = 0; s < input.length(); s++) {
            for (int e = 0; e < input.length(); e++) {
                count.put(chars[e], count.getOrDefault(chars[e], 0) + 1);
                int frequentChar = Collections.max(count.values());
                if ((e - s + 1) - frequentChar > k) {
                    count.clear();
                    break;
                }
                maxLen = Math.max(maxLen, e - s + 1);
            }
        }
        System.out.println(maxLen);
    }
}

// TC: O(N^2)
// SC: O(1) beacuse characters in the alphabet (26 for English uppercase), and its constant.
