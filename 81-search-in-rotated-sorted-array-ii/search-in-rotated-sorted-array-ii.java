class Solution {
    public boolean search(int[] arr, int target) {
        int n = arr.length;
        int low =0;
        int high = n-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            // condition 1 if low ==mid==high
            if(arr[mid]==target) return true;
            if(arr[low]== arr[mid] && arr[mid]==arr[high]){
                low++;
                high--;
            }else if(arr[low]<=arr[mid]){ // check which one half is sorted. left or right.(left)
                if(arr[low]<=target && arr[mid]>=target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }else{
                if(arr[mid]<=target && arr[high]>=target){
                    low=mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return false;
    }
}