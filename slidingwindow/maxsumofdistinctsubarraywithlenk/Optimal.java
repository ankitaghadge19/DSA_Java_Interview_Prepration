package slidingwindow.maxsumofdistinctsubarraywithlenk;

import java.util.HashMap;

public class Optimal {
    public static void main(String[] args) {
                //     0  1  2  3  4  5  6
        int[] nums = { 1, 5, 4, 2, 9, 9, 9 };
        int k = 3;

        HashMap<Integer, Integer> count = new HashMap<>();
        long finalSum = 0;
        long sum = 0;
        int b = 0;

        for (int e = 0; e < nums.length; e++) {
            sum = sum + nums[e];
            count.put(nums[e], count.getOrDefault(nums[e], 0) + 1);

            if ((e - b + 1) > k) {
                sum = sum - nums[b];
                count.put(nums[b], count.getOrDefault(nums[b], 0) - 1);
                if (count.get(nums[b]) == 0) {
                    count.remove(nums[b]);
                }
                b++;
            }
            
            if (((e - b + 1) == k) && (count.size() == k)) {
                finalSum = Math.max(finalSum, sum);
            }
        }
        System.out.println("Max sum of distinct sub array: " + finalSum);
    }
}

// HashSet -> [1 1 2 3] (How to handle this case?)