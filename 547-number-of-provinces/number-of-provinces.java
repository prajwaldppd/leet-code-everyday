class Solution {
    public int findCircleNum(int[][] isConnected) {
                int n = isConnected.length;
        // total n cities. 
        // have to create a adj list 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean [] vis = new boolean[n];
        int count =0;

        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(adj,i,vis);
                count++;
            }
        }

        return count;
    }
    private void dfs(List<List<Integer>> adj,int u, boolean[] vis){
        vis[u]=true;
        for(int v:adj.get(u)){
            if(!vis[v]){
                dfs(adj,v,vis);
            }
        }
    }
}