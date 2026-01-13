class Solution {
    public int findKthPositive(int[] arr, int k) {
        int[] missing=new int[arr.length];

        for(int i=0;i<arr.length;i++){
            missing[i]=arr[i]-(i+1);
        }

        int low=0;
        int high= arr.length-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            if(missing[mid]>=k){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return low+k;
    }
}