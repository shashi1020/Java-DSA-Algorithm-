/*
 * 32. Longest Valid Parentheses
Attempted
Hard
Topics
Companies
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses 
substring
.
 */


import java.util.Stack;
public class LongestValidPara {
    
    public static int lengOflongvalidpara(String s)
    {
        int count = 0;
        int maxLen = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        char[] para = s.toCharArray();
        for(int i = 0; i<para.length; i++)
        {
            if(para[i]=='(')
            {
                stack.push(i);
            }
            else 
            {
              System.out.println(stack.pop());
               System.out.println(!stack.isEmpty());

               if(!stack.isEmpty())
               {
                
                count = i- stack.peek();
                if(count>maxLen)
                {
                 maxLen = count;
                }
               }else{
                stack.push(i);
                System.out.println(i);
            }
        }
    
    }
          

        return maxLen;
    }
    public static void main(String[] args) {
        String para = ")()())";
        //   
        System.out.println(lengOflongvalidpara(para));
    }
}
