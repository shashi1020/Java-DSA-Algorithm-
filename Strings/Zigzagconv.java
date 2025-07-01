class Zigzagconv{
    public static String convert(String s, int numRows) {
        if(numRows==0 || s.length()==0)
        {
            return s;
        }

        char arr[] = s.toCharArray();
        StringBuilder rows[] = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++)
        {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        boolean goingDown = false;

        for(int i=0; i<arr.length; i++)
        {
           rows[row].append(arr[i]);
           if(row == 0 || row==numRows-1)
           {
                goingDown = !goingDown;
           }
           if(goingDown)
           {
            row++;
           }else{
            row--;
           }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<numRows; i++)
        {
            sb.append(rows[i]);
        }


        return sb.toString();
    }

    public static void main(String []args)
    {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
    }
}