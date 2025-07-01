// A company is organizing a meeting and has a list of n employees, waiting to be invited. They have arranged for a large circular table, capable of seating any number of employees.

// The employees are numbered from 0 to n - 1. Each employee has a favorite person and they will attend the meeting only if they can sit next to their favorite person at the table. The favorite person of an employee is not themself.

// Given a 0-indexed integer array favorite, where favorite[i] denotes the favorite person of the ith employee, return the maximum number of employees that can be invited to the meeting.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lee2127 {
    
        int maxCycle = 0;

    public static void maximumInvitations(int[] favorite) {

        List<List<Integer>> reverseGraph = new ArrayList<>();
        int n = favorite.length;

        for(int i=0; i<n; i++) 
        {
            reverseGraph.add(new ArrayList<>());
        } 

        for(int i=0; i<n; i++)
        {
            reverseGraph.get(favorite[i]).add(i);
        }
       
        boolean []vis = new boolean[n];
        int []depth = new int[n];

    // find longest chain cycle
        for(int i=0; i<n; i++)
        {
            Arrays.fill(depth,-1);
            if(!vis[i])
            {
                maxCycle = Math.max(maxCycle,dfscycle(i,vis, depth,favorite,0));
            }
        }

        int mutual =0;

        // handle mutual pairs
        for(int i=0; i<n; i++)
        {
            int j=favorite[i];
            if(i<j && favorite[j] == i)
            {
                // mutual pair
                int chain1 = LongestChain(i, j, reverseGraph);
                int chain2 = LongestChain(j, i, reverseGraph);
                mutual += chain1 + chain2;
            }
        }
        System.out.println(Math.max(maxCycle,mutual));
    }
    // DFS to find longest chain leading to mutual pair node (skip back edge to its pair)
    public static int LongestChain(int node, int skip, List<List<Integer>> graph)
    {
        int maxDepth = 0;

        for(int nei: graph.get(node))
        {
            if(nei == skip) continue;
            maxDepth = Math.max(maxDepth, LongestChain(nei, skip, graph)); 
        }
        return maxDepth + 1;


    } 

    // find longest chain cycle
    public static int dfscycle(int node, boolean []vis, int[]depth,int favorite[], int d)
    {
        if(depth[node]!=-1)
        {
            return d-depth[node];
        }
        if(vis[node]) return 0;

        vis[node] = true;
        depth[node] = d;

        int res = dfscycle(favorite[node], vis, depth,favorite, d+1);
        vis[node] = false;

        return res;
    }
    public static void main(String[] args) {
        maximumInvitations(new int[]{3,0,10,4,1,9,12,8,5,8,13,1,9,12});
    }
}
