package arrays.medium.findrepeatingandmissingnumberfromarrayofonetonelements;

import java.util.Arrays;
import java.util.HashMap;

public class UsingHashMap {
    public static void main() {
        //             0  1  2  3  4
        int[] nums = { 1, 1, 3, 5, 4 };
        int n = nums.length; // 5

        // [repeating, missing]
        int[] result = new int[2];

        HashMap<Integer, Integer> count = new HashMap<>();

        // Add all elements in map
        for (int i = 0; i < nums.length; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        // Find repetind and missing number using map
        for (int i = 1; i < n; i++) {
            if (!count.containsKey(i)) {
                result[1] = i;
            } else {
                if (count.get(i) == 2) {
                    result[0] = i;
                }
            }

            // Early break, once we get both the values (Reapeating and Missing Number)
            if (result[0] != 0 && result[1] != 0) {
                break;
            }
        }
        System.out.println(Arrays.toString(result));
    }
}

// Approach: Use HashMap to store frequency of elements
// TC: O(N)
// SC: O(N)