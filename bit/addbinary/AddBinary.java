package bit.addbinary;
public class AddBinary {
    public static void main() {
        String a = "11";
        String b = "1";

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder result = new StringBuilder();

        while (i >= 0 || j >= 0 || carry == 1) {
            int num1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int num2 = j >= 0 ? b.charAt(j) - '0' : 0;

            // Calculate sum
            int sum = num1 ^ num2 ^ carry;

            // Calculate carry
            carry = (num1 & num2) | (num1 & carry) | (num2 & carry);
            // carry will be 1 when atleast when group is (1 & 1)

            result.append(sum);
            i--;
            j--;
        }
        System.out.println(result.reverse().toString());
    }
}

// Problem Link: https://leetcode.com/problems/add-binary

// '0' → ASCII 48
// '1' → ASCII 49