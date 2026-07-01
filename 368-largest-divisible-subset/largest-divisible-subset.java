class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] prev_idx = new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev_idx,-1);
        int idx=0,res=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(1+dp[j]>dp[i]){
                        dp[i]=1+dp[j];
                        prev_idx[i]=j;
                    }
                    if(dp[i]>res){
                        res=dp[i];
                        idx=i;
                    }

                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(idx!=-1){
            ans.add(nums[idx]);
            idx=prev_idx[idx];
        }
        return ans;
    }
}