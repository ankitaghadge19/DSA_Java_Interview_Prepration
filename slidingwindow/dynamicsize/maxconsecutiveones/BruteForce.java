package slidingwindow.dynamicsize.maxconsecutiveones;

public class BruteForce {
    public static void main() {
        //    0  1  2  3  4  5  6  7  8  9  10
        int[] nums = { 1, 1, 1, 0, 0, 1, 1, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int zeros = 0;
        int maxLen = 0;

        for (int s = 0; s < nums.length; s++) {
            for (int e = s; e < nums.length; e++) {
                if (nums[e] == 0) {
                    zeros++;
                }
                if (zeros <= k) {
                    maxLen = Math.max(maxLen, e - s + 1);
                } else {
                    break;
                }
            }
        }
        System.out.println(maxLen);
    }
}

// TC: O(N^2)
// SC: O(1)