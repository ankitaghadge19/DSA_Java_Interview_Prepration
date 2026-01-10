package Arrays.Rotate_Array;

import java.util.Arrays;

public class BruteForceSoln {
    public static void main(String[] args) {
        int k=3;
            //Idx:  0  1  2  3  4  5
        int[] nums = {1, 2, 3, 4, 5, 6};
        int len = nums.length;

        while(k>0){
            int last = nums[len-1];
            for(int i=len-1; i>=0; i--){
                if(i==0){
                    nums[i] = last;
                }else{
                    nums[i] = nums[i-1];
                }
            }
            k--;
        }
        Arrays.stream(nums).forEach(x -> System.out.println(x));

        // TC: 0(N^2)
        // SC: 0(1)
    }
}
