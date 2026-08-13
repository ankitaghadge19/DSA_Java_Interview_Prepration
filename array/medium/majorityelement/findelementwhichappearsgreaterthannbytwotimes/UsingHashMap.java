package array.medium.majorityelement.findelementwhichappearsgreaterthannbytwotimes;

import java.util.HashMap;

public class UsingHashMap {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int n = nums.length;

        HashMap<Integer, Integer> cnt = new HashMap<>();
        for (int num : nums) {
            if (cnt.containsKey(num)) {
                int value = cnt.get(num) + 1;
                if (value > (n / 2)) {
                    System.out.println(num);
                    break;
                }
                cnt.put(num, value);
            } else {
                cnt.put(num, 1);
            }
        }
    }
}

// TC: O(N)
// SC: O(N)
