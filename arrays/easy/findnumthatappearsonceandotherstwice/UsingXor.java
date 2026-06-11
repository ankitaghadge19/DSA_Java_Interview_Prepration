package arrays.easy.findnumthatappearsonceandotherstwice;

public class UsingXor {
    public static void main() {
        int[] nums = { 4, 1, 2, 1, 2 };

        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        System.out.println(xor);
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/single-number/description/

// Approach:

// XOR Truth Table

// A   b  A^B
// 0   0   0
// 0   1   1
// 1   0   1
// 1   1   0

// 8  4  2  1 -> Binary Representation
// 0  0  1  0 -> 2

// 2 ^ 2 =
//   0   0  1  0
//   0   0  1  0 (XOR)
//-> 0   0  0  0

// (1 ^ 1) ^ (2 ^ 2) ^ 4 = 0 ^ 0 ^ 4 = 4

// nums = [4, 1, 2, 1, 2]
// xor = 0
// xor = 0 ^ 4 = 4
// xor = 4 ^ 1 = 5
// xor = 5 ^ 2 = 7
// xor = 7 ^ 1 = 6
// xor = 6 ^ 2 = 4
// Answer = 4

// XOR is both Commutative and Associative 
// Commutative: a ^ b = b ^ a
// Associative: a ^ (b ^ c) = (a ^ b) ^ c

// Q: Every number apperas twice, except which apperas once
// XOR has property that number XOR itself is 0
// If we XOR all elements of the array, then all duplicate elements will cancel out and will get the number which appear only once