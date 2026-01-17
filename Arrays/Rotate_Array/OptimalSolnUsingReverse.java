import java.util.Arrays;

public class OptimalSolnUsingReverse {
    public static void main(String[] args) {
        
              //Idx:  0  1  2  3  4  5      -> Ans: 4 5 6 1 2 3
        int[] nums = {1, 2, 3, 4, 5, 6};
        int len = nums.length;

        int k=3;
        k=k%len; // if (k>len)

        // step 1: Reverse entire array -> 6 5 4 3 2 1
        reverse(0, len-1, nums);

        // step 2: Reverse first k elements (6 5 4) -> 4 5 6 3 2 1
        reverse(0, k-1, nums);

        // step 3: Reverse remaining elements (3 2 1) -> 4 5 6 1 2 3
        reverse(k, len-1, nums);
        
        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }

    private static void reverse(int left, int right, int[] nums){
        while(left<right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    // TC: 0(1)
    // SC: 0(1)

    // Problem Link: https://leetcode.com/problems/rotate-array
}
