class Solution {
    public int maxRotateFunction(int[] nums) {
        int sum =0;
        int n = nums.length;

        for(int a:nums){
            sum+=a;
        }
        /// F(k+1) =f(k) + sum - n* nums[n-1-k] 

        int f=0;
        for(int i=0;i<n;i++) f+=i*nums[i];

        int ans = f;

        for(int i=1; i<n; i++){
            f+=sum - n* nums[n-i];
            ans = Math.max(ans,f);
        }

        return ans;
    }
}