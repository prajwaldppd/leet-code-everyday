class Solution {
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        boolean [] vis= new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!vis[i] && cycleDFS(adj,vis,i,-1)){
                return true;
            }
        }
        return false;
    }
    private boolean cycleDFS(List<List<Integer>> adj, boolean[] vis, int u, int parent){
        vis[u]=true;
        for(int v:adj.get(u)){
            if(!vis[v]){
                if(cycleDFS(adj,vis,v,u)) return true;
            }else if(v!=parent){
                return true;
            }
        }
        
        return false;
    }
}