package array.medium.maxsumsubarray;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 2, 3, 5, -2, 7, -4 };

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        System.out.println(maxSum);
    }
}

// TC: O(N^2)
// SC: O(1)

// Approach:
// Generate every possible subarray
// Calculate its sum
// Keep track of maximum sum

// Logic:
// Outer loop decides where the subarray starts
// Inner loop extend the subarray one element at a time
// Variable sum is use to add elements as the subarray grows
// After adding each element, compare current sum with maxSum
// If current sum is larger then update maxSum with current sum