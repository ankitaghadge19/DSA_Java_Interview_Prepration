package string.easy.finddifferenceofcharsintwostring;

public class Optimal {
    public static void main(String[] args) {
        String s = "abcde";
        String t = "abcd";

        // XOR
        // a ^ a = 0
        // a ^ 0 = a

        // = (a ^ b ^ c ^ d) ^ (a ^ b ^ c ^ d ^ e)
        // = (a ^ a) ^ (b ^ b) ^ (c ^ c) ^ (d ^ d) ^ e
        // =    0    ^    0    ^    0    ^    0    ^ e
        // = e

        // 0 ^ a = a
        char result = 0;

        // XOR all chars of s
        for (char ch : s.toCharArray()) {
            // XOR convert char into int and perform the operation and result will be int
            // Result of XOR is in int, cant directly converted into char so typecast it to char
            result = (char) (result ^ ch);
        }

        // XOR all chars of t
        for (char ch : t.toCharArray()) {
            result = (char) (result ^ ch);
        }
        System.out.println(result);
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/find-the-difference/description/