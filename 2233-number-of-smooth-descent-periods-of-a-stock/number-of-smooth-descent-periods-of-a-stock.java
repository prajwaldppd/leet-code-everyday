class Solution {
    public long getDescentPeriods(int[] prices) {
        long count =1;
        long result =1;

        for(int i=1;i<prices.length;i++){
            if(prices[i-1]-1==prices[i]){
                count++;
            }else{
                count=1;
                
            }
            result=result+count;
        }

        return result;
    }
}