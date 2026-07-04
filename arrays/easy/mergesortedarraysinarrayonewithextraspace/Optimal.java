package arrays.easy.mergesortedarraysinarrayonewithextraspace;

import java.util.Arrays;

public class Optimal {
    public static void main() {
                   //  0  1  2  3  4  5
        int[] arr1 = { 1, 2, 3, 0, 0, 0 };

                   //  0  1  2
        int[] arr2 = { 2, 5, 6 };

        int m = 3;
        int n = 3;
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (arr1[i] > arr2[j]) {
                arr1[k] = arr1[i];
                i--;
                k--;
            } else {
                arr1[k] = arr2[j];
                j--;
                k--;
            }
        }
        while (j >= 0) {
            arr1[k] = arr2[j];
            j--;
            k--;
        }
        System.out.println(Arrays.toString(arr1));
    }
}

// *****Instead of using two if blocks use else block*****
//      0 1 2 3 4 5   0 1 2
// Eg. [1 4 7 0 0 0] [2 5 6]
// i = 2 (7)
// j = 2 (6)
// k = 5
// (arr1[i] > arr2[j]) -> (7 > 6) -> [1 4 7 0 0 7]
// Now second if runs immediately 
// i = 1 (4)
// j = 2 (6)
// k = 4
// (arr2[j] > arr1[i]) -> (6 > 4) -> [1 4 7 0 6 7]
// In one iteration, you copied elements (7 and 6)
// Algorithm should place only one largest elemnt per iterartion
// That's why:
// if(arr1[i] > arr2[j]){
//     ...
// } else {
//     ...
// }

// *****Array index out of bound exception:*****
//         0  1            0
// arr1 = [5, 0]   arr2 = [2]

// i = 0 (5)
// j = 0 (2)
// k = 1
// (arr1[i] > arr2[j]) -> (5 > 2) -> [5 5]
// i = -1
// Now if second if executes (arr2[j] > arr1[i])
// arr1[-1] -> Exception

// *****Why to copy reamining elements of arr2?*****
//         0 1 2 3 4 5             0 1 2
// arr1 = [4 5 6 0 0 0]    arr2 = [1 2 3]
// Iteration 1:
// i = 2 (6)
// j = 2 (3)
// k = 5
// (arr1[i] > arr2[j]) -> 6 > 3 -> [4 5 6 0 0 6]

// Iteration 2:
// i = 1 (5)
// j = 2 (3)
// k = 5
// (arr1[i] > arr2[j]) -> 5 > 3 -> [4 5 6 0 5 6]

// Iteration 3:
// i = 0 (4)
// j = 2 (3)
// k = 5
// (arr1[i] > arr2[j]) -> 4 > 3 -> [4 5 6 4 5 6]
// The loop stops after 3rd iteration because i = -1, which is less than length of arr1
// Now, arr2 still has not been copied yet

// *****Why copying only arr2 elements at the end why not arr1 elements?*****
// After fisrt while loop there are only two possibilities
// 1. arr1 is exhausted (i < 0)
// 2. arr2 is exhausted (j < 0)

// Case 1: arr1 is exhausted:
// arr1 = [4 5 6 0 0 0]     arr2 = [1 2 3]
// Merge from the end:
//      [4 5 6 0 0 6]
//      [4 5 6 0 5 6]
//      [4 5 6 4 5 6]
// Now, i = -1, j = 2, k = 2
// First there positions still not processed yet [_ _ _ 4 5 6]
// Only remaining values are from arr2, so copy them directly.

// Case 2: arr2 is exhausted
// arr1 = [1 2 3 0 0 0]     arr2 = [4 5 6]
// Merge from the end:
//      [1 2 3 0 0 6]
//      [1 2 3 0 5 6]
//      [1 2 3 4 5 6]
// Now, i = 2, j = -1
// Elements of arr1 are already in correct position
// If any element of arr1 remains when arr2 is exhausted, 
// they must be smaller than every element which already placed to their right.
// So no need to copy arr1 elements.