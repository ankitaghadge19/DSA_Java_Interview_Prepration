package arrays.easy.secondlargestelement;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 4, 7, 7, 5 };

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > largest) {
                secondLargest = largest;  // [2, 5]
                largest = nums[i];
            } else if (nums[i] < largest && nums[i] > secondLargest) {
                secondLargest = nums[i];
            }
        }
        System.out.println(largest + ", " + secondLargest);
    }
}

// TC: O(N)
// SC: O(1)