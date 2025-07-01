import java.util.*;

public class Remobstacle {
    static class Edge
    {
        int toNode;
        int wt;
        Edge(int toNode, int wt)
        {
            this.toNode = toNode;
            this.wt = wt;
        }

        public String toString()
        {
            return "(" + toNode + " " + wt + ")";
        }
    }

    public static Map<Integer, List<Edge>> gridTograph(int [][]grid){
            int rows = grid.length;
            int cols = grid[0].length;
            HashMap<Integer,List<Edge>> graph = new HashMap<>();

            int dr[] = {-1,1,0,0}; //up, down
            int dc[] = {0,0,1,-1}; // left, right 


            for(int i=0; i<rows; i++)
            {
                for(int j=0; j<cols; j++)
                {
                    int current = i * cols + j;
                    graph.putIfAbsent(current, new ArrayList<Edge>());
                    
                    for(int k=0;k<4; k++)
                    {
                        int newRow = i+dr[k];
                        int newCol = j+dc[k];

                        if(newRow>=0 && newRow<rows && newCol >=0 && newCol < cols)
                        {
                            int neightbour = newRow * cols + newCol ;
                            int wt = grid[newRow][newCol];
                            graph.get(current).add(new Edge(neightbour,wt));
                        }

                    }

                }
            }
            return graph;
    }

    public static int minimumObstacles(int[][] grid) {
        Map<Integer, List<Edge>> graph=gridTograph(grid);
        int rows = grid.length;
        int cols = grid[0].length;
        int source  =0;
        int destination = (rows-1) * cols+ (cols-1);

        Deque<Integer> dq = new ArrayDeque<>();
        Map<Integer, Integer> dist = new HashMap<>();

        for(int node : graph.keySet())
        {
            dist.put(node,Integer.MAX_VALUE);
        }
    
        dq.add(source);
        dist.put(source,0);
       
        while(!dq.isEmpty())
        {
            int current = dq.pollFirst();
            
            for(Edge e : graph.get(current))
            {
                int newDist = dist.get(current)+e.wt;
                if(newDist < dist.get(e.toNode))
                {
                    dist.put(e.toNode, newDist);
                    if(e.wt == 0)
                    {
                        dq.addFirst(e.toNode);
                    }else{
                        dq.addLast(e.toNode);
                    }
                }
            }
        }
        return dist.get(destination);
    }

    public static void main(String[] args)
    {
        int [][]grid = {{0,1,1},
                        {0,0,0},
                        {1,1,1}};
        System.out.println(minimumObstacles(grid));
        

        

    } 


}
