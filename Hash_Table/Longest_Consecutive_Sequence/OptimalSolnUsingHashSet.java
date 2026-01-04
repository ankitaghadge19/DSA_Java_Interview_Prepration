package Longest_Consecutive_Sequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class OptimalSolnUsingHashSet {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2,4,100};
        int result = longestConsecutiveSequence(nums);
        System.out.println(result);
    }

    private static int longestConsecutiveSequence(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
            set.add(num);
        }

        int longest = 0;
        for(int num: set){
            if(!set.contains(num-1)){
                int current = num;
                int count = 1;

                while(set.contains(current+1)){
                    current++;
                    count++;
                }
                longest = Math.max(count, longest);  
            }
        }
        return longest;

        // Dry Run

        // Idx  0 1 2  3  4  5  
        // Eg.  2 3 1 100 4 101 

        // i=0, nums[0]=2, set.contains(2-1) -> continue;

        // i=1, nums[1]=3, set.contains(3-1) -> continue;

        // i=2, nums[2]=1, set.contains(1-1)               -> len=1, current=1
        //                 set.contains((current+1)=1+1=2) -> len=2, current=2
        //                 set.contains((current+1)=2+1=3) -> len=3, current=3
        //                 set.contains((current+1)=3+1=4) -> len=4, current=4
        //                 count=4, longest=4;
        //                 count=0;

        // i=3, nums[3]=100, set.contains(100-1)                 -> len=1, current=100
        //                   set.contains((current+1)=100+1=101) -> len=2, current=101
        //                   count=2, longest=4; (longest>count -> longest Not Updated)
        //                   count=0;
        
        // i=4, nums[4]=4, set.contains(4-1) -> continue;

        // i=5, nums[5]=101, set.contains(101-1) -> continue;

        // i=6; (i>nums.length) -> break;
        
        // Total No of Iterations: 10 (2n)

        // Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/
    }
}
