package arrays.easy.movezeros.toend;

import java.util.Arrays;

public class OptimalSoln {
    public static void main() {
        int[] nums = { 1, 0, 2, 3, 0, 4, 0, 1 };

        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[l] == 0 && nums[r] != 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
            }
            if (nums[l] != 0) {
                l++;
            }
        }
        System.out.println(Arrays.toString(nums));

        // More Optimized Code
        // int l = 0;
        // for (int r = 0; i < nums.length; r++) {
        //     if (nums[r] != 0) {
        //         int temp = nums[r];
        //         nums[r] = nums[l];
        //         nums[l] = temp;
        //         l++;
        //     }
        // }
    }
}

// SC: O(1)
// TC: O(N)

// Problem Link: https://leetcode.com/problems/move-zeroes/description/

// Approach:
// [ 1  0 2 3 0 4 0 1]
//  l r

// [1  0  2 3 0 4 0 1]
//    l r

// [1 0 2 3 0 4 0 1]
//    l r

// swap()
// [1 2 0 3 0 4 0 1]
//    l r

// [1 2 0 3 0 4 0 1]
//      l r

// swap()
// [1 2 3 0 0 4 0 1]
//      l r

// [1 2 3 0 0 4 0 1]
//        l r

// [1 2 3 0 0 4 0 1]
//        l   r

// swap()
// [1 2 3 4 0 0 0 1]
//        l   r

// [1 2 3 4 0 0 0 1]
//          l   r

// [1 2 3 4 0 0 0 1]
//          l     r

// swap()
// [1 2 3 4 1 0 0 0]
//          l     r

// end
// [1 2 3 4 1 0 0 0]
//            l      r

// Conditions:
// Left pointer stops once it gets the 0, it is basically points to position where next non-zero element can be placed
// Right pointer scans the entire array and look for next non zero element
// When nums[l] == 0 and nums[r] != 0 then swap()