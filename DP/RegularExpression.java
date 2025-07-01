public class RegularExpression {
    public static boolean isMatch(String s, String p) {
        // Initialize DP table with dimensions (s.length() + 1) x (p.length() + 1)
        boolean [][]t = new boolean[s.length()+1][p.length()+1];
        t[0][0] = true;

        for(int j=1; j<=p.length(); j++)
        {
            if(p.charAt(j-1)=='*')
            {
                t[0][j] = t[0][j-2];
            }
        }

        for(int i =1; i<=s.length(); i++)
        {
            for(int j=1; j<=p.length(); j++)
            {
                char schar = s.charAt(i-1);
                char pchar = p.charAt(j-1);
               

                if(schar== pchar || pchar == '.')
                {   
                    t[i][j] = t[i-1][j-1];
                }else if(pchar == '*')
                {
                    t[i][j] = t[i][j-2];
                    if(schar == p.charAt(j-2) || p.charAt(j-2) == '.')
                    {
                        t[i][j] = t[i][j] || t[i-1][j];
                    }
                }
            }
            System.out.println();
        }
        return t[s.length()][p.length()];
    }

    public static void main(String[] args) {
        String s = "aaaab";
        String p = "a*b";
        System.out.println(isMatch(s, p));  // Output: true
    }
}
