package slidingwindow.dynamicsize.smallestsubarraysumgreaterthanorequaltok;

public class Optimal {
    public static void main() {
        //  0  1  2  3  4  5
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int target = 7;
        int n = nums.length;

        int start = 0;

        int sum = 0;
        int finalLen = Integer.MAX_VALUE;
        for (int end = 0; end < n; end++) {
            sum += nums[end];

            while (sum >= target) {
                int len = end - start + 1;
                if (len < finalLen) {
                    finalLen = len;
                }
                sum -= nums[start];
                start++;
            }
        }

        System.out.println(finalLen);
    }
}

// TC: O(N) -> start and end pointer moves 0 to n-1, start never resets or move backward
// SC: O(1)
// Problem Link: https://leetcode.com/problems/minimum-size-subarray-sum