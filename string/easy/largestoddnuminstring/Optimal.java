public class Optimal {
    public static void main(String[] args) {
        String num = "7542351161";

        for (int i = num.length() - 1; i >= 0; i--) {
            char ch = num.charAt(i);
            if (Character.getNumericValue(ch) % 2 != 0) {
                System.out.println(num.substring(0, i + 1));
                break;
            }
        }
        System.out.println("");
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/largest-odd-number-in-string/description/

// Approach: 
// 1. A number is odd if its last digit is odd (1, 3, 5, 7, 9).
// 2. Scan the string from right to left.
// 3. Find the rightmost odd digit.
// 4. Take the entire string from the beginning up to that digit.
// 5. This gives us the largest possible odd number.
// 6. No need to traverse further once we find the rightmost odd digit,
//    because even if we find another odd digit while traversing further,
//    the number formed will be smaller than the one we found earlier.