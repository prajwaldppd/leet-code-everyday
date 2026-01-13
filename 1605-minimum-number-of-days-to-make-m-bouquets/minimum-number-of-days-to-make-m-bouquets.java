class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay.length< (long) m*k) return -1;

        int low=bloomDay[0];
        int high=bloomDay[0];

        for(int p:bloomDay){
            low=Math.min(low,p);
            high=Math.max(high,p);
        }
        int ans =-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(midpossible(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }

        return ans;
    }

    public boolean midpossible(int[] arr, int m, int k, int mid){
        int flowers=0;
        int boq=0;

        for(int a:arr){
            if(a<=mid){
                flowers++;
                if(flowers==k){
                    boq++;
                    flowers=0;
                }
            }else{
                flowers=0;
            }
        }

        return boq>=m;
    }
}