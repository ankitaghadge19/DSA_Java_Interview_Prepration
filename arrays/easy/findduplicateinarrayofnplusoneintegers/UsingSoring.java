package arrays.easy.findduplicateinarrayofnplusoneintegers;

import java.util.Arrays;

public class UsingSoring {
    public static void main() {
        int[] nums = { 1, 3, 4, 2, 2 };

        Arrays.sort(nums); // 1, 2, 2, 3, 4

        for (int i = 0; i < nums.length - 1; i++) {
            // If current element and next element are same, then we found the duplicate number
            if (nums[i] == nums[i + 1]) {
                System.out.println(nums[i]);
            }
        }
    }
}

// TC: N(log(N))
// SC: O(1)
