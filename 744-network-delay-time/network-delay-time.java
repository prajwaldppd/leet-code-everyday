class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj  = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:times){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            adj.get(u).add(new int[]{v,wt});
            // adj.get(v).add(new int[]{u,wt});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int u = cur[1];
            int dt = cur[0];
            if(dt>dist[u]) continue;
            for(int[] neighbour:adj.get(u)){
                int v = neighbour[0];
                int wt= neighbour[1];
                if(wt+dt<dist[v]){
                    dist[v]=wt+dt;
                    pq.offer(new int[]{dist[v],v});
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }else{
                res=Math.max(res,dist[i]);
            }
        }

        return res;
    }
}