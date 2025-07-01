 
// Given an m x n grid. Each cell of the grid has a sign pointing to the next cell you should visit if you are currently in this cell. The sign of grid[i][j] can be:

// 1 which means go to the cell to the right. (i.e go from grid[i][j] to grid[i][j + 1])
// 2 which means go to the cell to the left. (i.e go from grid[i][j] to grid[i][j - 1])
// 3 which means go to the lower cell. (i.e go from grid[i][j] to grid[i + 1][j])
// 4 which means go to the upper cell. (i.e go from grid[i][j] to grid[i - 1][j])
// Notice that there could be some signs on the cells of the grid that point outside the grid.

// You will initially start at the upper left cell (0, 0). A valid path in the grid is a path that starts from the upper left cell (0, 0) and ends at the bottom-right cell (m - 1, n - 1) following the signs on the grid. The valid path does not have to be the shortest.

// You can modify the sign on a cell with cost = 1. You can modify the sign on a cell one time only.

// Return the minimum cost to make the grid have at least one valid path.
import java.util.*;
public class Leetcode_1368 {
    class Edge{
        int Node;
        int wt;
        Edge(int Node, int wt){
            this.Node = Node;
            this.wt = wt;
        }
    }

    // graph creation
    public static int minCost(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int directions[][] = {{0,1},{0,-1},{1,0},{-1,0}};

        int [][]cost = new int[rows][cols];
        for(int a[]:cost)
        {
            Arrays.fill(a,Integer.MAX_VALUE);
        }

        // create a deque for 0-1 BFS: (i,j,cost)
        Deque<int[]> dq = new ArrayDeque<>(); 
        dq.offerFirst(new int[]{0,0,0});

        while(!dq.isEmpty())
        {
            int []current = dq.pollFirst();
            int r=current[0], c=current[1], k=current[2];

            if(k>=cost[r][c]) continue;

            cost[r][c] = k;

            if(r==rows-1 && c==cols-1){
                return k;
            }

            for(int d = 0; d<4; d++)
            {
                int nr = r + directions[d][0];
                int nc = c + directions[d][1];

                if(nr>=0 && nr < rows && nc>=0 && nc< cols)
                {
                    if(grid[r][c] == d+1)
                    {
                        dq.offerFirst(new int[]{nr,nc,k});
                    }else{
                        dq.offerLast(new int[]{nr,nc,k+1});
                    }
                }
            }

        }
            return -1;
    }


    public static void main(String[] args) {
        int grid[][] = {{1,1,1,1},
                        {2,2,2,2},
                        {1,1,1,1},
                        {2,2,2,2}};
                        System.out.println(minCost(grid));

                    
    }
}
