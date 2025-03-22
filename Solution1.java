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