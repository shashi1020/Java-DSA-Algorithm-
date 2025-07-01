import java.util.*;

public class Dijkstrasalgo {
    static class Edge{
        int src; 
        int dest;
        int wt;
        
        public Edge(int s,int d,int wt)
        {
            this.src = s;
            this.dest = d;
            this.wt = wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph[])
    {
        // Initialize each element of the graph array to an empty lis
        for(int i=0; i<graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0, 1,2));
        graph[0].add(new Edge(0, 2,4));

        graph[1].add(new Edge(1, 3,7));
        graph[1].add(new Edge(1, 2,1));

        graph[2].add(new Edge(2,4,3 ));
        
        graph[3].add(new Edge(3,5,1));

        graph[4].add(new Edge(4,3,2));
        graph[4].add(new Edge(4,5,5));
 
    }

    public static class pair implements Comparable<pair>{
        int node;
        int dist;

        public pair(int n, int d)
        {
            this.node = n;
            this.dist = d;
        }

        @Override
        public int compareTo(pair p2)
        {
            return this.dist - p2.dist;
        }
    }

    // O(E+ElogV)
    public static void dijkstrasalgo(ArrayList<Edge> graph[], boolean vis[], int dist[], int src, int V)
    {
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for(int i=0; i<V; i++)
        {
            if(i != src)
            {
                dist[i] = Integer.MAX_VALUE;    
            }
        }
        pq.add(new pair(0,0));
        while(!pq.isEmpty())
        {
            pair curr = pq.remove();
            if(!vis[curr.node])
            {
                vis[curr.node] = true;
                for(int i=0; i<graph[curr.node].size(); i++)
                {
                    Edge e = graph[curr.node].get(i);
                    int u = e.src;
                    int v = e.dest;
                    if(dist[u] + e.wt < dist[v])
                    {
                        dist[v] = dist[u] + e.wt;
                        pq.add(new pair(v, dist[v]));
                    }
                }
            }

        }
        for(int i=0; i<V; i++)
        {
            System.out.print(dist[i]+" ");
        }
        System.out.println();
        

        
    }
    public static void main(String[] args) {
        int V = 6;
        /*
         0--->1<---2
                 / ^
                /  | 
               3-->4  
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        dijkstrasalgo(graph, new boolean[V], new int[V], 0, V);
        

        
    }
}
