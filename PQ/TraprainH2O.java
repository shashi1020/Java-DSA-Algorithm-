import java.util.Collections;
import java.util.PriorityQueue;

class TraprainH2O
{

    static class cell{
        int row, col, ht;
        cell(int row, int col, int ht){
            this.row= row;
            this.col=col;
            this.ht=ht;

        }
}
    public static int trapRainWater(int[][] heightMap) {

        if(heightMap==null || heightMap[0].length<3 || heightMap.length<3)
        {
            return 0;
        }
        int rows=heightMap.length;
        int cols=heightMap[0].length;
        PriorityQueue<cell> minHeap = new PriorityQueue<>((a,b)->a.ht-b.ht);

        boolean visited[][] = new boolean[rows][cols];

        for(int j=0; j<cols ;j++)
        {
            minHeap.offer(new cell(0,j,heightMap[0][j]));
            minHeap.offer(new cell(rows-1,j,heightMap[rows-1][j]));
            visited[0][j] = true;
            visited[rows-1][j] = true;
        }

        for(int i=1; i<rows-1; i++)
        {
            minHeap.offer(new cell(i,0, heightMap[i][0]));
            minHeap.offer(new cell(i, cols-1, heightMap[i][cols-1]));
            visited[i][0] = true;
            visited[i][cols-1] = true;
        }
       
        int dr[] = {0,0,-1,1};
        int dc[] = {1,-1,0,0};
        int trappedWater = 0;
        while(!minHeap.isEmpty())
        {
            cell curr = minHeap.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = curr.row+dr[i];
                int newCol = curr.col+dc[i];

                if(newRow>=0 && newRow<rows && newCol>=0 && newCol < cols && !visited[newRow][newCol])
                {
                    visited[newRow][newCol] = true;
                    trappedWater += Math.max(0,(curr.ht-heightMap[newRow][newCol]));
                    minHeap.offer(new cell(newRow, newCol, Math.max(heightMap[newRow][newCol],curr.ht)));
                }
            }



        }
        
        return trappedWater;
    }
    public static void main(String[] args) {

        int [][]heightMap = {{1,4,3,1,3,2},
                             {3,2,1,3,2,4},
                             {2,3,3,2,3,1}};

        System.out.println(trapRainWater(heightMap));

        
        
    }
}