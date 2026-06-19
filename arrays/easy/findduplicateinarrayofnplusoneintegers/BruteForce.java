package arrays.easy.findduplicateinarrayofnplusoneintegers;

public class BruteForce {
    public static void main() {
        int[] nums = { 1, 3, 4, 2, 2 };
        for (int i = 0; i < nums.length; i++) {
            int cnt = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    cnt++;
                }
            }
            if (cnt == 2) {
                System.out.println(nums[i]);
            }
        }
    }
}

// TC: O(N^2)
// SC: O(1)

// Note: When you are checking weather arr[i] is duplicated, there is no need to compare it with elements before i because those comparisons have already been done

//Eg.
// arr = [1, 3, 2, 2]
// Index  0  1  2  3
// If you check the entire array every time

// For i = 0 (value = 1)

// 1 vs 1
// 1 vs 3
// 1 vs 2
// 1 vs 2

// For i = 1 (value = 3)

// 3 vs 1
// 3 vs 3
// 3 vs 2
// 3 vs 2

// Notice something?

// 1 vs 3
// was already checked.
// Now you're checking:
// 3 vs 1

// which is the same comparison again.

// -> Instead, start from the next index

// For i = 0 (value = 1)

// 1 vs 3
// 1 vs 2
// 1 vs 2

// For i = 1 (value = 3)

// 3 vs 2
// 3 vs 2

// For i = 2 (value = 2)

// 2 vs 2   ← Duplicate found

// Now every pair is checked only once.