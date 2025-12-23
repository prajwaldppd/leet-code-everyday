class Solution {
    public int bs(int target_idx, int k, int[] nums, long[] ps){
        int l=0, r=target_idx;
        int bestidx=target_idx;

        while(l<=r){
            int mid = l+(r-l)/2;

            long count = target_idx-mid+1;
            long requiredsum= count * nums[target_idx];
            long cursum=ps[target_idx]-(mid>0?ps[mid-1]:0);
            long ops=requiredsum-cursum;

            if(ops>k){
                l=mid+1;
            }else{
                bestidx=mid;
                r=mid-1;
            }
        }

        return target_idx-bestidx+1;
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        
        long [] ps = new long[n];
        ps[0]=nums[0];

        for(int i=1;i<n;i++){
            ps[i]=ps[i-1]+nums[i];
        }

        int freq=1;
        for(int i=0;i<n;i++){
            freq=Math.max(freq,bs(i, k, nums, ps));
        }

        return freq;
    }
}