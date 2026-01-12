class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while(start<=end){
            int mid = start+(end-start)/2;
            if(arr[start]<=arr[mid] && arr[mid]<=arr[end]) return arr[start];
            // check if left or right side is sorted.
            if(arr[start]<=arr[mid]){  // left side is sorted here.
                start=mid+1;
            }else{
                end =mid;
            }
        }

        return -1;
    }
}