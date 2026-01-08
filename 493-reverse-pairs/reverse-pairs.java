class Solution {
    public int mergesort(int[] arr, int low, int high){
        if(low>=high) return 0;

        int mid = low+(high-low)/2;
        int count=0;
        count= count + mergesort(arr,low,mid);
        count= count + mergesort(arr,mid+1,high);
        int j=mid+1;
        for(int i=low;i<=mid;i++){
            while(j<=high && (long)arr[i]>2L*arr[j]){
                j++;
            }
            count= count + j-(mid+1);
        }

        merge(arr,low,mid,high);
        return count;
    }

    public void merge(int[] arr, int low, int mid, int high){
        int i=low;
        int j=mid+1;
        int k=0;
        int[] temp = new int[high-low+1];

        while(i<=mid && j<=high){
            if(arr[i]>arr[j]){
                temp[k++]=arr[j++];
            }else{
                temp[k++]=arr[i++];
            }
        }
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=high){
            temp[k++]=arr[j++];
        }

        for(int x=0;x<temp.length;x++){
            arr[low+x]=temp[x];
        }
    }
    public int reversePairs(int[] arr) {
        return mergesort(arr,0,arr.length-1);
    }
}