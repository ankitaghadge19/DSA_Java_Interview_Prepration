package arrays.medium.countsubarraysumequalsk;

import java.util.HashMap;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;

        int count = 0;
        for (int start = 0; start < nums.length; start++) {
            int sum = 0;
            for (int end = start; end < nums.length; end++) {
                sum = sum + nums[end];
                if (sum == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

// TC: O(1)
// SC: O(N^2)
