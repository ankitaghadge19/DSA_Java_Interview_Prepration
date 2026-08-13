package array.easy.findnumthatappearsonceandotherstwice;

import java.util.Arrays;

public class UsingSorting {
    public static void main(String[] args) {
        int[] nums = { 4, 1, 2, 1, 2 };
        Arrays.sort(nums); // 1, 1, 2, 2, 4
        for (int i = 0; i < nums.length - 1; i +=2) {
            // If current element is not equal to it's adjacent element, it is the number that appear only once
            if (nums[i] != nums[i + 1]) {
                System.out.println(nums[i]);
            }
        }
        // If all pairs matched , the single element must be the last element
        System.out.println(nums[nums.length - 1]);
    }
}

// TC: N(log(N))
// SC: O(1)

// i += 2 -> One iteration complete pair of elements 