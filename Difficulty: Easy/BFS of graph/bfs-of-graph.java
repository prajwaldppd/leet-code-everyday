class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int v = adj.size();
        boolean[] vis = new boolean[v];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> out = new ArrayList<>();
        bfsHelper(adj,0,vis,q,out);
        return out;
    }
    private void bfsHelper(ArrayList<ArrayList<Integer>> adj,int u,boolean[] vis,Queue<Integer> q,ArrayList<Integer> out){
        if(vis[u]) return;
        vis[u]=true;
        q.offer(u);
        while(!q.isEmpty()){
            int a = q.poll();
            out.add(a);
            for(int node:adj.get(a)){
                if(!vis[node]){
                    vis[node]=true;
                    q.offer(node);
                }
            }
        }
    }
}