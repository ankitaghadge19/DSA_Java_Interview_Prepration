package Arrays.Product_Of_Array_Except_Self;

import java.util.Arrays;

public class OptimalSoln {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] result = new int[n];

        int prefixProd = 1;
        for(int i=0; i<n; i++){
            prefixProd = prefixProd * nums[i];
            prefix[i] = prefixProd;
        }

        int suffixProd = 1;
        for(int i=n-1; i>=0; i--){
            suffixProd = suffixProd * nums[i];
            suffix[i] = suffixProd;
        }

        for(int i=0; i<n; i++){
            if(i==0){
                result[i] = suffix[i+1];
            }else if(i == n-1){
                result[i] = prefix[i-1];
            }else{
                result[i] = prefix[i-1] * suffix[i+1];
            }
        }
        Arrays.stream(result).forEach(x -> System.out.println(x));

        // Dry Run
        // 1)
        //    Idx:     0     1      2      3
        //    Input:  [1,    2,     3,     4]
        //    Prefix: [1,    2,     6,     24]
        //    Suffix: [24,   24,    12,    4]

        //    Output: [24, (1*12), (2*4),  6]
        //    At 0th index no Prefix, At Nth index no Suffix

        // 2)
        //    Idx:     0     1      2      3
        //    Input:  [1,    0,     2,     3]
        //    Prefix: [1,    0,     0,     0]
        //    Suffix: [0,    0,     6,     3]

        //    Output: [0, 6, 0, 0]

        // TC: O(N)
        // SC: O(N)

        //Problem Link: https://leetcode.com/problems/product-of-array-except-self
    }
}
