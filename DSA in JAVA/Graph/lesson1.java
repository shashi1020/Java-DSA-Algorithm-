import java.util.*;
// how to store graph in java
class lesson1{
    static class Edge{
        int src;
        int dest;
        public Edge(int s, int d)
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
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));
        graph[1].add(new Edge(1,0));

        graph[2].add(new Edge(2,4));
        graph[2].add(new Edge(2,0));
        
        graph[3].add(new Edge(3,1));
        graph[3].add(new Edge(3,4));
        graph[3].add(new Edge(3,5));

        graph[4].add(new Edge(4,2));
        graph[4].add(new Edge(4,5));
        graph[4].add(new Edge(4,3));
       

        graph[5].add(new Edge(5,3));
        graph[5].add(new Edge(5,4));
        graph[5].add(new Edge(5,6));

        graph[6].add(new Edge(6,5));

    }
    public static void BFS(ArrayList<Edge> graph[], int V)
    {
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        q.add(0);

        while(!q.isEmpty())
        {
            int curr = q.remove();
            if(visited[curr]==false)
            {
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i = 0; i<graph[curr].size(); i++)
                {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }

        }
    }
    public static void dfs(ArrayList<Edge>[] graph, int curr, boolean visited[]) {
        // Mark the current node as visited and print it
        visited[curr] = true;
        System.out.print(curr + " ");

        // Traverse the adjacency list of the current node
        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                dfs(graph, e.dest, visited);
            }
        }
    }
          
     // Find All path from Source to Node
    public static void AllPaths(ArrayList<Edge> graph[], int src, int target, boolean vis[], String path)
    {
        if(src == target)
        {
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++)
        {
            Edge e = graph[src].get(i);
            if(!vis[e.dest]){
                vis[src] = true;
                AllPaths(graph, e.dest, target, vis, path+e.dest);
                vis[src] = false;
            }
        }
    }

   
    public static void main(String[] args) {
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        /*
            1---3
         /      | \
        0       |   5--6
         \      |  /
           2----4  
         */
        CreateGraph(graph);
        boolean visited[] = new boolean[V];
        dfs(graph, 0, visited);      
        System.out.println();
    }
}