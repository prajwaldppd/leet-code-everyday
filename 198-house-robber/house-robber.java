class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][2];
        for(int[] row: dp) Arrays.fill(row,-1);

        return solve(0,0,nums,dp);
    }

    private int solve(int i, int previous, int[] nums, int[][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][previous]!=-1){
            return dp[i][previous];
        }

        int skip = solve(i+1, 0, nums,dp);
        int rob=0;
        if(previous==0){
            rob=nums[i]+solve(i+1,1,nums,dp);
        }
        dp[i][previous]= Math.max(skip,rob);
        return dp[i][previous];
    }
}


