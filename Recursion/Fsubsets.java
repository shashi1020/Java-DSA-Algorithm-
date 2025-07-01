public class Fsubsets{
    public static void findsubset(String str, String ans, int i)
    {
        if(i==str.length())
        {
            if(ans.length()==0)
            {
                System.out.println("NULL");
            }
            else{
           
                System.out.println(ans);
            }                return;
        }
        // for Yes choice 
        findsubset(str, ans+str.charAt(i), i+1);
        // FOR NO choice
        findsubset(str, ans, i+1);
    }
    
    public static void main(String[] args)
    {
        String str = "abc";
        String ans = "";
        findsubset( str,  ans,  0);
    }   
}