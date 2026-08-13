package array.easy.unionoftwosortedarraysreturnnewarray;

import java.util.ArrayList;

public class OptimalSolution {
    public static void main() {
        int[] arr1 = { 0, 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 3, 4, 4, 5, 6, 7, 7, 8 };
        int n = arr1.length;
        int m = arr2.length;
        int i = 0;
        int j = 0;

        ArrayList<Integer> union = new ArrayList<>();
        while (i < n && j < m) {
            if (arr1[i] == arr2[j]) {
                if (union.isEmpty() || // Initally array will be empty so simply add element without any comparison
                        union.get(union.size() - 1) != arr1[i]) { // Last inserted elemet should not be equal to current element
                    union.add(arr1[i]);
                }
                i++;
                j++;
            } else if (arr1[i] < arr2[j]) {
                if (union.isEmpty() || // Initally array will be empty so simply add element without any comparison
                        union.get(union.size() - 1) != arr1[i]) {
                    union.add(arr1[i]);
                }
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (union.isEmpty() || // Initally array will be empty so simply add element without any comparison
                        union.get(union.size() - 1) != arr2[j]) {
                    union.add(arr2[j]);
                }
                j++;
            }
        }
        while (i < n) {
            if (union.get(union.size() - 1) != arr1[i]) {
                union.add(arr1[i]);
            }
            i++;
        }
        while (j < m) {
            if (union.get(union.size() - 1) != arr2[j]) {
                union.add(arr2[j]);
            }
            j++;
        }
        System.out.println(union);
    }
    
    // Solution using conatins operation: 
        // while (i < n && j < m) {
        //     if (arr1[i] == arr2[j]) {
        //         if (!union.contains(arr1[i])) {
        //             union.add(arr1[i]);
        //         }
        //         i++;
        //         j++;
        //     } else if (arr1[i] < arr2[j]) {
        //         if (!union.contains(arr1[i])) {
        //             union.add(arr1[i]);
        //         }
        //         i++;
        //     } else if (arr2[j] < arr1[i]) {
        //         if (!union.contains(arr2[j])) {
        //             union.add(arr2[j]);
        //         }
        //         j++;
        //     }
        // }
        // while (i < n) {
        //     if (!union.contains(arr1[i])) {
        //         union.add(arr1[i]);
        //     }
        //     i++;
        // }
        // while (j < m) {
        //     if (!union.contains(arr2[j])) {
        //         union.add(arr2[j]);
        //     }
        //     j++;
        // }
}

// Approach:
// Since both arrays are sorted, use two pointers i and j.
//
// Compare arr1[i] and arr2[j]:
//
// 1. If arr1[i] < arr2[j],
//    arr1[i] is the smaller element, so add it to the union
//    and move pointer i.
//
// 2. If arr2[j] < arr1[i],
//    arr2[j] is the smaller element, so add it to the union
//    and move pointer j.
//
// 3. If arr1[i] == arr2[j],
//    add the element only once to the union
//    and move both pointers.
//
// To avoid duplicates, before adding an element,
// check whether it is different from the last inserted element in the union.
//
// Why does checking only the last inserted element work?
// Because both arrays are sorted. If a duplicate element
// appears, it will be encountered consecutively during traversal.
// Therefore, if the current element is already present in the union,
// it must be equal to the last inserted element.
//
// This avoids the costly contains() operation.

// Why do we add the smaller element first?
//
// Example:
// arr1 = [1, 2, 3, 4, 5]
// arr2 = [2, 3, 4, 5, 6]
//
// Initially:
// arr1[i] = 1
// arr2[j] = 2
//
// Can 2 appear before 1 in the union?
// No.
//
// Since both arrays are sorted, 1 is the smallest
// available element and must appear first in the union.
//
// Therefore:
// Add 1 to the union and move pointer i.

// Time Complexity: O(n + m)
// Space Complexity: O(n + m)
// Problem Link: https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

