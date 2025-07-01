import java.util.*;
public class N_queens2 {
    public static List<List<String>> n_queens(char [][]Board, int row)
    {
        List<List<String>> Result = new ArrayList<>();
        if(row == Board.length)
        {
            List<String> list = new ArrayList<>();
            for(char a[]: Board)
            {
                list.add(new String(a));
            }
            Result.add(new ArrayList<>(list));
            return Result;
        }
        for(int j=0; j<Board.length; j++)
        {
            if(isSafe(Board,row,j))
            {
                Board[row][j] = 'Q';
                List<List<String>> partialList = new ArrayList<>();
                partialList = n_queens(Board, row+1);
                Result.addAll(partialList);
                Board[row][j] = '.';
            }
        }
        return Result;
    }
    public static boolean isSafe(char [][]Board, int row, int col)
    {
        // vertically up
        for(int i = row-1; i>=0;i--)
        {
            if(Board[i][col] == 'Q')
            {
                return false;
            }
        }
        // diagonally left up
        for(int i=row-1 , j = col-1; i>=0 && j>=0; i--, j--)
        {
             if(Board[i][j] == 'Q')
            {
                return false;
            }
        }
        // diagonally right up
        for(int i=row-1, j=col+1;i>=0 && j<Board.length; i--,j++)
        {
            if(Board[i][j] == 'Q')
            {
                return false;
            }
        }
        return true;
    }
   
    public static void printBoard(char Board[][]){
        System.out.println("Chess Board");
        for(int i=0; i<Board.length; i++)
        {
            for(int j=0; j<Board[0].length; j++)
            {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n=4;
        char [][]Board = new char[n][n];

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                Board[i][j] = '.';
            }
        }

        List<List<String>> res = n_queens(Board, 0);
        System.out.println(res);

        
        
    }
}
