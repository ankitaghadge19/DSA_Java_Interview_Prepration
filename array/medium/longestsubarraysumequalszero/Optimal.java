package array.medium.longestsubarraysumequalszero;

import java.util.HashMap;
import java.util.Map;

public class Optimal {
    public static void main() {
        // PrefixSum   9   6  9   8  14  9
        int[] nums = { 9, -3, 3, -1, 6, -5 };
        // int[] nums = { -31, -48, -90, 54, 20, 95, 6, -86, 22 };

        // Stores: <PrefixSum, First Occurance Index>
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int sum = 0;
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            // Calculates prefix sum till current index
            sum = sum + nums[i];

            // If current prefix has been seen before, then elemnts between previous occurence and current index have sum = 0
            if (prefixSumMap.containsKey(sum)) {
                int len = i - prefixSumMap.get(sum);
                maxLen = Math.max(maxLen, len);
            }

            // If prefix sum becomes 0, then subarray from index 0 to current index has sum = 0
            // Eg. {-31, -48, -90, 54, 20, 95, 6, -86, 22}
            if (sum == 0) {
                maxLen = i + 1;
            }

            // In case of multiple occurnaces of same prefix sum, keep 1st occurance index in map in order to get longest subarray
            prefixSumMap.putIfAbsent(sum, i);
        }
        System.out.println(maxLen);
    }
}

// Approach:
//                    Map
// Idx    Eg.   PrefixSum -> Index
//  0      9        9  -> 0
//  1     -3        6  -> 1
//  2      3        9  -> 2 -> Don't put in map
//  3     -1        8  -> 3
//  4      6        14 -> 4
//  5     -5        9  -> 5 -> Don't put in map

// If same prefix sum appreas at two different indices, elements between those two indices has sum = 0
// Here prefix sum 9 appears at:
// Index = 0
// Index = 2

// Subarray between them:
// i.e., elements between index 1 to index 2 has sum = 0 [-3 3]

// Similarly, prefix sum appears at index 5.
// So, subarray from index 1 to index 5 has sum = 0 [-3 3 -1 6 -5]

// To get longest subarray, always store fisrt occurance of prefix sum

// At index 0, the prefix sum is 9. After that, some elements increase the sum,
// while other elements decrease it by the same amount. As a result, at index 5,
// we again get the same prefix sum of 9.

// Prefix Sum = Sum of all elemnets from index 0 till current index






