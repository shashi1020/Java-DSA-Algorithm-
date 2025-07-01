/*Description
224. Basic Calculator
Hard
Topics
Companies
Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.

Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().

  */

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class BasicCalculator {
    public static int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign =1;
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {
            char ch = s.charAt(i);

            if(Character.isWhitespace(ch))
            {
                continue;
            }
            if(Character.isDigit(ch))
            {
                num = num*10 + (ch-'0');
            }
            else if(ch=='+')
            {
                result += sign*num;
                num = 0;
                sign= 1;
            }else if(ch=='-')
            {
                result += sign*num;
                num = 0;
                sign = -1;
            }else if(ch=='(')
            {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;

            }else if(ch==')')
            {
                result +=  sign*num;
                num = 0;
                result *= stack.pop();
                result += stack.pop(); 
            }

        }
        result += sign * num;
       
    return result;


}
  
    public static void main(String[] args) {
        String expression = "";
        System.out.println(calculate(expression));
    }
}
