package arrays.medium.countsubarraysumequalsk;

import java.util.HashMap;

public class Optimal {
    public static void main() {
        int[] nums = {10, 5, 2, 7, 1, -10};
        int k = 15;

        // Key -> Prefix sum
        // Value -> Frequency of occurence of that prefix sum
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int currentPrefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currentPrefixSum = currentPrefixSum + nums[i];
            // Case 1: Subarray that starts with index 0 and ends at current index 1
            if (currentPrefixSum == k) {
                count++;
            }

            // Case 2: If (currentPrefixSum - k) has appeared before
            if (prefixSumMap.containsKey(currentPrefixSum - k)) {
                count = count + prefixSumMap.get(currentPrefixSum - k);
            }
            prefixSumMap.put(currentPrefixSum, prefixSumMap.getOrDefault(currentPrefixSum, 0) + 1);
        }
        System.out.println(count);
    }
}

// TC: O(N)
// SC: O(N)
// Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/description/

// Similar Problem: Samllest subarray with sum k

// Why storing frequency of prefix sum in map?
// -> Same prefix sum can occur multiple times, and each occurance can form different subarray whose sum = k

// PrefixSum = (PrefixSum - k) + k
// Index :   0    1    2    3

//                        sum=3
// Nums  :   5   -2    2    3
//                 \_______/
//                   sum=3

//         sum=5
// Nums  :   5   -2    2    3
//            \_______/
//              sum=5

// Prefix Sum 5 occurs twice (at indices 0 and 2).
//
// At index 3:
// currentPrefixSum = 8
//
// Required Prefix Sum:
// currentPrefixSum - k
// = 8 - 3
// = 5
//
// Prefix Sum 5 occurred twice before:
//
// Index 0  ---> Subarray index (1..3) = [-2, 2, 3] = 3
// Index 2  ---> Subarray index (3..3) = [3] = 3
//
// Therefore, two valid subarrays end at index 3.
//
// If we store only the latest occurrence:
//     5 -> 2
// we count only [3] and miss [-2, 2, 3].
//
// Hence, for counting subarrays:
//
// Key   -> Prefix Sum
// Value -> Frequency of occurrence