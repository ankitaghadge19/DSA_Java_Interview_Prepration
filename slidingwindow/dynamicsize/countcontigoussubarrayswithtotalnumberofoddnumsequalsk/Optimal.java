package slidingwindow.dynamicsize.countcontigoussubarrayswithtotalnumberofoddnumsequalsk;

public class Optimal {
    static int countSubArrays(int[] nums, int k) {
        int odd = 0;
        int cnt = 0;
        int s = 0;

        for (int e = 0; e < nums.length; e++) {
            if (nums[e] % 2 != 0) {
                odd++;
            }

            while (odd > k) {
                if (nums[s] % 2 != 0) {
                    odd--;
                }
                s++;
            }
            cnt = cnt + (e - s + 1);
        }
        return cnt;
    }

    public static void main() {
        int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;

        int result = countSubArrays(nums, k) - countSubArrays(nums, k - 1);
        System.out.println(result);
    }
}

// SC: O(1)
// TC: O(N)
// Problem Link: https://leetcode.com/problems/count-number-of-nice-subarrays

// Note:
// Similar Problem: Binary Sub Array With Sum
// count(subarrays with exactly k odd) = atMost(k odd) - atMost(k-1 odd)
// Here there is not only one subarray per window, but actually there can be multiple valid subarrays ending at index e