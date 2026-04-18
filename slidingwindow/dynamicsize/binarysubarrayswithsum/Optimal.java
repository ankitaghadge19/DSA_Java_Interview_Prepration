package slidingwindow.dynamicsize.binarysubarrayswithsum;

public class Optimal {
    static int countSubArrays(int[] nums, int goal){
        if(goal < 0) return 0;
        int sum = 0;
        int cnt = 0;
        int s = 0;
        for(int e=0; e<nums.length; e++){
            sum += nums[e];
            while(sum>goal){
                sum -= nums[s];
                s++;
            }
            cnt = cnt + (e - s + 1);
        }
        return cnt;
    }

    static void main() {
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        int result = countSubArrays(nums, goal) - countSubArrays(nums, goal - 1);
        System.out.println(result);
    }
}

// TC: O(2N)
// SC: O(1)
// Problem Link: https://leetcode.com/problems/binary-subarrays-with-sum

//Approach:
//goal=2
//Idx:  0 1 2 3 4
//Eg.   1 0 1 0 1
//                                                     (Discard similar from <=2 and <=1)
//Idx:  (Subarrays)       Sum <= 2        Sum <= 1        Sum == 2
//1   ->  1                  [1]             [1]             X
//
//1   ->  1 0                [1 0]           [1 0]           X
//        0                  [0]             [0]             X
//
//2   ->  1 0 1              [1 0 1]         X               ✔
//        0 1                [0 1]           [0 1]           X
//        1                  [1]             [1]             X
//
//3   ->  1 0 1 0            [1 0 1 0]       X               ✔
//        0 1 0              [0 1 0]         [0 1 0]         X
//        1 0                [1 0]           [1 0]           X
//        0                  [0]             [0]             X
//
//4   ->  1 0 1 0 1          X               X               X
//        0 1 0 1            [0 1 0 1]       X               ✔
//        1 0 1              [1 0 1]         X               ✔
//        0 1                [0 1]           [0 1]           X
//        1                  [1]             [1]             X
//                          =14              =10            =14-10=4
