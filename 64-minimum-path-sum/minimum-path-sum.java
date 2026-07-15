class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n =grid[0].length;
        int[][] t = new int[m+1][n+1];
        for(int[] row:t) Arrays.fill(row,-1);
        return solve(0,0,grid,m,n,t);
    }
    private int solve(int i, int j, int[][] grid, int m, int n, int[][] t){
       if (i >= m || j >= n) return 2000000;
        if(i==m-1 && j==n-1) return grid[i][j];
        if(t[i][j]!=-1) return t[i][j];
        int right = solve(i,j+1,grid,m,n,t);
        int down = solve(i+1,j,grid,m,n,t);
        return t[i][j]= grid[i][j] + Math.min(right,down);
    }
}