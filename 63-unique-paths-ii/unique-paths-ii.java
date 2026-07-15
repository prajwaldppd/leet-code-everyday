class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] t = new int[m+1][n+1];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1) t[i][j]=0;
                else if(i==0 && j==0) t[i][j]=1;
                else if(j==0) t[i][j]=t[i-1][j];
                else if (i==0) t[i][j]=t[i][j-1];
                else t[i][j]=t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n-1];
    }
}