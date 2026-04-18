package slidingwindow.dynamicsize.binarysubarrayswithsum;

public class BruteForce {
    public static void main() {
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        int cnt = 0;

        for (int s = 0; s < nums.length; s++) {
            int sum = 0;
            for (int e = s; e < nums.length; e++) {
                sum += nums[e];

                if (sum == goal) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

// TC: O(N^2)
// SC: O(1)

//Approach:
//Idx:    0 1 2 3 4
//Eg.     1 0 1 0 1
//goal = 2
//
//Idx
//0   ->  0
//
//1   ->  1 0
//        0
//
//2   ->  1 0 1   ✔
//        0 1
//        1
//
//3   ->  1 0 1 0  ✔
//        0 1 0
//        1 0
//        0
//
//4   ->  1 0 1 0 1
//        0 1 0 1  ✔
//        1 0 1   ✔
//        0 1
//        1




