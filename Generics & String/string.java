import java.util.*;
public class string {

    static void reverseString(String str)
    {
        StringBuilder sb = new StringBuilder(str);
       
         
        for(int i = 0; i<sb.length()/2; i++)
        {
            int front = i;
            int back = sb.length()-1-i;
            char frontChar = sb.charAt(i);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);  
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        // StringBuilder sb = new StringBuilder("Shashi");
        // System.out.println(sb);
        // sb.setCharAt(0, 'p');
        // System.out.println(sb);
        // sb.insert(0, 's');
        // System.out.println(sb);

        // sb.delete(1, 2);
        // System.out.println(sb);

        // sb.append("kant");
        // System.out.println(sb);

        // System.out.println(sb.length());
        String str = "bus";
        reverseString(str);
    }
}
