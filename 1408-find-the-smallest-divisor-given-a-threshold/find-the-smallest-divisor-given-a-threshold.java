class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low=1;
        int high =nums[0];
        for(int a:nums){
            high=Math.max(high,a);
        }
        int ans=-1;
        // answer lies b/w [1 to max(arr)].
        while(low<=high){
            int mid=low+(high-low)/2;

            if(possible(nums,threshold,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean possible(int[] arr, int max, int div){
        int sum=0;
        for(int a: arr){
            sum=sum+(a/div);
            if(a%div>0) sum=sum+1;

            if(sum>max) return false;
        }

        return sum<=max;
    }
}