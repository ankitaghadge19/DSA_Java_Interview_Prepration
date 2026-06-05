package arrays.medium.smallestsubarraywithSumk;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 7, 1, -10};
        int k = 15;
        int minLen = Integer.MAX_VALUE;

        // Generate all possible subarrays
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum += nums[end];

                // If current subarray sum equals k
                if (sum == k) {
                    int currentLength = end - start + 1;
                    minLen = Math.min(minLen, currentLength);
                }
            }
        }
        System.out.println(minLen);
    }
}

// SC: O(1)
// TC: O(N^2)