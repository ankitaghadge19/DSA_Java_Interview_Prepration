package arrays.medium.smallestsubarraywithSumk;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;

        // Map of prefix sum -> index
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int currentPrefixSum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum = currentPrefixSum + nums[i];

            // Subarray from index 0 to i
            if (currentPrefixSum == k) {
                minLen = Math.min(minLen, i + 1);
            }
            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                minLen = Math.min(minLen, i - prefixSumMap.get(currentPrefixSum - k));
            }

            // If there are duplicate prefix sum, then to get smallest subarray, store latest occurance of prefix sum 
            prefixSumMap.put(currentPrefixSum, i);
        }
        System.out.println(minLen);
    }
}

// TC: O(N)
// SC: O(N)