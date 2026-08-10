class Solution {
    private int[] parent;
    private int[] rank;
    private int extra=0;
    
    private int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }
    
    private boolean union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py){
            return false;
        }
        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[px]<rank[py]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
        return true;
    }
    
    public int minConnect(int V, int[][] edges) {
        // code here
        if(edges.length < V-1) return -1;
        parent= new int[V];
        rank = new int[V];
        for(int i=0;i<V;i++){
            parent[i]=i;
            rank[i]=0;
        }
        int components=V;
        
        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            if(union(u,v))  components--;
           
        }
        
        return components-1;
    }
}
