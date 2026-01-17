public class OptimalSoln {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};

        int l=0;
        for(int r=0; r<nums.length; r++){
            if(nums[r] != 0){
                int temp = nums[r];
                nums[r] = nums[l];
                nums[l] = temp;
                l++;
            }
        }

        // Dry Run: Move Zeroes
        // Input: [0, 1, 0, 3, 12]
        // Index:  0  1  2  3  4

        // l = 0, r = 0
        // nums[r] == 0 → no swap, r++

        // l = 0, r = 1
        // nums[r] == 1 → swap(nums[0], nums[1])
        // Array: [1, 0, 0, 3, 12]
        // l = 1, r = 2

        // l = 1, r = 2
        // nums[r] == 0 → no swap, r++

        // l = 1, r = 3
        // nums[r] == 3 → swap(nums[1], nums[3])
        // Array: [1, 3, 0, 0, 12]
        // l = 2, r = 4

        // l = 2, r = 4
        // nums[r] == 12 → swap(nums[2], nums[4])
        // Array: [1, 3, 12, 0, 0]
        // l = 3, r = 5 → stop
    
        // l stops when it points at 0, and r moves forward to find the next non-zero element

        // Problem Link: https://leetcode.com/problems/move-zeroes
    }
}
