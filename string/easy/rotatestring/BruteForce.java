package string.easy.rotatestring;

public class BruteForce {
    public static void main(String[] args) {
        String str = "abcde";
        String goal = "abcde";

        // Rotations
        // 1 -> eabcd
        // 2 -> deabc
        // 3 -> cdeab
        // 4 -> bcdea
        // 5 -> abcde -> Same as str

        boolean isGoalRotationOfStr = false;
        
        if (str.equals(goal)) {
            isGoalRotationOfStr = true;
        }

        // Convert string into array
        char[] arr = str.toCharArray();
        int n = arr.length;

        // Rotate string n-1 times, why not n times coz last iteration will return same as input string
        // Each iteration rotates string by 1 position
        for (int j = 0; j < n-1; j++) {
            // Store last character
            char last = arr[n - 1];
            
            // Shift all charaters one position to the right, shifting start from last index of string
            for (int i = n - 1; i >= 0; i--) {
                // Put the last character at the fisrt position
                if (i == 0) {
                    arr[i] = last;
                } else {
                    arr[i] = arr[i - 1];
                }
            }

            // Check if rotated string is equal to goal
            String rotatedString = new String(arr);
            if (rotatedString.equals(goal)) {
                isGoalRotationOfStr = true;
                break;
            }
        }
        System.out.println(isGoalRotationOfStr);
    }
}

// TC: O(N^2) -> Rotataing n-1 times and each rotation shift words to the right
// SC: O(N) -> Array used to store string chars