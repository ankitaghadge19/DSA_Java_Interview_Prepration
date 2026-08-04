package arrays.easy.checkifarrayissortedandrotated;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int n = nums.length;
        int dropCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > (nums[(i + 1) % n])) { // Circular Comparison[2 1 3 4 5]
                dropCount++;
            }
        }
        System.out.println(dropCount <= 1);
    }
}

// TC: O(N)
// SC: O(1)
// Problem Link: https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/

// A sorted (or sorted and rotated) array has at most one drop.
//
// Drop means:
// nums[i] > nums[(i + 1) % n]
//
// Why do we need circular comparison?
//
// Example:
// nums = {2, 1, 3, 4, 5}
//
// Normal comparisons:
// 2 > 1  -> Drop 1
// 1 < 3  -> OK
// 3 < 4  -> OK
// 4 < 5  -> OK
//
// Without comparing the last element with the first,
// we would think there is only one drop and return true.
//
// Circular comparison:
// 5 > 2  -> Drop 2
//
// Total drops = 2
// Since drops > 1, the array is NOT sorted and rotated.