package arrays.medium.longestsubarraysumequalskonlypositives;

public class Optimal {
    public static void main() {
        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15;

        int left = 0;
        int maxLen = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum = sum + nums[right];

            // Shrink window until sum <= k 
            while (sum > k) {
                sum = sum - nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        System.out.println(maxLen);
    }
}

// TC: O(1) 
// SC: O(N)

// Problem Link: Not Available

// Sliding Window Approach: (Only works for positive nums)
// Right pointer expands the window by adding new elements from the right, increasing sum.
// Left pointer shrinks the window by removing elements from the left, decreasing sum.
// If sum > k, keep shrinking the window until sum <= k.
// The process continues until the right pointer traverses the entire array.

// Why shrink until sum <= k?

// nums = [2, 3, 4, 5], k = 5
//
// Window           Sum
// [2]               2
// [2, 3]            5
// [2, 3, 4]         9
//
// Now sum > k.
//
// Suppose we shrink only once:
// Remove 2
//
// Window           Sum
// [3, 4]            7
//
// sum is still > k.
//
// If we stop shrinking and move right again:
//
// Window           Sum
// [3, 4, 5]        12
//
// We reached the end of the array and never discovered
// the valid window [5] with sum = 5 at index 3.
//
// Therefore, whenever sum > k, we must keep shrinking:
//
// while(sum > k) {
//     sum -= nums[left];
//     left++;
// }
//
// until sum <= k.