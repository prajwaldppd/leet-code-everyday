class Solution {
    int m;
    int n;

    private int BFS(int[][] grid, int i, int j){
        int ans=0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]='0';
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!q.isEmpty()){
            int[] curr = q.poll();
            ans++;
            for(int[] dir:dirs){
                int ni=curr[0]+dir[0];
                int nj=curr[1]+dir[1];
                if(ni>=0 && ni<m && nj>=0 && nj<n && grid[ni][nj]==1) {
                    grid[ni][nj]=0;
                    q.offer(new int[]{ni,nj});
                }
            }
        }
        return ans;
    }
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int area=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==1){
                   int cur= BFS(grid,i,j);
                   area=Math.max(area,cur);
                }
            }
        }
        return area;
    }
}