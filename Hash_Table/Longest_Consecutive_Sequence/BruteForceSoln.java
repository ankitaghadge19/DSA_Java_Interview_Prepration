package Longest_Consecutive_Sequence;

class BruteForceSoln {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 4, 5, 6};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
    private static int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int longest = 1;
        for(int i=0; i<nums.length; i++){
            int current = nums[i];
            int next = current + 1;
            int count = 1;

            while(true){
                boolean found = false;
                for(int num : nums){
                    if(num == next){
                        found = true;
                        break;
                    }
                }
                if(found){
                    next = next + 1;
                    count++;
                }else{
                    break;
                }
            }
            if(count > longest){
                longest = count;
            }
        }
        return longest;
    }
}