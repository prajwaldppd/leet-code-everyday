class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] t = new int[m+1][n+1];
        for(int[] row:t) Arrays.fill(row,-1);
        return solve(0,0,obstacleGrid,t,m,n);
    }

    private int solve(int i, int j, int[][] ob, int[][] t, int m, int n){
        if(i<0 || i>=m || j<0 || j>=n) return 0;
        if(ob[i][j]==1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(t[i][j]!=-1) return t[i][j];
        int right = solve(i,j+1,ob,t,m,n);
        int down = solve(i+1,j,ob,t,m,n);
        return t[i][j]=right+down;
    }
}