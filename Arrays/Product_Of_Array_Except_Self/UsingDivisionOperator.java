package Arrays.Product_Of_Array_Except_Self;

import java.util.Arrays;

public class UsingDivisionOperator {
    public static void main(String[] args) {
        int[] nums = { -1, 1, 0, -3, 3 };
        int len = nums.length;
        int[] result = new int[len];
        int product = 1;
        int noOfZeros = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                noOfZeros++;
            } else {
                product = product * nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            if (noOfZeros > 1) {
                result[i] = 0;
            } else if (noOfZeros == 1) {
                if (nums[i] == 0) {
                    result[i] = product;
                } else {
                    result[i] = 0;
                }
            } else {
                result[i] = product / nums[i];
            }
        }
        Arrays.stream(result).forEach(x -> System.out.println(x));

        // Dry Run:
        // Input: [1, 2, 3, 0, 4] 
        // Output: [0, 0, 0, 6, 4]

        // Input: [1, 0, 3, 0, 4] 
        // Output: [0, 0, 0, 0, 0]

        // Input: [1, 2, 3, 4]
        // product = 24
        // Output: [24/1, 24/2, 24/3, 24/4] -> [24, 12, 8, 6]

        // TC = O(N)
        // SC = O(N)
    }
}
