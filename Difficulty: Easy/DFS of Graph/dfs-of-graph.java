class Solution {
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> out = new ArrayList<>();
        int v = adj.size();
        boolean[] vis = new boolean[v];
        
        dfsHelper(0,adj,vis,out);
        return out;
        
    }
    private void dfsHelper(int u,ArrayList<ArrayList<Integer>> adj,boolean[] vis,ArrayList<Integer> out ){
        if(vis[u]) return;
        vis[u]=true;
        out.add(u);
        for(int v:adj.get(u)){
            if(!vis[v]){
                dfsHelper(v,adj,vis,out);
            }
        }
    }
}