package string.easy.reversestring;

public class Optimal {
    static void main() {
        String str = "abcd";
        char[] arr = str.toCharArray();

        int start = 0;
        int end = str.length() - 1;
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        System.out.println(new String(arr));
    }
}

// TC: O(N)
// SC: O(1)

// Problem Link: https://leetcode.com/problems/reverse-string/description/