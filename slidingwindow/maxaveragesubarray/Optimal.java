package slidingwindow.maxaveragesubarray;

public class Optimal {
    public static void main(String[] args) {
                 //    0   1   2   3   4  5
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;

        int s = 0;
        double result = Integer.MIN_VALUE;
        double sum = 0;
        for (int e = 0; e < nums.length; e++) {
            sum = sum + nums[e];
            if (e - s + 1 == k) {
                double avg = sum / k;
                if (avg > result) {
                    result = avg;
                }
                sum = sum - nums[s];
                s++;
            }
        }
        System.out.println(result);
    }
}

// Problem Link: https://algomaster.io/practice/dsa/maximum-average-subarray
// SC: O(1)
// TC: O(N)
