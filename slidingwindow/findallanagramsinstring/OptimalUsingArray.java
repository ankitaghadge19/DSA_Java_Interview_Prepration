package slidingwindow.findallanagramsinstring;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptimalUsingArray {
    public static void main() {
        String str = "cbaebabacd";
        String p = "abc";

        if (str.length() < p.length()) {
            System.out.println(new ArrayList<>());
        }

        int[] pFreq = new int[26];
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        List<Integer> result = new ArrayList<>();
        int[] windowFreq = new int[26];
        int s = 0;
        char[] strArray = str.toCharArray();

        for (int e = 0; e < str.length(); e++) {
            windowFreq[strArray[e] - 'a']++;

            if ((e - s + 1) == p.length()) {
                if (Arrays.equals(windowFreq, pFreq)) {
                    result.add(s);
                }
                windowFreq[strArray[s] - 'a']--;
                s++;
            }
        }
        System.out.println(result);
    }
}

// The ASCII value of 'a' is 97.
// The ASCII value of 'b' is 98.
// 'b' - 'a' = 1, To map it to range of 0 - 25