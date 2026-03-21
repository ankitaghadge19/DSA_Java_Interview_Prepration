package slidingwindow.maxconsecutiveones;

public class Optimal {
    public static void main(String[] args) {
        //    0  1  2  3  4  5  6  7  8  9  10
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int zeros = 0;
        int n = nums.length;
        int s = 0;
        int maxLen = 0;

        for (int e = 0; e < n; e++) {
            if (nums[e] == 0) {
                zeros++;
            }

            while (zeros > k) {
                if (nums[s] == 0) {
                    zeros--;
                }
                s++;
            }
            maxLen = Math.max(maxLen, e - s + 1);
        }
        System.out.println("Final Count: " + maxLen);
    }
}

// Problem Link: https://leetcode.com/problems/max-consecutive-ones-iii
// TC: O(N)
// SC: O(1)

