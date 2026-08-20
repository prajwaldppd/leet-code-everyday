class Solution {
    int m;
    int n;
    private void DFS(char[][] grid, int i, int j){
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0' || grid[i][j] == '$') return;

        grid[i][j]='$';
        DFS(grid,i+1,j);
        DFS(grid,i-1,j);
        DFS(grid,i,j+1);
        DFS(grid,i,j-1);
    }
    public int numIslands(char[][] grid) {
         m = grid.length;
         n = grid[0].length;

        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    DFS(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
}