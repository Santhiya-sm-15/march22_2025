# march22_2025
The problem that i solved today in leetcode

1.You are given an integer n. There is an undirected graph with n vertices, numbered from 0 to n - 1. You are given a 2D integer array edges where edges[i] = [ai, bi] denotes that there exists an undirected edge connecting vertices ai and bi.

Return the number of complete connected components of the graph.

A connected component is a subgraph of a graph in which there exists a path between any two vertices, and no vertex of the subgraph shares an edge with a vertex outside of the subgraph.

A connected component is said to be complete if there exists an edge between every pair of its vertices.

Code:

class Solution {
    ArrayList<Integer>[] adj;
    public void dfs(int src,boolean[] visited,List<Integer> vertex)
    {
        visited[src]=true;
        vertex.add(src);
        for(int x:adj[src])
        {
            if(!visited[x])
                dfs(x,visited,vertex);
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        adj=new ArrayList[n];
        int i;
        for(i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int[] e:edges)
        {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }
        boolean[] visited=new boolean[n];
        int cnt=0;
        for(i=0;i<n;i++)
        {
            if(!visited[i])
            {
                List<Integer> vertex=new ArrayList<>();
                boolean flag=true;
                dfs(i,visited,vertex);
                int len=vertex.size()-1;
                for(int x:vertex)
                {
                    if(adj[x].size()!=len)
                    {
                        flag=false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
        }
        return cnt;
    }
}
