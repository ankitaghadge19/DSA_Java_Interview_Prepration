package arrays.medium.longestsubarraywithsumk;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        //   0   1  2  3  4   5
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        int len = 0;
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sum == k) {
                len = Math.max(len, i + 1);
            }
            if (prefixSumMap.containsKey(sum - k)) {
                len = Math.max(len, i - prefixSumMap.get(sum - k));
            }
            
            //Eg. { 5, -2, 2, 3 }, Prefix sum 5 occurs twice -> Use first occurance
            if (!prefixSumMap.containsKey(sum)) {
                prefixSumMap.put(sum, i);
            }
        }
        System.out.println(len);
    }
}

// Approach:
// Eg.
// k = 15
 
// 0   1   2   3   4   5
// |---------20--------|
// 2 + 3 + 2 + 5 + 7 + 1 = 20 = x, 
// |-5-|   |-----15----|
// |x-k|
// 20 - 15 = 5

//Eg. { 5, -2, 2, 3 }
// k = 3

//  Idx        Value        Prefix Sum        
//   0           5              5
//   1          -2              3
//   2           2              5
//   3           3              8
//
//   Prefix sum 5 occurs twice:
//   At index 3, Prefix Sum = 8
//   To find subarray with sum = 3
//   sum - k = 8 - 3 = 5
//   Now, there are two possible indices where prefix sum 5 ocurred
//   Use first occurance, at index 0 = [-2, 2, 3], length = 3 -> To get longest subarray of sum = 3
//   Use latest occurance, at index 2 = [3], length = 1 -> To get smallest subarray of sum = 3

// Solution Steps:
// 1. Store each index prefix sum as the key and its first occurrence index as the value in a HashMap.
// 2. At each index, check if (prefixSum - k) exists in the map or (has appeared before)
// 4. If it exists, the subarray between that previous index and the current index has sum = k
// 5. Calculate the length of that subarray and update the maximum length

// TC: O(N)
// SC: O(N)

// Problem Link: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1


