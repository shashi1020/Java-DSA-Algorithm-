import java.util.*;

public class SimplifyPath {

    public static String Simplify(String s)
    {
        String path[] = s.split("/");
        Stack<String> stack = new Stack<>();
        // stack.push("/");

        for(String cs : path)
        {
            if(cs.equals("") || cs.equals("."))
            {
                continue;
            }else if(cs.equals("..")){
                if(!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else{
                stack.push(cs);
            }
        }
        return "/"+String.join("/",stack);

    }
    public static void main(String[] args) {
        String path = "/home/user/shilp/.././";
        System.out.println(Simplify(path));


    }
}
