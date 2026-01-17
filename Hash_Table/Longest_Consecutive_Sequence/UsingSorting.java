import java.util.Arrays;

public class UsingSorting {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,4,100};
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    } 
    
    public static int longestConsecutiveSequence(int[] nums){
        if(nums.length == 0) return 0; // []
        if(nums.length == 1) return 1; // [0]
        Arrays.sort(nums); 
        int current = nums[0];
        int finalLen = 1;
        int tempLen = 1;
        for(int i=1; i<nums.length; i++){
            if(nums[i] == current){
                continue;
            }else if(nums[i] == current+1){
                tempLen++;
                current=nums[i];
            }else{
                tempLen=1;
                current=nums[i];
            }
            finalLen = Math.max(finalLen, tempLen);
        }
        return finalLen;
    }
}
