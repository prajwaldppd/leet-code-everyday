class Solution {
    private void topologicalSort( List<List<Integer>> adj, int n, int[] indegree,List<Integer> ans){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                ans.add(i);
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int u=q.poll();
            for(int v:adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    ans.add(v);
                    q.offer(v);
                }
            }
        }
    }
    public int[] findOrder(int n ,int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree= new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:prerequisites){
            int u = e[1];
            int v = e[0];
            adj.get(u).add(v);
            indegree[v]++;
        }

        List<Integer> ans = new ArrayList<>();
        topologicalSort(adj,n,indegree,ans);
        if(ans.size()!=n) return new int[0];
        int[] answer = new int[n];
        for(int i=0;i<n;i++){
            answer[i]=ans.get(i);
        }
        return answer;
        
    }
}