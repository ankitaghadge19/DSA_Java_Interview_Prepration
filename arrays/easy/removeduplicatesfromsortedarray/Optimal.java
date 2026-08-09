package arrays.easy.removeduplicatesfromsortedarray;

import java.util.Arrays;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 2, 2, 3, 3 };

        int l = 0;
        for (int r = 1; r < nums.length; r++) {
            if (nums[r] != nums[l]) {
                l++;
                nums[l] = nums[r];
            }
        }

        for (int i = l + 1; i < nums.length; i++) {
            nums[i] = 0;
        }

        // Array contains all unique elements
        System.out.println(Arrays.toString(nums));

        // Total unique elements
        System.out.println(l + 1);
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: 

// Approach:
// Since the array is sorted all duplicate elements are adjacent
// Use two pointers:
//  - Left Pointer(L): points to last unique element found
//  - Right Pointer(R): Scans the array from left to right
// If nums[r] != nums[l], a new element is found
//  - Increment l
//  - Copy nums[r] to nums[l]
// After traversing entire array, first (l + 1) elements of the array conatins all unique elements.

// Why r starts from 1 and not 0?
// When it starts with 0, loop compare 1st element with itself, which is useless operation.