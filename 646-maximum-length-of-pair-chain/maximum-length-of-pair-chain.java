class Solution {
    public int solve(int[][] pairs, int i, int prev, int[][]dp){
        if(i>=pairs.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip = solve(pairs,i+1,prev,dp);
        int take=0;
        if(prev==-1 || pairs[i][0]>pairs[prev][1]){
            take = 1+solve(pairs,i+1,i,dp);
        }
        dp[i][prev+1]=Math.max(take,skip);
        return dp[i][prev+1];
    }
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->Integer.compare(a[0],b[0]));
        int n = pairs.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(pairs,0,-1,dp);
    }
}