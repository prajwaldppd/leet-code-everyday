class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] vis = new int[n];
        Arrays.fill(vis,-1);

        for(int i=0;i<n;i++){
            if(vis[i]==-1){
                if(BFS(graph,i,vis,1)==false) return false;
            }
        }
        return true;
    }

    private boolean BFS(int[][] graph, int u, int[] vis, int grp){
        vis[u]=grp;
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        q.offer(grp);
        while(!q.isEmpty()){
            int node = q.poll();
            int col = q.poll();
            for(int v=0;v<graph[node].length;v++){
                int neighbour = graph[node][v];
                if(vis[neighbour]==col) return false;

                if(vis[neighbour]==-1){
                    vis[neighbour]=1-col;
                    q.offer(neighbour);
                    q.offer(1-col);
                }
            }
        }

        return true;
    }
}