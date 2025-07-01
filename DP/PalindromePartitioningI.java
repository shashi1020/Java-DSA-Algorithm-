import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class PalindromePartitioningI {
    public static boolean isPalindrometable[][];
    public static int count;
    public static List<List<String>> partition(String s) {
        count=0;

        List<List<String>> res = new ArrayList<>();
         if (s == null || s.length() == 0) {
            return res;
        }
        int n = s.length();
        isPalindrometable = new boolean[n][n];
        // for length 1 palindromic substring 
        for(int i = 0; i<n; i++)
        {
            isPalindrometable[i][i] = true;
        }
        // for len 2 palindromic substring

        for(int i=0; i<n-1; i++)
        {
            if(s.charAt(i) == s.charAt(i+1))
            {
                isPalindrometable[i][i+1] = true;
            }

        }

        // for len 3 and more
        for(int length=3; length<=n; length++)
        {
            for(int i=0; i <= n-length; i++)
            {
                int j = i+length-1;

                if(s.charAt(i) == s.charAt(j) && s.charAt(i+1) == s.charAt(j-1))
                {
                    
                    isPalindrometable[i][j] = true;
                }
            }

        }

        return helper(s,0,res,new ArrayList<>());

    }

    public static List<List<String>> helper(String s, int start, List<List<String>> res,List<String> list)
    {
    
        if(start == s.length())
        {
            count++;
            res.add(new ArrayList<>(list));
            return res;
        }
        for(int i=start; i<s.length(); i++)
        {
            if(isPalindrome(s,start,i))
            {
                list.add(s.substring(start,i+1));
                helper(s, i+1, res, list);
                list.remove(list.size()-1);
                
               
            }
        }
        System.out.println(count);
        return res;
    } 

    public static boolean isPalindrome(String s, int left, int right)
    {  
        while(left<right)
        {
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;   
    }

    
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }
}
