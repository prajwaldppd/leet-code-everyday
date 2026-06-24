class Solution {
    int n;
    public long solve(int idx, int[] nums, boolean flag, long[][]dp){
        if(idx>=n) return 0;
        // skip 
        int fidx= flag?1:0;
        if(dp[idx][fidx]!=-1) return dp[idx][fidx];
        long skip = solve(idx+1,nums,flag,dp);

        // take if flag is false then we do minus else plus 
        int val = nums[idx];
        if(flag==false) val=-val;
        long take = val+solve(idx+1,nums,!flag,dp);
        return dp[idx][fidx]=Math.max(skip,take);
    }
    public long maxAlternatingSum(int[] nums) {
        n = nums.length;
        long[][] dp = new long[n+1][2];
        for(long[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0,nums,true,dp); // true : + 
    }
}