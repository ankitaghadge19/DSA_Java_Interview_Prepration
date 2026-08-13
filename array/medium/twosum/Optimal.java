package array.medium.twosum;

import java.util.HashMap;
import java.util.Map;

public class Optimal {
    public static void main() {
        int[] nums = { 3, 3 };
        int target = 6;

        int[] result = twoSum(nums, target);

        System.out.println(result[0] + ", " + result[1]);
    }
    
    static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (count.containsKey(diff)) {
                return new int[] {count.get(diff), i};
            }
            count.put(nums[i], i);
        }
        return new int[] {-1, -1};
    }
}

// TC: O(N)
// SC: O(N)...In worst case (where two nums are at the end)

// Using Sorting:
// TC: O(Nlog(N) + O(N) (While Loop)
// log(N) -> No of times u can divide N in half (Height)
// N -> Work done at eact level (Comapare and put nums in correct order) (Width)
// SC: O(N)

// Problem Link: https://leetcode.com/problems/two-sum