// import java.util.*;
public class isSubsequence {
    
        public static boolean isSubsequenceofString(String s, String t) {
            // StringBuilder sb = new StringBuilder(t);
            char arr[] = new char[s.length()];
            int j=0;
            for(int i=0; i<t.length(); i++)
            {
                if(j < s.length() && t.charAt(i) == s.charAt(j))
                {
                    arr[j++] = t.charAt(i);
                }
            }
            String result = new String(arr);
            if(result.equals(s))
            {
                return true;
            }
            return false;
        }
        public static void main(String[] args)
        {
            String s = "abc";
            String t = "ahbdc";
            System.out.println(isSubsequenceofString(s,t)); 

        }
    }

