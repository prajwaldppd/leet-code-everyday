class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        List<int[]> list = new ArrayList<>();
        int[] prev = intervals[0];
        list.add(prev);
    

        for(int i=0;i<intervals.length;i++){
            int[] cur= intervals[i];
            if(cur[0]<=prev[1]){
                prev[1]=Math.max(prev[1],cur[1]);
            }else{
                prev = intervals[i];
                list.add(prev);
            }
        }


       int[][] arr = new int[list.size()][2];
       for(int i=0;i<list.size();i++){
        arr[i]=list.get(i);
       }

       return arr;
    }
}