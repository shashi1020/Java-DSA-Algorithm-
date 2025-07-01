import java.util.*;

public class Leetcode2493 {
    
    public static int magnificentSets(int n, int[][] edges) {
        if(edges==null || n<=0)
        {
            return -1;
        }

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i<n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int a[] : edges)
        {
            graph.get(a[0]-1).add(a[1]-1);
            graph.get(a[1]-1).add(a[0]-1);
        }

        boolean []visited = new boolean[n];
        int maxGroup = 0;

        for(int i=1; i<n; i++)
        {
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                List<Integer> component = new ArrayList<>();
                q.offer(i);
                visited[i] = true;
                
                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    component.add(curr);
                    for(int nei : graph.get(curr))
                    {
                        if(!visited[nei])
                        {
                            visited[nei]  = true;
                            q.offer(nei);
                        }
                    }
                }
                int maxDepth = 0;
                for(int a:component)
                {
                    maxDepth = Math.max(maxDepth,bfsmaxDepth(a,graph,n));
                }
                maxGroup += maxDepth; 
            }
            
        }
        return maxGroup;
    }



public boolean isbipartite(List<List<Integer>> graph, int n)
{
    int color[] = new int[n];
    Arrays.fill(color, -1);

    for(int i=0; i<n; i++){
        if(color[i]==-1){
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            color[0] = 0;

                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    for(int nei : graph.get(curr))
                    {
                        if(color[nei]==-1)
                        {
                            color[nei] = 1 - color[curr];
                            q.offer(nei);
                        }else{
                            return false;
                        }
                    }

                }
    }
}

        return true;
    }   
    private static int bfsmaxDepth(int start, List<List<Integer>> graph, int n)
    {
        int []level = new int[n];
        Arrays.fill(level,-1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        level[start] = 0;
        int maxLevel = 0;

        while(!q.isEmpty())
        {
            int curr = q.poll();
            for(int nei : graph.get(curr))
            {
                if(level[nei] == -1)
                {
                    level[nei] =level[curr] + 1;
                    maxLevel = Math.max(level[curr],level[nei]);
                    q.offer(nei);
                }
            }
        }

        return maxLevel+1;
    }
       
    public static void main(String[] args) {
        System.out.println(magnificentSets(6,new int[][]{{1,2},{2,3},{3,1}}));
    }

}
