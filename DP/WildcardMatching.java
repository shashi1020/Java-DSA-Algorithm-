/*44. Wildcard Matching
Hard
Topics
Companies
Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
The matching should cover the entire input string (not partial) */
public class WildcardMatching{

    public static boolean isMatch(String s, String p) {

        boolean [][]T = new boolean[s.length()+1][p.length()+1];
        T[0][0] = true;

        for(int j=1; j<=p.length(); j++)
        {
           if(p.charAt(j-1)=='*' && j>=2)
           {
                T[0][j] = T[0][j-2];
           }  
        }

        for(int i=1; i<=s.length(); i++)
        {
            for(int j=1; j<=p.length(); j++)
            {
                char sch = s.charAt(i-1);
                char pch = p.charAt(j-1);

                if(pch=='?' || pch == sch)
                {
                    T[i][j] = T[i-1][j-1];
                }else if(pch=='*'){

                    
                        T[i][j] = T[i][j-1]||T[i-1][j];
                  
                }


            }
        }
        return T[s.length()][p.length()];
    }
     
    public static void main(String[] args) {
        String s = "aaab";
        String p = "a*c*b";
        System.out.println(isMatch(s,p));

    }
}