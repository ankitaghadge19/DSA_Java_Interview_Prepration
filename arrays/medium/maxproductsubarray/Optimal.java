package arrays.medium.maxproductsubarray;

public class Optimal {
    public static void main(String[] args) {
        //             0  1   2  3   4   5
        int[] nums = { 1, 2, -3, 0, -4, -5 };

        // Running product while traversing left to right
        int leftProduct = 1;

        // Running product while traversing right to left
        int rightProduct = 1;

        int n = nums.length; // 6

        // Stores maximum product found so far
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            // If the product becomes 0, reset it to 1., split array into two subarrays
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            // Prefix product (Left -> Right)
            leftProduct = leftProduct * nums[i];

            // Suffix product (Right -> Left)
            rightProduct = rightProduct * nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(leftProduct, rightProduct));
        }
        System.out.println(maxProduct);
    }
}

// Problem Link: https://leetcode.com/problems/maximum-product-subarray/description/

// TC: O(N)
// SC: O(1)
