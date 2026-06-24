class Solution {
    public int rob(int[] nums) {
       int n = nums.length;
       if(n==1) return nums[0];
       int[] dp = new int[n+1];
       Arrays.fill(dp,-1);
       int rob0= helper(nums,dp,0,n-2,0);
       Arrays.fill(dp,-1);
       int rob1 = helper(nums,dp,1,n-1,1);
       return Math.max(rob0,rob1);
    }
    private int helper(int[] nums, int[] dp, int start, int end, int i){
       if(i>end) return 0;
       if(dp[i]!=-1) return dp[i];
       int steal = nums[i]+helper(nums,dp,start,end,i+2);
       int skip= helper(nums,dp,start,end,i+1);
       dp[i]=Math.max(steal,skip);
       return dp[i];
    }
}