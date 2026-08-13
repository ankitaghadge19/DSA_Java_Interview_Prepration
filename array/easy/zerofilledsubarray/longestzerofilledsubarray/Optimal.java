package array.easy.zerofilledsubarray.longestzerofilledsubarray;
public class Optimal {
    public static void main() {
        int[] nums = { 0, 1, 3, 0, 0, 2, 4, 0, 0, 0 };

        // Count longest consecutive zeros seen so far
        int globalZeros = 0;
        
        // Count current consecutive zeros
        int zeros = 0;
    
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros++;
            } else {
                globalZeros = Math.max(zeros, globalZeros);
                zeros = 0;
            }
        }
        globalZeros = Math.max(zeros, globalZeros);

        System.out.println(globalZeros);
    }
}

// TC: O(N)
// SC: O(1)

// Approach:
// Keep counting consecutive zeros.
// Wheneven non zero element appears, compare current zero count with longest consecutive zero filled subarray found so far.
// Reset the current count to 0.