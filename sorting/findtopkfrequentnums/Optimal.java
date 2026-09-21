package sorting.findtopkfrequentnums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Optimal {
    public static void main(String[] args) {
        // int[] nums = { 1, 1, 1, 2, 2, 3 };

        int[] nums = { 4, 5, 5, 6, 6, 7, 7, 7};

        // Num -> Frequency
        //  1  ->   3
        //  2  ->   2
        //  3  ->   1

        int n = nums.length;
        int k = 2;

        // Step 1: Count the frequency of each number
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        }

        // Bucket Sort (Sort nums based on their frequencies)
        // Step 2: Create frequency buckets
        // i = 1 -> frequency 1 -> bucket[1]
        // i = 2 -> frequency 2 -> bucket[2]
        // Index of the bucket represents the frequency

        // Why (n + 1) ? -> indexing starts from 0 and max possible frequency could be n
        // If we use n, then (0 to n-1) bucket will be created and we will miss n'th frequency bucket
        List<Integer>[] freqBucket = new ArrayList[n + 1];

        // Step 3: Put each number into its corresponding frequency bucket
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            if (freqBucket[frequency] == null) {
                freqBucket[frequency] = new ArrayList<>();
            }
            freqBucket[frequency].add(num);
        }

        // Traverse the frequency bucket in reverse direction (highest to lowest) to find top k frequency nums
        int[] result = new int[k];
        int cnt = 0;
        for (int freq = freqBucket.length - 1; freq >= 0; freq--) {
            // Skip frequencies that do not conatin any number
            if (freqBucket[freq] != null) {

                // A bucket can conatin multiple number having same frequency
                for (int num : freqBucket[freq]) {
                    result[cnt] = num;
                    cnt++;

                    // Only read 1st k nums
                    if (cnt == k) {
                        break;
                    }
                }

                // Stop traversing further nums once we have collected k numbers
                if (cnt == k) {
                    break;
                }
            }
        }
        System.out.println(Arrays.toString(result));
    }
}

// Eg. [1 1 3 3 2 2 2], k = 2
// Bucket:
// Frequency(i) -> Nums
//     0        -> 0
//     1        -> 0
//     2        -> [1 3]
//     3        -> [2]
// Ans: [2, 1]

// List -> Maintain insertion order

// TC: O(N)
// SC: O(N) -> (Bucket)

// Problem Link: https://leetcode.com/problems/top-k-frequent-elements/description/