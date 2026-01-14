class Solution {
    public int splitArray(int[] nums, int k) {
        int low=nums[0];
        int high = 0;

        for(int a : nums){
            low=Math.max(low,a);
            high=high+a;
        }
        int ans =-1;

        while(low<=high){
            int mid = low +(high-low)/2;

            if(possible(nums,k,mid)){
                ans =mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean possible(int[] nums, int k , int mid){
        // mid -> largest possible sum. 
        int partitions=1;
        int cursum=0;

        for(int a:nums){
            if(cursum+a>mid){
                partitions++;
                cursum=a;
            }else{
                cursum=cursum+a;
            }
        }

        return partitions<=k;
    }
}