package arrays.easy.findmissingnumber;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 8, 2, 4, 5, 3, 7, 1 };
        int n = nums.length + 1;
        // sum of 1 to n elements
        int expectedSum = (n * (n + 1)) / 2;

        // sum of all array elements
        int actualSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum = actualSum + nums[i];
        }

        int missing = expectedSum - actualSum;
        System.out.println(missing);
    }
}

// TC: O(N)
// SC: O(N)
// Problem Link: https://leetcode.com/problems/missing-number/description/

// Approach: 
// Missing Number = (Sum of 1 to N elements) - (Sum all array elements)