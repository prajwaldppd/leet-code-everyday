class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[][] start = new int[n][2];
        int[][] end = new int[n][2];
        for(int i=0;i<n;i++){
            start[i][0]=trips[i][1];
            start[i][1]= trips[i][0];
            end[i][0]=trips[i][2];
            end[i][1]= trips[i][0];
        }

        Arrays.sort(start,(a,b)-> Integer.compare(a[0],b[0]));
        Arrays.sort(end,(a,b)-> Integer.compare(a[0],b[0]));

        int j=0;
        int curcap=capacity;

        for(int i=0;i<n;i++){

            while(j<n && start[i][0]>=end[j][0]){
                curcap+=end[j][1];
                j++;
            }
            curcap-=start[i][1];
            if(curcap<0){
                return false;
            }
        }

        return true;
    }
}