package array.medium.findrepeatingandmissingnumberfromarrayofonetonelements;

import java.util.ArrayList;

public class Optimal {
    public static void main() {
        int[] nums = { 4, 3, 6, 2, 1, 1 };
        int n = nums.length;

        // [Repeting, Missing]
        ArrayList<Integer> result = new ArrayList<>();

        long sumOf1ToN = ((long) n * (n + 1)) / 2;
        long sumOfSquareOf1ToN = ((long) n * (n + 1) * ((2 * n) + 1)) / 6;

        long sumOfArrNums = 0;
        long sumOfSquareOfArrNums = (long) 0;
        for (int i = 0; i < n; i++) {
            sumOfArrNums = sumOfArrNums + nums[i];
            sumOfSquareOfArrNums = sumOfSquareOfArrNums + ((long) nums[i] * nums[i]);
        }

        // x -> repeting, y -> missing
        long val1 = sumOfArrNums - sumOf1ToN; // (x - y)
        long val2 = sumOfSquareOfArrNums - sumOfSquareOf1ToN; // (x^2 - y^2) = (x + y) (x - y)
        long val3 = val2 / val1; // (x + y)
        long repeting = (val1 + val3) / 2; // (x + y) + (x - y)
        long missing = val3 - repeting;

        result.add((int) repeting);
        result.add((int) missing);

        System.out.println(result);
    }
}

// TC: O(N)
// SC: O(1)
// Problem Link: https://www.geeksforgeeks.org/problems/find-missing-and-repeating2512/1

// ((long) n * (n + 1)) interanlly equlas to ((long) n * (long) (n + 1))


// Eg. [4 3 6 2 1 1], n = 6
// Note: If array size is 6, it will only conatins 1 to n elements, and out of that one will be repeting and one will be missing
// Ans: repeting = 1, missing = 5

// Sum of 1st N natural numbers = (n*(n + 1))/2
// Sum of square of 1st N natural numbers = (n*(n + 1)*(2n + 1))/6
// let, x = repeting, y = missing

// 1st Equation:
// = (Sum of all array elements) - (Sum of 1st n natural numbers)
// = (4 + 3 + 6 + 2 + 1 + 1) - (1 + 2 + 3 + 4 + 5 + 6)
// = 1 - 5  ...equivalent to (repeting - missing )
// = -4
// So, x - y = -4 ----(1)

// 2nd Equation:
// = (Sum of square of all array elements) - (Sum of square of 1st n natural numbers)
// = (4^2 + 3^2 + 6^2 + 2^2 + 1^2 + 1^2) - (1^2 + 2^2 + 3^2 + 4^2 + 5^2 + 6^2)
// = 1^2 - 5^2  ...equivalent to (repeting square - missing square)
// = 1 - 25 = -24
// So, x^2 - y^2 = -24 ----(2)
//     x^2 - y^2 = (x + y) (x - y)
//     (x + y)(x - y) = -24 ----(3)

//     (x + y) (-4) = -24 ---- From (1)
//     x + y = -24/-4 = 6
//     x + y = 6 ----(4)

//     x - y = -4   ----From (1)
//     x + y = 6    ----From (4)
//     Add equation (1) and (4)
//     (x - y) + (x + y) = -4 + 6
//     2x = 2
//     x = 1    ----(Repeting Number)

//    Put x = 1 in equation (4)
//    x + y = 6
//    1 + y = 6
//    y = 6 - 1 = 5
//    y = 5    ----(Missing Number)

// Hence, x = 1 and Y = 5