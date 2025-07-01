import java.util.*;

class Lee2493{
    
    public static int magnificentSets(int n, int[][] edges) {
        int maxGroup = 0;

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int a[] : edges)
        {
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
        int []group = new int[n+1];
        Arrays.fill(group,-1);

        for(int i=0; i<n; i++)
        {
            if(group[i] == -1){
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                group[i] = 0;
                
                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    for(int nei : graph.get(curr))
                    {
                        if(group[nei] == -1)
                        {
                            group[nei]  = group[curr]+1;
                            maxGroup = Math.max(maxGroup,group[nei]);
                        }else if(Math.abs(group[nei]-group[curr])!=1)
                        {
                            return -1;
                        }
                    }
                }
            }
            
        }
        return maxGroup+1;
    }
    
    // check graph is bipartite?
    public static boolean isbipartite(int n,int[][] edges){
       
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int a[] : edges)
        {
            graph.get(a[0]).add(a[1]);
            graph.get(a[1]).add(a[0]);
        }
       
        int color[] = new int[n];

        for(int i =0; i<n; i++)
        {
            if(color[i] == -1)
            {
                Queue<Integer> q = new LinkedList<>();

                q.offer(i);
                color[i] = 0;

                while(!q.isEmpty())
                {
                    int curr = q.poll();
                    for(int nei : graph.get(curr))
                    {
                        if(color[nei] == -1)
                        {
                            color[nei] = 1 - color[curr];
                            q.offer(nei);
                        }else if(color[nei] == color[curr]){
                            return false;   
                        }
                    }
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(magnificentSets(6,new int[][]{{1,2},{1,4},{1,5},{2,3},{2,6},{4,6}}));
    }
}