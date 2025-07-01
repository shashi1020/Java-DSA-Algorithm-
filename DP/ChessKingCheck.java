import java.util.*;

public class ChessKingCheck {
    static int[][] rookDirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] bishopDirs = {{1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static int[][] queenDirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static int[][] kingDirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    static int[][] knightMoves = {{2, 1}, {2, -1}, {-2, 1}, {-2, -1}, {1, 2}, {1, -2}, {-1, 2}, {-1, -2}};
    static int[][] pawnWhite = {{-1, -1}, {-1, 1}};
    static int[][] pawnBlack = {{1, -1}, {1, 1}};
    
    public static boolean isUnderAttack(char[][] board, int x, int y, char piece) {
        for (int[] move : knightMoves) {
            int nx = x + move[0], ny = y + move[1];
            if (isValid(nx, ny) && board[nx][ny] == (piece == 'K' ? 'n' : 'N')) return true;
        }
        
        for (int[] move : kingDirs) {
            int nx = x + move[0], ny = y + move[1];
            if (isValid(nx, ny) && board[nx][ny] == (piece == 'K' ? 'k' : 'K')) return true;
        }
        
        if (checkSlidingPieces(board, x, y, piece, rookDirs, 'r', 'q')) return true;
        if (checkSlidingPieces(board, x, y, piece, bishopDirs, 'b', 'q')) return true;
        
        int[][] pawnMoves = piece == 'K' ? pawnBlack : pawnWhite;
        for (int[] move : pawnMoves) {
            int nx = x + move[0], ny = y + move[1];
            if (isValid(nx, ny) && board[nx][ny] == (piece == 'K' ? 'p' : 'P')) return true;
        }
        
        return false;
    }
    
    public static boolean checkSlidingPieces(char[][] board, int x, int y, char piece, int[][] directions, char singlePiece, char queenPiece) {
        for (int[] dir : directions) {
            int nx = x, ny = y;
            while (true) {
                nx += dir[0]; ny += dir[1];
                if (!isValid(nx, ny)) break;
                if (board[nx][ny] == (piece == 'K' ? singlePiece : Character.toUpperCase(singlePiece)) ||
                    board[nx][ny] == (piece == 'K' ? queenPiece : Character.toUpperCase(queenPiece))) return true;
                if (board[nx][ny] != '.') break;
            }
        }
        return false;
    }
    
    public static boolean isValid(int x, int y) {
        return x >= 0 && x < 8 && y >= 0 && y < 8;
    }
    
    public static int[] findKing(char[][] board, char king) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == king) return new int[]{i, j};
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gameNum = 1;
        
        while (scanner.hasNextLine()) {
            char[][] board = new char[8][8];
            boolean emptyBoard = true;
            
            for (int i = 0; i < 8; i++) {
                String line = scanner.nextLine();
                if (line.isEmpty()) return;
                board[i] = line.toCharArray();
                if (!line.equals("........")) emptyBoard = false;
            }
            
            if (emptyBoard) break;
            if (scanner.hasNextLine()) scanner.nextLine();
            
            int[] whiteKing = findKing(board, 'K');
            int[] blackKing = findKing(board, 'k');
            
            if (isUnderAttack(board, whiteKing[0], whiteKing[1], 'K')) {
                System.out.println("Game#" + gameNum + ": white king is in check.");
            } else if (isUnderAttack(board, blackKing[0], blackKing[1], 'k')) {
                System.out.println("Game#" + gameNum + ": black king is in check.");
            } else {
                System.out.println("Game#" + gameNum + ": no king is in check.");
            }
            
            gameNum++;
        }
        scanner.close();
    }
}
