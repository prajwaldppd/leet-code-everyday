class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
       List<List<Integer>> adj = new ArrayList<>();
       for(int i=0;i<V;i++){
           adj.add(new ArrayList<>());
       }
       
       for(int[] e:edges){
           adj.get(e[0]).add(e[1]);
       }
       
       int[] indegree = new int[V];
       
       Arrays.fill(indegree,0);
       
       for(int u=0;u<V;u++){
           for(int v:adj.get(u)){
               indegree[v]++;
           }
       }
       
       Queue<Integer> q = new LinkedList<>();
       for(int i=0;i<V;i++){
           if(indegree[i]==0) q.offer(i);
       }
       
       // now bfs code.
       while(!q.isEmpty()){
           int node = q.poll();
           ans.add(node);
           for(int v:adj.get(node)){
               indegree[v]--;
               if(indegree[v]==0) q.offer(v);
           }
       }
       
       return ans;
    }
}