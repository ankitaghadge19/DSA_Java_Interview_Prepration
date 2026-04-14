package slidingwindow.maxaveragesubarray;

public class BruteForce {
        public static void main(String[] args) {
                     //    0   1   2   3   4  5
            int[] nums = { 1, 12, -5, -6, 50, 3 };
            int k = 4;

            double result = Integer.MIN_VALUE;
            for (int s = 0; s <= nums.length - k; s++) {
                double sum = 0;
                for (int e = s; e-s+1 <= k; e++) {
                    sum = sum + nums[e];
                }
                double avg = sum / k;
                if (avg > result) {
                    result = avg;
                }
            }
            System.out.println(result);
        }       
}

// SC: O(1)
// TC: O(N^2)