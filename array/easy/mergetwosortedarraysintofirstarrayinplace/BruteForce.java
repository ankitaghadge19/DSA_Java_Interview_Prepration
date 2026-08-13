package array.easy.mergetwosortedarraysintofirstarrayinplace;

import java.util.Arrays;

public class BruteForce {
    public static void main(String[] args) {
        //  0  1  2  3  4  5  6
        int[] arr1 = { 1, 2, 3, 4, 0, 0, 0 };
        //  0  1  2
        int[] arr2 = { 2, 5, 6 };
        int m = 4;
        int n = 3;

        // Temporary array to store merge result
        int[] result = new int[m + n];

        // i -> arr1 pointer
        // j -> arr2 pointer
        // k -> result pointer
        int k = 0;
        int i = 0;
        int j = 0;

        // Compare elements from both the arrays and insert samller one
        while (i < m && j < n) {
            if (arr1[i] < arr2[j]) {
                result[k] = arr1[i];
                i++;
                k++;
            } else {
                result[k] = arr2[j];
                j++;
                k++;
            }
        }

        // Copy remaining elements of arr1
        while (i < m) {
            result[k] = arr1[i];
            i++;
            k++;
        }

        // Copy remaining elements of arr2
        while (j < n) {
            result[k] = arr2[j];
            j++;
            k++;
        }
        System.out.println(Arrays.toString(result));
    }
}

// Using extra space
// TC: O(N)
// SC: O(N)

// Why copy the remaining elements?
//
// The first while loop stops as soon as either arr1 or arr2 is exhausted.
// The other array may still have elements that have not been copied into the result array yet, 
// so we copy all of them.

// Case 1: arr1 is exhausted
// arr1 = [1 2 3 _ _ _]
// arr2 = [4 5 6]
//
// After first while loop:
// result = [1 2 3 _ _ _]
//
// i = 3 (out of bounds)
// j = 0
//
// Elements 4, 5, 6 from arr2 are still not copied.
// Copy the remaining elements of arr2.
//
// Final result:
// [1 2 3 4 5 6]

// Case 2: arr2 is exhausted
// arr1 = [4 5 6 _ _ _]
// arr2 = [1 2 3]
//
// After first while loop:
// result = [1 2 3 _ _ _]
//
// i = 0
// j = 3 (out of bounds)
//
// Elements 4, 5, 6 from arr1 are still not copied.
// Copy the remaining elements of arr1.
//
// Final result:
// [1 2 3 4 5 6]