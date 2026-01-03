class Solution {
    public int maxProfit(int[] arr) {
        int profit=0;
        int n = arr.length;
        int min = arr[0];

        for(int i=1;i<n;i++){
            profit=Math.max(profit,(arr[i]-min));
            min = Math.min(min,arr[i]);
        }


        return profit;
    }
}