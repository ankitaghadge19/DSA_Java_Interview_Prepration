package slidingwindow.dynamicsize.countcontigoussubarrayswithtotalnumberofoddnumsequalsk;

public class BruteForce {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 };
        int k = 2;
        int cnt = 0;

        for (int s = 0; s < nums.length; s++) {
            int odd = 0;
            for (int e = s; e < nums.length; e++) {
                if (nums[e] % 2 != 0) {
                    odd++;
                }
                if (odd == k) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

// TC: O(N^2)
// SC: O(1)
