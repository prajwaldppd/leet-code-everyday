class Solution {
    public int shipWithinDays(int[] weights, int days) {
        long low=weights[0];
        long high=0;
        for(int a:weights){
            low=Math.max(low,a);
            high=high+a;
        }
        int ans=-1;

        while(low<=high){
            long mid=(long) low+(high-low)/2;
            if(possible(weights,days,mid)){
                ans=(int)mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean possible(int[] arr, int days, long cap){
        int weight=0;
        int day=0;
        int start=0;
        while(start<arr.length){
            if(arr[start]+weight <=cap){
                weight+=arr[start];
                start++;
            }else{
                day++;
                weight=0;
            }
        }
        day++;

        return day<=days;
    }
}