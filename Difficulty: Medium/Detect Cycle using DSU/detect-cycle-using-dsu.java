class Solution {
   private int[] parent;
   private int[] rank;
   
    private int find(int x){
       if(parent[x]==x) return x;
       return parent[x]=find(parent[x]);
    }
    
    private void union(int x, int y){
        int x_par = find(x);
        int y_par = find(y);
        if(x_par==y_par) return;
        
        if(rank[x_par]>rank[y_par]){
            parent[y_par]=x_par;
        }else if(rank[x_par]<rank[y_par]){
            parent[x_par]=y_par;
        }else{
            parent[y_par]=x_par;
            rank[x_par]++;
        }
    }
    
    public boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        parent = new int[V];
        rank = new int[V];
        
        for(int i=0;i<V;i++){
            parent[i]=i;
            rank[i]=0;
        }
        
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                if(u<v){
                    if(find(u)==find(v)) return true;
                    else union(u,v);
                }
            }
        }
        
        return false;
        
    }
}