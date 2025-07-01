public class sudokuSolver {
    private static boolean solved = false;
   
    public static void solveSudoku(char[][] board) {

        solved = false;
       backtrack(board);  
    }

    public static void backtrack(char[][] board){
        if(solved) return;

         for(int i=0; i<9; i++)
        {
            for(int j=0; j<9; j++)
            {
                if(board[i][j] == '.')
                {
                    for(char c='1'; c<='9'; c++)
                    {
                       if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            backtrack(board);
                            if(solved) return;
                            board[i][j] = '.';
                        }
                    }
                    return; //if no valid char found
                }
            }
        }
        solved = true; //if all cells filled without returning
    }
    
    public static boolean isValid(char[][] board, int row, int col, char num)
    {
        for(int i=0; i<9; i++)
        {
            if(board[i][col] == num || board[row][i] == num)
            {
                return false;
            }
        }
        int boxRow = 3*(row/3);
        int boxCol = 3*(col/3);

        for(int i=boxRow; i<boxRow+3; i++)
        {
            for(int j=boxCol; j<boxCol+3; j++)
            {
                if(board[i][j] == num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char [][]board = {{'5','3','4','6','7','8','9','1','2'},
        {'6','7','2','1','9','5','3','4','8'},
        {'1','9','8','3','4','2','5','6','7'},
        {'8','5','9','7','6','1','4','2','3'},
        {'4','2','6','8','5','3','7','9','1'},
        {'7','1','3','9','2','4','8','5','6'},
        {'9','6','1','5','3','7','2','8','4'},
        {'2','8','7','4','1','9','6','3','5'},
        {'3','4','5','2','8','6','1','7','9'}};

        solveSudoku(board);
       
        
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }



    }
}
