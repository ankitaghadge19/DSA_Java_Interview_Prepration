package arrays.medium.longestsubarraysumequalszero;

public class BruteForce {
    public static void main() {
        int[] nums = { 9, -3, 3, -1, 6, -5 };
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == 0) {
                    int len = j - i + 1;
                    if (maxLen < len) {
                        maxLen = len;
                    }
                }
            }
        }
        System.out.println(maxLen);
    }
}
