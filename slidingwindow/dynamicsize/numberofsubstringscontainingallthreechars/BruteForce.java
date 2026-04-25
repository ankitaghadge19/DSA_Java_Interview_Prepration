package slidingwindow.dynamicsize.numberofsubstringscontainingallthreechars;

import java.util.Arrays;

public class BruteForce {
    public static void main() {
        String str = "bbacba";

        int[] count = new int[26];
        int result = 0;

        for (int s = 0; s < str.length(); s++) {
            for (int e = s; e < str.length(); e++) {
                count[str.charAt(e) - 'a'] = 1;
                if (count[0] + count[1] + count[2] == 3) {
                    // result++;
                    // Optimization: (Every substring beyond valid substring will also be valid)
                    result = result + (str.length() - e);
                    break;
                }
            }
            Arrays.fill(count, 0);
        }
        System.out.println(result);
    }
}

// TC: O(N^2)
// SC: O(1)