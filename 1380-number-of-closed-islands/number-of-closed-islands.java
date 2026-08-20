class Solution {
    int m;
    int n;
    private void DFS(int[][] grid, int i, int j){
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j]==1) return;
        grid[i][j]=1;
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);

    }
    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if((i==0 || j==0 || i==m-1 || j==n-1) && grid[i][j]==0){
                    DFS(grid,i,j);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    DFS(grid,i,j);
                    ans++;
                }
            }
        }
        return ans;

    }
}