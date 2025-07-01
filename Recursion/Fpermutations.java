import java.util.*;

public class Fpermutations {
    public static void findPermuation(String str, String ans)
    {
        if(str.length() == 0)
        {
            System.out.println(ans);
            return;
        }
        for(int i=0;i<str.length(); i++)
        {
          char curr = str.charAt(i); 
          String NewStr = str.substring(0, i)+str.substring(i+1);
          findPermuation(NewStr, ans+curr); 
          System.out.println(i+"="+ans+curr);
          
        }
    }

    // in-place swapping
    public static List<String> findPermutation2(String s){
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder(s);

        recurPermute(0,sb,res);
        Collections.sort(res);
        return res;

    }
    public static void recurPermute(int index, StringBuilder str, List<String> ans){ 

        if(index==str.length())
        {
            ans.add(str.toString());
            return;
        }
        for(int i=index; i<str.length(); i++)
        {
            Swap(str, index, i);
            System.out.println(index + "," + i);
            System.out.println(str);

            recurPermute(index+1, str, ans);
            System.out.println( " backtracking: " + index + "," + i);
            System.out.println(str);
            Swap(str, index, i);
        }
    }
   public static void Swap(StringBuilder sb, int i, int j)
    {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }


    public static void main(String[] args) {
        String str = "abc";
        System.out.println(findPermutation2(str));
    }
}
