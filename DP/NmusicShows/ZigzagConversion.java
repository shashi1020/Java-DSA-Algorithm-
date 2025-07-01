// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R

import java.util.Arrays;

class ZigzagConversion{

    public static String convert(String s, int numRows) {
        if(s.length()==1||numRows==1)
        {
            return s;
        }

        int flag = 1;
        int row = 0;
        int col = 0;

        char pattern[][] = new char[numRows][];

        for(int i=0; i<s.length(); i++)
        {
            if(row<numRows && flag==1)
            {
                pattern[row][col] = s.charAt(i);
                System.out.println(pattern[row][col]);
                row++;
            }
        }
    
    
        return s;
    }

    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
}