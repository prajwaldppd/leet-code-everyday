class Solution {
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
        }
        
        int[] indegree = new int[V];
        for(int u=0;u<V;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.offer(i);
        }
        
        int count =0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int v:adj.get(node)){
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }
        
        return count!=V;
    }
}