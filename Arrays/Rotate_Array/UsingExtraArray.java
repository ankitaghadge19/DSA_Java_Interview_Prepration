package Arrays.Rotate_Array;

import java.util.Arrays;

public class UsingExtraArray {
    public static void main(String[] args) {
        int k=3;
            //Idx:  0  1  2  3  4  5
        int[] nums = {1, 2, 3, 4, 5, 6};
        int len = nums.length; // 6

        int[] result = new int[len];

        for(int i=0; i<len; i++){
            int idx = (i+k) % len;
            result[idx] = nums[i];
        }
        Arrays.stream(result).forEach(x -> System.out.println(x));

        // Dry Run:
        // i=0; (0+3) % 3 = 3;
        // i=1; (1+3) % 3 = 4;
        // i=2; (2+3) % 3 = 5;
        // i=3; (3+3) % 3 = 0;
        // i=4; (3+4) % 3 = 1;
        // i=5; (3+5) % 3 = 2;

        // TC: 0(1)
        // SC: 0(N)
    }
}
