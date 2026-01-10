package Arrays.Product_Of_Array_Except_Self;

import java.util.Arrays;

public class BruteForceSoln {
    public static void main(String[] args) {
        int[] nums = {-1,1,0,-3,3};
        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            int product = 1;
            for(int j=0; j<nums.length; j++){
                if(i!=j){
                    product = product * nums[j];
                }
            }
            result[i]=product;
        }
        Arrays.stream(result).forEach(x -> System.out.println(x));

        // TC: 0(N^2)
        // SC: 0(N)
    } 
}
