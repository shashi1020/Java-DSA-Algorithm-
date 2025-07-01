/* Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.
*/
import java.util.*;


public class HashwordPat{
    public static boolean wordPattern(String pattern, String s) {
        if(pattern.length()<s.length())
        {
            return false;
        }

        char pat[] = pattern.toCharArray();
        String str[] = s.split(" ");

        HashMap<Character,String> ps = new HashMap<>();
        HashMap<String,Character> sp = new HashMap<>();


       

        for(int i=0; i<pattern.length(); i++)
        {
            if(ps.containsKey(pat[i]))
            {
                if(!ps.get(pat[i]).equals(str[i]))
                {
                    return false;
                }
            }else{
                ps.put(pat[i],str[i]);
            }
            if(sp.containsKey(str[i]))
            {
                if(!sp.get(str[i]).equals(pat[i]))
                {
                    return false;
                }
            }else{
                sp.put(str[i],pat[i]);
            }
        }
        

       return true;
    }

    public static void main(String[] args) {
        String pattern = "abba";
        String s = "dog dog dog dog";
        System.out.println(wordPattern(pattern,s));
    }
}