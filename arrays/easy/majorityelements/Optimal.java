package arrays.easy.majorityelements;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
        int n = nums.length;

        int num = 0;
        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq == 0) {
                num = nums[i];
                freq = 1;
            } else {
                if (nums[i] == num) {
                    freq++;
                } else {
                    freq--;
                }
            }
        }
        System.out.println(num);
    }
}

// TC: O(N)
// SC: O(N)
// Problem Link: https://leetcode.com/problems/majority-element


// Explanation:
// A majority element appears more than n/2 times.
// More than half of the array is consumed by majority element.
// So even if we cancel out one majority element with one non-majority element, the majority element will still remain in the end.