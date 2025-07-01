class PalindromePartitioningII{

     boolean [][]isPalindrome;
    public int minCut(String s) {
        
        int n = s.length();
        isPalindrome= new boolean[n][n];

        for(int i=0; i<n; i++)
        {
            isPalindrome[i][i] = true;
        }

        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                isPalindrome[i][i+1] = true;
            }
        }

        // for more than len 3 or 3
        for(int length=3; length<=n;length++)
        {
            for(int i=0; i<n-length; i++)
            {
                // end index
                int j=i+length-1;
                // start index will be i so 
                if(s.charAt(i) == s.charAt(j) && s.charAt(i+1) == s.charAt(j-1))
                {
                     isPalindrome[i][j] = true;
                }
            }
        }
        


    }

   
    public static void main(String[] args) {
        
    }
}