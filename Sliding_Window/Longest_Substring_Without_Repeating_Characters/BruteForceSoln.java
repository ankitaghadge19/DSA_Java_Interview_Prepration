package Longest_Substring_Without_Repeating_Characters;

import java.util.HashSet;
import java.util.Set;

class BruteForceSoln{
    public static void main(String[] args) {
        String s = "abcdefg";

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
                j++;
            }else{
                i=i+1;
                j=i;
                if(temp.size() > result){
                    result = temp.size();
                }
                temp.clear();
            }
        }
        if(temp.size() > result){
            result = temp.size();
        }
        System.out.println(result);
    }
}