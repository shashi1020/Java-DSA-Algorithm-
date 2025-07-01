public class N_Queens {
    
    public static  boolean N_queen(char Board[][], int row)
    {
        if(row == Board.length)
        {
            printBoard(Board);
            count++;
            return true;
        }
        for(int j = 0; j < Board.length; j++)
        {
        if(isSafe(Board, row, j))
        {
            Board[row][j] = 'Q';
            
            if(N_queen(Board, row+1))
            {
                return true;
            }

            Board[row][j] = 'X';        
        }
        }
        return false;
       
    }

    public static boolean isSafe(char Board[][], int row, int col)
    {
        // verticalliy up
        for(int i = row - 1; i>=0; i--)
        {
                if(Board[i][col] == 'Q')
                {
                    return false;
                }
        }
        // diagonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--)
        {
            if(Board[i][j] == 'Q')
            {
                return false;
            }
        }
        // diagonal Right up
        for(int i=row-1, j=col+1; i>=0 && j<Board.length; i--, j++)
        {
            if(Board[i][j] == 'Q')
            {
                return false;
            }
        }
        return true;
    }

    public static void printBoard(char Board[][])
    {
        
        System.out.println("__________Chess Board___________");
        for(int i=0; i<Board.length; i++)
        {
            for(int j=0; j<Board.length; j++)
            {
                System.out.print(Board[i][j] + " ");
           
            }
            System.out.println();
        }
    }

    static int count = 0;
    public static void main(String[] args) {

        int n = 4;
        char Board[][] = new char[n][n];
        for(int i=0; i<n; i++)
        {
            for(int j=0;j<n; j++)
            {
                Board[i][j] = 'X';
            }
        }
        if(N_queen(Board, 0))
        {
            System.out.println(" Soln is psbl");
        }
        else{
            System.out.println("not possible");
        }
        System.out.println("total ways to solve " + count);   
    }
    
}
