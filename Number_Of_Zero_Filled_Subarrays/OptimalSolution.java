package Number_Of_Zero_Filled_Subarrays;

public class OptimalSolution {
    public static void main(String[] args) {
        int[] nums = {1,3,0,0,2,0,0,4};
        // Output: 6
        // Explanation: 
        // There are 4 occurrences of [0] as a subarray.
        // There are 2 occurrences of [0,0] as a subarray.
        // There is no occurrence of a subarray with a size more than 2 filled with 0. 
        // Therefore, we return 6.

        // Approach:
        // 1. Find set of consecutive zeros
        // 2. Total no of Substrings = (n*(n+1))/2
        // Eg. s = "000", n = 3
        // Start at 1st zero  -> 0, 00, 000  -> 3 = (n)
        // Start at 2nd zero  -> 0, 00       -> 2 = (n-1)
        // Start at 3rd zero  -> 0           -> 1 = (n-2)
        // Total Substrings: n + (n-1) + (n-2) + .... + 1 = (n*(n+1))/2
        // Triangular Number Series: Sum of first n natural numbers

        long result = 0;
        long n = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                n++;
            }else{
                result = result + ((n*(n+1))/2);
                n = 0;
            }
        }
        // For trailing zeros eg. [1,0,0,2,0,0,0]
        result = result + ((n*(n+1))/2);
        System.out.println(result);

        // Link: https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
    }
}
