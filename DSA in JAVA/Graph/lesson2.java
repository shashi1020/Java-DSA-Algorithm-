import java.util.*;

public class lesson2 {
    static class Edge{
        int src; 
        int dest;
        public Edge(int s,int d)
        {
            this.src = s;
            this.dest = d;
        }
    }
    public static void CreateGraph(ArrayList<Edge> graph[])
    {
        // Initialize each element of the graph array to an empty lis
        for(int i=0; i<graph.length; i++)
        {
            graph[i] = new ArrayList<Edge>();
        }
        graph[0].add(new Edge(0,1));
        // graph[0].add(new Edge(0,2));

        graph[1].add(new Edge(1,0));
        graph[1].add(new Edge(1,2));

        graph[2].add(new Edge(2,1));
        // graph[2].add(new Edge(2,0));
        
    }
    // Find All path from Source to Node
    public static void AllPaths(ArrayList<Edge> graph[], int src, int target, int V, String path)
    {

        boolean vis[] = new boolean[V];
        if(src == target)
        {
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++)
        {
            Edge e = graph[src].get(i);
            vis[src] = true;
            AllPaths(graph, src, target, V, path+e.dest);
            vis[src] = false;
        }
    }

    public static boolean detectCycleDirected(ArrayList<Edge> graph[], int curr, boolean vis[], boolean rec[])
    {
        // directed graph
        vis[curr] = true;
        rec[curr] = true;

        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(rec[e.dest])
            {
                return true;
            }
            else if(!vis[e.dest]){
                if(detectCycleDirected(graph, e.dest, vis, rec))
                {
                    return true;
                }
            }
        }
        rec[curr] = false;
        return false;

    }

    public static boolean DetectCycleUndirected(ArrayList<Edge> graph[],boolean vis[],int curr, int parent)
    {
        vis[curr] = true;
        for(int i=0; i<graph[curr].size(); i++)
        {
            Edge e = graph[curr].get(i);
            if(vis[e.dest] == true && parent!=e.dest)
            {
                return true;
            }
            if(!vis[e.dest])
            {
                if(DetectCycleUndirected(graph, vis, e.dest,curr))
                {
                    return true;
                }   
            }
        }
    return false;
    }

    public static void main(String[] args) {
        int V = 3;
        /*
         0--->1<---2
                 / ^
                /  | 
               3-->4  
         */

        ArrayList<Edge> graph[] = new ArrayList[V];
        CreateGraph(graph);
        int curr=0;
        boolean vis[] = new boolean[V];
        boolean rec[] = new boolean[V];
        boolean res = false;
        System.out.println(DetectCycleUndirected(graph, vis, 0,-1));
       
        
    }
}
