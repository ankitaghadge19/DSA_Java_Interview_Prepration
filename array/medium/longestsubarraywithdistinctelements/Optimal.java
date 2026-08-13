package array.medium.longestsubarraywithdistinctelements;
import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 3 };
        // { 1, 4, 3, 2, 4, 5, 6, 7, 8, 9, 5 };

        HashMap<Integer, Integer> countMap = new HashMap<>();
        int i = 0;

        int maxLength = 0;
        for (int j = 0; j < nums.length; j++) {

            // Add current elemenet in window
            countMap.put(nums[j], countMap.getOrDefault(nums[j], 0) + 1);

            // If duplicate comes, shrink window
            while (countMap.get(nums[j]) > 1) {
                countMap.put(nums[i], countMap.get(nums[i]) - 1);
                if (countMap.get(nums[i]) == 0) {
                    countMap.remove(nums[i]);
                }
                i++;
            }

            // Current window is valid, all unique
            maxLength = Math.max(maxLength, j - i + 1);     // {1, 2, 3, 4, 5}
        }
        System.out.println(maxLength);
    }
}

// TC: O(N)
// SC: O(N)

// Approach:
// .containsValue() scans the entire HashMap, which takes O(n) time.
// Instead, after inserting each element, we directly check the frequency of the current element. 
// If its count becomes greater than 1, it means a duplicate is present in the current window.

// When a duplicate is found, shrink the window by moving the i pointer ahead,
// decreasing the frequency of elements from the left side, until the window contains only unique elements again.

// The j pointer always moves forward and expands the window by adding new elements.

// The only possible duplicate after inserting current element is current element num itself 
// because the previous window was already maintained with all unique elements.