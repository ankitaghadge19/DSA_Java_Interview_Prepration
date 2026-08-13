package array.easy.unionoftwosortedarraysreturnnewarray;

import java.util.TreeSet;

public class UsingSet {
    public static void main() {
        int[] arr1 = { 1, 2, 3, 4, 5 };
        int[] arr2 = { 2, 3, 4, 4, 5 };
        TreeSet<Integer> result = new TreeSet<>();
        for (int i = 0; i < arr1.length; i++) {
            result.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            result.add(arr2[i]);
        }
        System.out.println(result);
    }
}

// TC: O(n log n + m log m)
// SC: O(n + m)
// n is length of array 1
// m is length of array 2