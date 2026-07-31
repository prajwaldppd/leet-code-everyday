class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] e:prerequisites){
            adj.get(e[1]).add(e[0]);
        }

        int[] indegree = new int[n];
        for(int i=0;i<n;i++){
            for(int v:adj.get(i)){
                indegree[v]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0) q.offer(i);
        }

        int count=0;
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            for(int v:adj.get(node)){
                indegree[v]--;
                if(indegree[v]==0) q.offer(v);
            }
        }

        return count==n;
    }
}