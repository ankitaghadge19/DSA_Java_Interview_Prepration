package arrays.easy.largestelement;

public class Optimal {
    public static void main() {
        int[] nums = { 2, 5, 1, 3, 0 };

        int largest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > largest) {
                largest = nums[i];
            }
        }
        System.out.println(largest);
    }
}

// TC: O(N)
// SC: O(1)