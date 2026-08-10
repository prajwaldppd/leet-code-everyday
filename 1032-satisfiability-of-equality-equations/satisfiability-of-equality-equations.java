class Solution {
    private int[] parent;
    private int[] rank;

    private int find(int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent[x]);
    }

    private void union(int x, int y){
        int par_x=find(x);
        int par_y=find(y);
        if(par_x==par_y) return;

        if(rank[par_x]>rank[par_y]){
            parent[par_y]=par_x;
        }else if(rank[par_y]>rank[par_x]){
            parent[par_x]=par_y;
        }else{
            parent[par_y]=par_x;
            rank[par_x]++;
        }
    }

    public boolean equationsPossible(String[] equations) {
        int n = equations.length;
        parent = new int[26];
        rank = new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
            rank[i]=0;
        }

        for(String s:equations){
            if(s.charAt(1)=='='){
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }

        for(String s:equations){
            if(s.charAt(1)=='!'){
               if(find(s.charAt(0)-'a')==find(s.charAt(3)-'a')) return false;
            }
        }
        

        return true;
    }
}