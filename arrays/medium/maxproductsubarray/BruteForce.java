package arrays.medium.maxproductsubarray;

public class BruteForce {
    public static void main(String[] args) {
        //             0  1   2  3   4   5
        int[] nums = { 1, 2, -3, 0, -4, -5 };

        long max = Integer.MIN_VALUE; // nums = {-2}
        for (int i = 0; i < nums.length; i++) {
            long product = 1;
            for (int j = i; j < nums.length; j++) {
                product = product * nums[j];
                max = Math.max(max, product);
            }
        }
        System.out.println(max);
    }
}

// TC: O(N^2)
// SC: O(1)

// For each starting index, calculate product
// max = 1;

// index = 0
// 1               = 1
// 1 2             = 2
// 1 2 -3          = -6
// 1 2 -3 0        = 0
// 1 2 -3 0 -4     = 0
// 1 2 -3 0 -4 -5  = 0

// index = 1
// 2              = 2
// 2 -3           = -6
// 2 -3 0         = 0
// ... So on.

// Approach:
// Generate every possible subarray
// Outer loop indicate the starting index
// Internal loop defines the ending index
// Internal loop extends the array one element at a time
// Calculate the product
// Compare the current calculated product with max product found so far
// Return max product