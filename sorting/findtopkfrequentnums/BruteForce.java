package sorting.findtopkfrequentnums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 4, 6, 6, 5, 5, 7, 7, 7 };
        int n = nums.length;
        int k = 2;

        int[] result = new int[k];
        HashMap<Integer, Integer> freMap = new HashMap<>();

        // Step 1: Count frequency of each number
        // Number -> Frequency
        // 4 -> 1
        // 5 -> 2
        // 6 -> 2
        // 7 -> 3
        for (int num : nums) {
            freMap.put(num, freMap.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find the highest-frequency number k times
        // Each time, remove the selected number from the map
        // so that the next iteration finds the next highest frequency
        for (int i = 0; i < k; i++) {
            int key = 0;
            int value = 0;

            // Traverse the map and find the number having the highest frequency
            for (Map.Entry<Integer, Integer> entry : freMap.entrySet()) {
                if (entry.getValue() > value) {
                    key = entry.getKey();
                    value = entry.getValue();
                }
            }

            // Store the number with the highest frequency
            result[i] = key;

            // After finding the highest-frequency number, remove it from the map
            // so that in the next iteration, we can find the next highest-frequency number.
            freMap.remove(key);
        }

        System.out.println(Arrays.toString(result));

        // Ans: (7, 5) / (7, 6)
        // 5 and 6 have the same frequency, so either one is valid.
    }
}

// TC: O(N + (K * U))
// N -> Total number of elements in nums
//      Used to build the frequency map
// K * U -> We traverse the map K times
//          Each traversal checks U unique elements to find the highest-frequency element

// SC: O(U + K)
// U -> Number of unique elements stored in the frequency map.
