class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:prerequisites){
            adj.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[n];
        boolean[] inRec= new boolean[n];

        for(int i=0;i<n;i++){
            if(!vis[i] && cycleDFS(adj,i,vis,inRec)){
                return false;
            }
        }
        return true;
    }

    private boolean cycleDFS( List<List<Integer>> adj, int u, boolean[] vis, boolean[] inRec){
        vis[u]=true;
        inRec[u]=true;

        for(int v:adj.get(u)){
            if(!vis[v] && cycleDFS(adj,v,vis,inRec)){
                return true;
            }else if(inRec[v]){
                return true;
            }
        }

        inRec[u]=false;
        return false;
    }
}