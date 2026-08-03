class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);
        // -1 => not visited, 1=> group 1, 0=> group 2
        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(DFS(graph,i,vis,1)==false)  return false;
            }
        }
        return true;
    }

    private boolean DFS(int[][] graph, int u, int[] vis, int grp){
        vis[u]=grp;
        for(int v=0;v<graph[u].length;v++){
            int neighbor = graph[u][v];

            if(vis[neighbor]==grp) return false;

            if(vis[neighbor]==-1){
                if(DFS(graph,neighbor,vis,1-grp)==false)  return false;
            }
        }
        return true;
    }
}