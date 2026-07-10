package arrays.medium.findrepeatingandmissingnumberfromarrayofonetonelements;

import java.util.Arrays;

public class BruteForce {
    public static void main() {
        // 0 1 2 3 4
        int[] nums = { 1, 1, 3, 5, 4 };
        int n = nums.length; // 5

        int[] result = new int[2];

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    count = count + 1;
                    if (count == 2) {
                        result[0] = i; // Repeating
                        break;
                    }
                }
            }

            if (count == 0) {
                result[1] = i; // Missing
            }

            // Both found, stop loop
            if (result[0] != 0 && result[1] != 0) {
                break;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}
// TC: O(N^2)
// SC: O(1)

//      0 1 2 3 4
// Eg. [1 1 3 5 4]

// For i = 1:
// We iterate through the array until we find the second occurrence of 1.
// nums[0] = 1 -> count = 1
// nums[1] = 1 -> count = 2, so we found the repeating number.
// We break the inner loop early.
// Number of iterations = 2

// For i = 2:
// We iterate through the entire array because 2 is not present.
// count remains 0, so 2 is the missing number.
// Number of iterations = 5

// Total iterations = 2 + 5 = 7

// Since both repeating and missing numbers are found,
// we break the outer loop early.

// This optimization is called early termination or early break
