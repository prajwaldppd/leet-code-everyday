class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] t = new int [n];
        Arrays.fill(t,1);
        int res =1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    t[i]=Math.max(t[i],1+t[j]);
                }
            }
            res=Math.max(res,t[i]);
        }
        return res;
       
    }
}