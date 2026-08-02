package arrays.medium.maxsumsubarray;

public class Optimal {
    public static void main() {
        int[] nums = { -2, -4, -6, -8, -1, -3  };

        int left = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            left = left + nums[i];

            maxSum = Math.max(maxSum, left);

            left = left < 0 ? 0 : left;
        }
        System.out.println(maxSum);
    }
}


// Approach:

// All positive elements -> Max sum will be sum of all array elements
 
// Eg. [ 2, 3, 5, -2, 7, -4 ] (Target is present at the beginning)

//   Calculate Sum:
//   Left -> Right            Right -> Left             Max
//   2                        -4 = -4 -> 0              2                
//   2+3 = 5                   7 = 7                    max(5, 7, 2) = 7
//   2+3+5 = 10                7-2 = 5                  5
//   2+3+5-2 = 8               7-2+5 = 10               10
//   2+3+5-2+7 = 15            7-2+5+3 = 13             15
//   2+3+5-2+7-4 = 11          7-2+5+3+2 = 15           15
// Max sum subarray = 15

// Q) Why to calculate sum from right to left?
// Eg. [ -2, -4, 2, 3, 5 ] (Target is present at the end)
// If we travel only from Left to Right then we will not get the max sum subarray

//   Calculate Sum:
//   Left -> Right            Right -> Left             Max
//   -2 = -2 -> 0             5                         5               
//   -4 = -4 -> 0             5+3 = 8                   8
//    2 = 2                   5+3+2 = 10                10
//    2+3 = 5                 5+3+2-4 = 6               10
//    2+3+5 = 10              5+3+2-4-2 = 4             10
// Max sum subarray = 10
// *Note*: No need to travle from Right -> Left, reseting sum to 0 when it becomes negative handle this case when target is at the end

// Calculate Sum Left to Right and (Right to Left -> No need to handle this, already hanled by sum reset to 0 case)
// Maintain running sum to track max sum found so far
// This will handle scenario when target is present at beginning or at the end
// But what is target is in the middle
// So, reset the running sum to 0 when it becomes negative
// Carrying negative sum will only reduce the sum of next subarray
// So reset sum to 0 and consider subarray starts from current element and keep adding next elements            

// ***Final Approach***:
// Calculate Sum Left to Right, Traverse Left to Right
// Keep running sum
// Update the max sum
// Reset running sum to 0 when sum becomes negative

// Special Case:
// [-2, -4, 6, 8, -1, -3] (Target is in the middle)
// Calculate Sum:
//   Left -> Right        Max
//   -2 = -2 -> 0         0
//   -2-4 = -6 -> 0       0
//    6 = 6               6
//    6+8 = 14            14
//    6+8-1=13            14
//    6+8-1-3=10          14
// Max sum subarray = 14

// Q) What if the array has all negative numbers?
//
// In this case, adding more negative elements will only decrease the sum.
// So, there is no need to check subarrays coz every time we add another negative element, the running sum becomes smaller
// We simply compare each element one by one.
// The least negative (largest) element will be the maximum subarray sum.
//
// Therefore:
// 1. First, add the current element to the running sum.
// 2. Compare the current sum with maxSum and update maxSum if needed.
// 3. If the current sum becomes negative, reset it to 0.