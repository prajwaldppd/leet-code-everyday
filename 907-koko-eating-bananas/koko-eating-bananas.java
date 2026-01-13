class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int startHour =1;
        int endHour =piles[0];
        for(int a: piles){
            endHour=Math.max(endHour,a);
        }
        int k = -1;
        while(startHour<=endHour){
            int mid = startHour+(endHour-startHour)/2;
            // can it finish eating within mid hour per banana? 
            // if yes the store ans and end = mid-1 else start = mid+1;
            if(canEat(piles,mid,h)){
                k=mid;
                endHour=mid-1;
            }else{
                startHour=mid+1;
            }
        }

        return k;
    }

    public boolean canEat(int[] piles, int mid, int h){
        long ans =0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]<=mid) ans++;
            else if(piles[i]>mid){ 
                ans =ans+(piles[i]/mid);
                if(piles[i]%mid>0) ans++;
                }

            if(ans>h) return false;
        }
        return true;
    }
}