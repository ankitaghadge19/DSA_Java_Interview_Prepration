package arrays.easy.findmissingnumber;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 8, 2, 4, 5, 3, 7, 1 };
        int n = nums.length + 1;
        for (int i = 1; i <= n; i++) {
            boolean found = false;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == i) {
                    found = true;
                }
            }
            if (!found) {
                System.out.println(i);
                break;
            }
        }
    }
}

// Approach:
// Array conatisn number from 1 to n
// One number is missing so array size is n-1
// Check weather 1 exist by travesing entire array
// Then check weather 2 exists
// Continue until n
// The number that is not found is missing number

// TC: O(N^2)
// SC: O(1)
