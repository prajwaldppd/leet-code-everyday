class Solution {
    public ArrayList<Integer> dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edge:edges){
            int u=edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        
        int[] result = new int[V];
        Arrays.fill(result,Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        result[src]=0;
        
        pq.offer(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dist = cur[0];
            int u = cur[1];
            if(dist>result[u]) continue;
            
            for(int[] neighbour:adj.get(u)){
                int v= neighbour[0];
                int weight = neighbour[1];
                if(result[u]+weight<result[v]){
                    result[v]=result[u]+weight;
                    pq.offer(new int[]{result[v],v});
                }
            }
        }
        
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i=0;i<V;i++){
            if(result[i]==Integer.MAX_VALUE){
                dist.add(-1);
            }else{
                dist.add(result[i]);
            }
        }
        return dist;
        
    }
}