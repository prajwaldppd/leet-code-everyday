class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x){
        if(x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    private void union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py) return;
        if(rank[px]>rank[py]) parent[py]=px;
        else if(rank[py]>rank[px]) parent[px]=py;
        else parent[py]=px; rank[px]++;
    }

    public long countPairs(int n, int[][] edges) {
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(int[] e:edges){
            int u=e[0];
            int v=e[1];
            union(u,v);
        }

        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<n;i++){
            int pari=find(i);
            mp.put(pari,mp.getOrDefault(pari,0)+1);
        }

        int remaining =n;
        int size=n;
        long result =0;
        
        for(int count:mp.values()){
            remaining -=count;
            result +=(long) count*remaining;
        }

        return result;
    }

}