package slidingwindow.fixedsize.maxsumofdistinctsubarraywithlenk;

import java.util.HashSet;
import java.util.Set;

public class BruteForce {
    public static void main() {
        //     0  1  2  3  4  5  6
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;
        Set<Integer> count = new HashSet<>();

        long finalSum = 0;
        for (int i = 0; i <= (nums.length - k); i++) {
            int sum = 0;
            for (int j = i; j < (i + k); j++) {
                sum = sum + nums[j];
                count.add(nums[j]);
            }
            if (count.size() == k) {
                finalSum = Math.max(finalSum, sum);
            }
            count.clear();
        }
        System.out.println("Max sum of distinct sub array: " + finalSum);
    }
}

// TC: O(N^2)
// SC: O(K)
