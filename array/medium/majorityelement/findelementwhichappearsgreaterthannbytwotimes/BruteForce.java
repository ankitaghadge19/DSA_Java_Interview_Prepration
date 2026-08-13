package array.medium.majorityelement.findelementwhichappearsgreaterthannbytwotimes;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int n = nums.length; // 7
        // 7 / 2 = floor(3.5) = 3
        // Count of 2 is 4
        // (cnt > (n/2)) == (4 > 3) == True

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt > (n / 2)) {
                System.out.println(nums[i]);
                break;
            }
        }
    }
}

// TC: O(N^2)
// SC: O(1)