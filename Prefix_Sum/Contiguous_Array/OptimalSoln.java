import java.util.HashMap;
import java.util.Map;

public class OptimalSoln {
    public static void main(String[] args) {
        int[] nums = {0,0,1,0,0,0,1,1};
        int maxLen = 0;
        //Replace 0 by -1
        for(int j=0; j<nums.length; j++){
            if(nums[j] == 0){
                nums[j] = -1;
            }
        }
        Map<Integer, Integer> sumIdx = new HashMap<>();
        sumIdx.put(0, -1);  // If sum=0 (eg. [0,1])

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (sumIdx.keySet().contains(sum)) {
                int idx = sumIdx.get(sum);
                int len = i - idx;
                if (len > maxLen) {
                    maxLen = len;
                }    
            }else {
                sumIdx.put(sum, i);
            }
        }
        System.out.println(maxLen);
 
        // Dry Run: Contigous Array
        // Idx: 0   1   2   3   4   5   6   7
        // Eg.  0   0   1   0   0   0   1   1
        //     -1  -1   1  -1  -1  -1   1   1 (Replace 0 by -1)
        //                                            HashMap
        //                                          Sum      Idx
        //                                          -1        0
        //                                           1       -2
        // Idx     Sum
        //  0      -1
        //  1      -2
        //  2      -1
        // Now, when we are at index 2, we get the sum as -1 again. 
        // This means that between index 0 and index 2, the same number of 0's were subtracted and 1's were added, 
        // resulting in no net change in the sum.
        // length = 2 - 0 = 2

        // Problem Link: https://leetcode.com/problems/contiguous-array
    }
}
