package string.easy.checkifgoalstringcanbeformedbyrotatinginpustring;

public class Optimal {
    public static void main(String[] args) {
        String str = "abcde";
        String goal = "abcde";

        // Eg. str = "abc", goal = "ab"
        // Only (str + str).conatins(goal) will return true but expected is false
        if (str.length() != goal.length()) {
            System.out.println(false);
        }
        
        String concatenatedStr = str + str;
        if (concatenatedStr.contains(goal)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

// Note: If one string is rotation of another,
// then it will always appear inside original string conacatenated with itself