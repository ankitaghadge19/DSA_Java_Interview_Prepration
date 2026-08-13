package array.medium.twosum;

public class BruteForce {
    public static void main() {
        int[] nums = { 3,2,4 };
        int target = 6;

        int[] result = twoSum(nums, target);
        
        for (int n : result) {
            System.out.println(n);
        }
    }

    static int[] twoSum(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

// SC: O(1)
// TC: O(N^2)