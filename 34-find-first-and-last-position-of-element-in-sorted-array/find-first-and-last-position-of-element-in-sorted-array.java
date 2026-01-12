class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low= lower(nums,target);
        int high = higher(nums,target);

        if(low>=nums.length || nums[low]!=target) return new int[]{-1,-1};

        return new int[] {low,high-1};
    }

    public int lower(int[] arr, int x){
        int low=0;
        int high = arr.length-1;
        int ans =-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>=x){
                ans =mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans==-1?arr.length:ans;
    }

    public int higher(int[] arr, int x){
        int low=0;
        int high = arr.length-1;
        int ans =-1;
    
        while(low<=high){
            int mid = low+(high-low)/2;
            if(arr[mid]>x){
                ans=mid;
                high =mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans==-1?arr.length:ans;
    }
}