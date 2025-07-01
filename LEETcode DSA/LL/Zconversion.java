public class Zconversion {
   

        public static char[][] convert(String s, int numRows) {
            char[] arr = s.toCharArray();
            char [][]res = new char[numRows][s.length()];

            if(numRows==1)
            {
                int i = 0;
                for(int j=0; j<s.length(); j++)
                {
                    res[i][j] = arr[j];
                }
                return res;
            }
    
            int col=0;
            int row = 0;
            boolean goingDown = false;
    
            for(int i=0; i< arr.length; i++)
            {
                char currchar = arr[i];
                res[row][col] = currchar;
              

                if(row==0 || row==numRows-1){
                    goingDown = !goingDown;
                }
                if(goingDown)
                {
                    row++;
                }
                else{
                    row--;
                    col++;
                }
               
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<numRows; i++)
            {
                for(int j=0; j<res[i].length; i++)
                {
                    sb.append(res[i][j]);
                }
            }
            System.out.println(sb.toString());
            
            return res;
        }
    
        public static void printarr(char [][]arr)
        {
            for(int i=0; i<arr.length; i++)
            {
                for(int j=0; j<arr[i].length; j++)
                {
                    System.out.print(arr[i][j]);
                }
            }
        }
    
        public static void main(String[] args) {
            String s = "Shashikant";
            int numrows = 3;
            char[][] arr = convert(s,numrows);
        }
    }
    

