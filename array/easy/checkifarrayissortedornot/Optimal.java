package array.easy.checkifarrayissortedornot;

public class Optimal {
    public static void main(String[] args) {
        int[] nums = { 5, 4, 6, 7, 8 };
        int n = 5;

        boolean isSorted = true;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                isSorted = false;
                break;
            }
        }
        System.out.println(isSorted);
    }
}

// TC: O(N)
// SC: O(1)

// Approach:
// Traverse the array.
// At each index, check whether the current element is greater than the next element.
// If it is, the array is not sorted, so return false.
// A sorted array should have every element less than or equal to its next element.