package string.easy.findindexoffirstoccurrenceinstring;

public class BruteForce2 {
    public static void main(String[] args) {
        // index 012345678
        String str = "sadbutsad"; // 9
        String goal = "sad"; // 3
        int n = goal.length();

        int s = 0;
        for (int e = 0; e < str.length(); e++) {
            if ((e - s + 1) == n) {
                String extractedStr = str.substring(s, e + 1);
                if (goal.equals(extractedStr)) {
                    System.out.println(s);
                }
                s++;
            }
        }
        System.out.println(-1);
    }
}

// N is length of str
// M is length of goal

// TC: O(N * M)
// SC: O(M) -> Extracted string from str

