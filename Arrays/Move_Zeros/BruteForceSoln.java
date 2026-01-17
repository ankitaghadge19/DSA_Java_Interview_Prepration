import java.util.Arrays;

public class BruteForceSoln {
    public static void main(String[] args) {
        int[] nums = {1,0,1};  

        int n = nums.length;
        int i=0;
        int j=0;
        while(i<n && j<n){
            if(j<=i){
                j=i+1;
                continue;   //For eg. {1,0}
            }
            if(nums[i]==0 && nums[j]!=0){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }else if(nums[i]!=0){
                i++;
            }else if(nums[j]==0){
                j++;
            }
        }

        Arrays.stream(nums).forEach(x -> System.out.println(x));
    }
}
