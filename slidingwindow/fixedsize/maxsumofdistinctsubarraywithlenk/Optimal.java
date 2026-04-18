package slidingwindow.fixedsize.maxsumofdistinctsubarraywithlenk;

import java.util.HashMap;

public class Optimal {
    public static void main() {
                //     0  1  2  3  4  5  6
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        HashMap<Integer, Integer> count = new HashMap<>();
        long finalSum = 0;
        long sum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];
            count.put(nums[end], count.getOrDefault(nums[end], 0) + 1);

            if ((end - start + 1) > k) {
                sum = sum - nums[start];
                count.put(nums[start], count.getOrDefault(nums[start], 0) - 1);
                if (count.get(nums[start]) == 0) {
                    count.remove(nums[start]);
                }
                start++;
            }
            
            if (((end - start + 1) == k) && (count.size() == k)) {
                finalSum = Math.max(finalSum, sum);
            }
        }
        System.out.println("Max sum of distinct sub array: " + finalSum);
    }
}

// HashSet -> [1 1 2 3] (How to handle this case?)
// TC: O(N)
// SC: O(K)
// Problem Link: https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/