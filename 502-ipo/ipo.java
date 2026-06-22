class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int pair[][] =new int[n][2];
        for(int i=0;i<n;i++){
            pair[i][0]= capital[i];
            pair[i][1]=profits[i];
        }
        Arrays.sort(pair,(a,b)->a[0]-b[0]);
        int i=0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        while(k>0){
            while(i<n && pair[i][0]<=w){
                pq.offer(pair[i][1]);
                i++;
            }
            if(pq.isEmpty()) break;
            w+=pq.poll();
            k--;
        }
        return w;
    }
}