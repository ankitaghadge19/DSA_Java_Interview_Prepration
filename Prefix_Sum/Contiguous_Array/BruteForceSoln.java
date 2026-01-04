package Contiguous_Array;

public class BruteForceSoln {
    public static void main(String[] args) {
        int[] nums = {0,1,1,1,1,1,0,0,0};

        int i=0; 
        int j=0;
        for(int p=0; p<nums.length; p++){
            int m=0; 
            int n=0;
            for(int q=p; q<nums.length; q++){
                if(nums[q] == 0){
                    m++;
                }else if(nums[q] == 1){
                    n++;
                }
                if((m==n) && (m>i) && (n>j)){
                    i=m;
                    j=n;
                }
            }
        }
        System.out.println(i+j);

        // Dry Run: Contigous Array
        // Idx-  0 1 2 3 4 5 6
        // Eg.   1 0 1 1 0 1 1 

        // startIdx = 0             0    1
        //     1                   m=0, n=1
        //     1 0                 m=1, n=1
        //     1 0 1               m=1, n=2
        //     1 0 1 1             m=1, n=3
        //     1 0 1 1 0           m=2, n=3
        //     1 0 1 1 0 1         m=2, n=4
        //     1 0 1 1 0 1 1       m=2, n=5
        // Max Len = (m=1, n=1) -> (1+1) = 2

        // startIdx = 1
        //     0                   m=1, n=0
        //     0 1                 m=1, n=1
        //     0 1 1               m=1, n=2
        //     0 1 1 0             m=2, n=2
        //     0 1 1 0 1           m=2, n=3
        //     0 1 1 0 1 1         m=2, n=4
        // Max Len = (m=2, n=2) -> (2+2) = 4

        // startIdx = 2
        //     1                   m=0, n=1
        //     1 1                 m=0, n=2
        //     1 1 0               m=1, n=2
        //     1 1 0 1             m=1, n=3
        //     1 1 0 1 1           m=1, n=4
        // Max Len = (Not Found)

        // startIdx = 3
        //     1                   m=0, n=1
        //     1 0                 m=1, n=1
        //     1 0 1               m=1, n=2
        //     1 0 1 1             m=1, n=3
        // Max Len = (m=1, n=1) -> (1+1) = 2

        // startIdx = 4
        //     0                   m=1, n=0
        //     0 1                 m=1, n=1
        //     0 1 1               m=1, n=2
        // Max Len = (m=1, n=1) -> (1+1) = 2
 
        // startIdx = 5
        //     1                   m=0, n=1
        //     1 1                 m=0, n=2
        // Max Len = (Not Found)

        // startIdx = 6
        //     1                   m=0, n=1
        // Max Len = (m=1, n=1) -> (1+1) = 2
    } 
}
