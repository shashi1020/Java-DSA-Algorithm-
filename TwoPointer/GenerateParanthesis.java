import java.util.ArrayList;
import java.util.List;


public class GenerateParanthesis {
    public static List<String> generate(String output, int open , int close, int n, List<String>list)
    {
        
        if(open == n && close == n)
        {
            list.add(output);

        }
        if(open < n)
        {
            generate(output+"(",open+1, close, n, list);
        }
        if(close < open)
        {
            generate(output+")",open, close+1, n, list);
        }
        
        return list;
    }
    
    public static List<String> generateParenthesis(int n) {
        List<String> list= new ArrayList<>(); 
    list = generate("", 0, 0, n, list );
        
    
    
        
     
        return list;

    }

    public static void main(String[] args) {
        int n = 2;
       List<String> list =  generateParenthesis(n);
       System.out.println(list);
    }
}
