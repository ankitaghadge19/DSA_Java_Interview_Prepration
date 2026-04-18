package slidingwindow.dynamicsize.minsizesubarraysum;

public class BruteForce {
    public static void main() {
        //  0  1  2  3  4  5
        int[] nums = { 1, 4, 4 };
        int target = 4;
        int n = nums.length;

        int finalLen = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    int len = j - i + 1;
                    if (len < finalLen) {
                        finalLen = len;
                    }
                    break;
                }
            }
        }
        if (finalLen == Integer.MAX_VALUE) {
            finalLen = 0;
        }
        System.out.println("Min size sub array sum: " + finalLen);
    }
}

// TC: O(N^2)
// SC: O(1)
