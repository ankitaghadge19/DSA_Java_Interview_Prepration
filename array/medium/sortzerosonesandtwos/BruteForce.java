package array.medium.sortzerosonesandtwos;
import java.util.Arrays;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 1, 0, 2, 1, 0 };

        int zeros = 0;
        int ones = 0;
        int twos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else if (nums[i] == 1) {
                ones++;
            } else if (nums[i] == 2) {
                twos++;
            }
        }

        int i = 0;
        while (zeros > 0) {
            nums[i] = 0;
            zeros--;
            i++;
        }

        while (ones > 0) {
            nums[i] = 1;
            ones--;
            i++;
        }

        while (twos > 0) {
            nums[i] = 2;
            twos--;
            i++;
        }
        System.out.println(Arrays.toString(nums));
    }
}

// Problem Link: https://leetcode.com/problems/sort-colors/description/

// TC: O(N)
// SC: O(1)

// Approach:
// Count the number of 0s, 1s, and 2s
// Traverse the array again and overwrite it with all 0s, then 1s, then 2s
// This sorts the array without using extra space