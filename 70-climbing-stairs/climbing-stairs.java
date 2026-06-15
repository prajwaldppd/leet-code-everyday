class Solution {
    public int helper(int n, int[] dp){
        if(n==0) return 1;
       if(n<0) return 0;
       if(dp[n]!=0) return dp[n];
       int st = helper(n-1,dp);
       int st2 = helper(n-2,dp);
       dp[n]=st+st2;
       return dp[n];
    }
    public int climbStairs(int n) {
        if(n==0 || n ==1) return n;
        int dp[] = new int[n+1];
        return  helper(n,dp);
    }
}