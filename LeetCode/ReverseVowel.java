import java.util.*;
public class ReverseVowel {
    public static String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
       
        while (start < end) {
            
            while (start < end && !vowels.contains(chars[start])) {
                start++;
            }
            
            while (start < end && !vowels.contains(chars[end])) {
                end--;
            }
           
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
          
            start++;
            end--;
        }
        
        
        return new String(chars);
    }

    public static void main(String[] args) {
       
        String s1 = "hello";
        String s2 = "leetcode";
        System.out.println(reverseVowels(s1)); 
        System.out.println(reverseVowels(s2)); 
    }
}

