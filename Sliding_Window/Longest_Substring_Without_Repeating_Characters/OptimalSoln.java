import java.util.HashSet;
import java.util.Set;

public class OptimalSoln {
    public static void main(String[] args) {
        String s = "abccaccd";
        if(s.length()<2){
            System.out.println(0);
        }

        int result = 0;
        int i=0;
        int j=0;
        int n = s.length();
        Set<Character> temp = new HashSet<>();
        while(i<n && j<n){
            char currentChar = s.charAt(j);
            if(!temp.contains(currentChar)){
                temp.add(currentChar);
                result = Math.max(temp.size(), result);
                j++;
            }else{
                temp.remove(s.charAt(i));
                i++;
            }
        }
        System.out.println(result);

        // Problem Link: https://leetcode.com/problems/longest-substring-without-repeating-characters
    }
}
