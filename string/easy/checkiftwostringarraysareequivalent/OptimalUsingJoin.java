package string.easy.checkiftwostringarraysareequivalent;

public class OptimalUsingJoin {
    public static void main(String[] args) {
        String[] word1 = { "ab", "c" };
        String[] word2 = { "a", "bc" };

        String combineWord1 = String.join("", word1);
        String combineWord2 = String.join("", word2);

        System.out.println(combineWord1.equals(combineWord2));
    }
}

// Goal: Check if both arrays produce same string when all their elements are joined together

// Problem Link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

// N length of word1
// M length of word2
// TC: O(M + N)
// SC: O(M + N)