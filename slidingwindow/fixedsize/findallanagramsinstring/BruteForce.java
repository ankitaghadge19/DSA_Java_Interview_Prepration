package slidingwindow.fixedsize.findallanagramsinstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteForce {
    public static void main() {
                   // 0123456789
        String str = "cbaebabacd";
        String p = "abc";

        int[] pFreq = new int[26];
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }
        
        int[] windowFreq = new int[26];
        char[] strArray = str.toCharArray();
        List<Integer> result = new ArrayList<>();

        for (int s = 0; s <= str.length() - p.length(); s++) {
            for (int e = s; e < s + p.length(); e++) {
                windowFreq[strArray[e] - 'a']++;
            }
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(s);
            }
            Arrays.fill(windowFreq, 0);
        }
        System.out.println(result);
    }
}

// TC: O(N^2)
// SC: O(1) -> 26 is constant space