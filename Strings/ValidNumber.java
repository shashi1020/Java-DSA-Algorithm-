import java.util.*;
public class ValidNumber {

    public static boolean isNumber(String s) {
        int sign = 1;
        s = s.trim();
    if(s.indexOf('e') != s.lastIndexOf('e') || s.indexOf('E') != s.lastIndexOf('E') || s.contains("e") && s.contains("E"))
    {
            return false;
    }

    String t[];
    if(s.contains("e"))
    {   
         t = s.split("e");
    }
    else if(s.contains("E"))
    {   
         t = s.split("E");
    }else {
        t = new String[]{s};
    }
    if (t.length == 0 || (t.length == 2 && (t[0].isEmpty() && t[1].isEmpty()))) {
    return false;
}

    if(!ValidDecimalOrInteger(t[0]))
    {
        return false;
    }
    if(t.length == 2 && !ValidInteger(t[1]))
    {
        return false;
    }  
    return true;
}
    public static boolean ValidInteger(String str)
    {
        if(str == null || str.isEmpty()) return false;
        if(str.charAt(0) == '+' || str.charAt(0) == '-') str = str.substring(1);
        return str.matches("[0-9]+");
    }
    public static boolean ValidDecimalOrInteger(String str)
    {
        if(str==null || str.isEmpty()) return false;
        if(str.charAt(0) == '+'|| str.charAt(0) == '-') str = str.substring(1);

        if(str.contains("."))
        {
            String[] parts = str.split("\\.",-1);
            if(parts.length!=2)
            {
                return false;
            }
            String left = parts[0];
            String right = parts[1];
            return (left.isEmpty() || left.matches("[0-9]+")) && (right.isEmpty() || right.matches("[0-9]+")) && !(left.isEmpty() && right.isEmpty());

        }else{
            return str.matches("[0-9]+");
        }

    }

    public static void main(String[] args) {
        String s = "0e";
        // System.out.println(isNumber(s));

         String t[];
    if(s.contains("e"))
    {   
         t = s.split("e",-1);
    }
    else if(s.contains("E"))
    {   
         t = s.split("E");
    }else {
        t = new String[]{s};
    }

    for(String a:t )
    {
        System.out.println(a);
    }
        

    
        
        
    }
}
