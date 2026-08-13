package array.medium.longestsubarraysumequalskonlypositives;

public class BruteForce {
    public static void main() {
        int[] nums = { 10, 5, 2, 7, 1, 9 };
        int k = 15;

        int maxLen = 0;
        // Calculate sum for all possible subarrays
        for (int s = 0; s < nums.length; s++) {
            int sum = 0;
            for (int e = s; e < nums.length; e++) {
                sum = sum + nums[e];
                if (sum == k) {
                    maxLen = Math.max(maxLen, e - s + 1);
                }
            }
        }
        System.out.println(maxLen);
    }
}

// TC: O(N^2)
// SC: O(1)
