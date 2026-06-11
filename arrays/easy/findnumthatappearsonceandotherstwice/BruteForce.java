package arrays.easy.findnumthatappearsonceandotherstwice;

public class BruteForce {
    public static void main() {
        int[] nums = { 4, 1, 2, 1, 2 };

        for (int i = 0; i < nums.length; i++) {
            int count = 0; // Reset count for each element
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == nums[i]) {
                    count++;
                    // Stop if duplicate found
                    if (count == 2) {
                        break;
                    }
                }
            }
            if (count == 1) {
                System.out.println(nums[i]);
                break;
            }
        }
    }
}

// TC: O(N^2)
// SC: O(1)
