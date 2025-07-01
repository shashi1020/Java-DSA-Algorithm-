import java.util.*;

class ValidParanthesis{
    public boolean isValid(String s) {
        if(s.charAt(0) == ']' || s.charAt(0)==')' ||s.charAt(0)=='}')
        {
            return false;
        }
        Stack<Character> stack = new Stack();
        int n=s.length();

        HashMap<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        for(int i=0; i<n; i++)
        {

            if(s.charAt(i) == '('|| s.charAt(i)=='[' || s.charAt(i)=='{')
            {
               
                stack.push(s.charAt(i));
            }else{
                if(map.containsKey(s.charAt(i)))
                {
                    if(!stack.isEmpty() &&stack.peek() == map.get(s.charAt(i)))
                    {
                        stack.pop();
                    }else{
                    return false;
                }
                }
                
               
            }
        }
        return stack.isEmpty();
    }
}