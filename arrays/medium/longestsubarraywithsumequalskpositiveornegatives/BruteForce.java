package arrays.medium.longestsubarraywithsumequalskpositiveornegatives;

public class BruteForce {
    public static void main() {
        int[] nums = { 10, 5, 2, 7, 1, -10 };
        int k = 15;
        int len = 0;
        for (int s = 0; s < nums.length; s++) {
            int sum = 0;
            for (int e = s; e < nums.length; e++) {
                sum += nums[e];
                if (sum == k) {
                    len = Math.max(len, e - s + 1);
                    break;
                }
            }
        }
        System.out.println(len);
    }
}

// Find all possible subarrays and calculate it's sum
// TC = O(N^2)
// SC = O(N)