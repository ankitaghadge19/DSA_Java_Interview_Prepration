package string.easy.intersectionoftwoarrays;

import java.util.HashSet;
import java.util.Set;

public class Optimal {
    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };

        Set<Integer> count = new HashSet<>();
        Set<Integer> result = new HashSet<>();

        // Store all unique elements from nums1
        for (int num : nums1) {
            count.add(num);
        }

        // find common elements
        for (int num : nums2) {
            if (count.contains(num)) {
                result.add(num);
            }
        }
        System.out.println(result);
    }
}

// TC: O(N + M)
// N -> Adding nums1 to HashSet
// M -> Travesring nums2

// SC: (N + K)
// N -> No of elements stored from nums1
// K -> Common elements found from nums1 and nums2

// Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/description/