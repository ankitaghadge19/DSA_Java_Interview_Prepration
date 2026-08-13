package array.medium.majorityelement.findelementswhichappearsgreaterthannbythreetimes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 1, 1, 3, 2, 2 };
        int n = nums.length;
        int parts = n / 3;
        Map<Integer, Integer> count = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);

            if (count.get(nums[i]) > parts && !result.contains(nums[i])) {
                result.add(nums[i]);
            }

            if (result.size() == 2) {
                break;
            }
        }
        System.out.println(result);
    }
}

// TC: O(N)
// SC: O(N)
