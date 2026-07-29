class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
         List<List<Integer>> adj = new ArrayList<>();
         
         for(int i=0;i<V;i++){
             adj.add(new ArrayList<>());
         }
         
         for(int[] e:edges){
             adj.get(e[0]).add(e[1]);
         }
         
         boolean[] vis = new boolean[V];
         Stack<Integer> st = new Stack<>();
         
        for(int i=0;i<V;i++){
            if(!vis[i]){
                DFS(adj,i,vis,st);
            }
        }
         
         ArrayList<Integer> ans = new ArrayList<>();
         while(!st.isEmpty()){
             ans.add(st.pop());
         }
        return ans;
    }
    
    private void DFS(List<List<Integer>> adj, int u, boolean[] vis, Stack<Integer> st){
        vis[u]=true;
        for(int v:adj.get(u)){
            if(!vis[v]) DFS(adj,v,vis,st);
        }
        st.push(u);
    }
}