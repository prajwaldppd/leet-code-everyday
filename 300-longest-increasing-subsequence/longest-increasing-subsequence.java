class Solution {
    public int solve(int[] nums, int i, int previdx, int[][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][previdx+1]!=-1) return dp[i][previdx+1];
        int skip = solve(nums,i+1,previdx,dp);
        int take=Integer.MIN_VALUE;

        if(previdx==-1 || nums[i]>nums[previdx]){
            take = 1+ solve(nums,i+1,i,dp);
        }
        dp[i][previdx+1]=Math.max(skip,take);
        return dp[i][previdx+1];
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(nums,0,-1,dp);
    }
}