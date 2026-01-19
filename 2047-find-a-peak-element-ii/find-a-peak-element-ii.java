class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int low =0;
        int high = m;

        while(low<=high){
            int mid = low+(high-low)/2;
            int maxcol = findmax(mat, mid);
            int up = (mid-1>=0 )?mat[mid-1][maxcol]:-1;
            int down = (mid+1>=m)?-1:mat[mid+1][maxcol];

            if(mat[mid][maxcol]>up && mat[mid][maxcol]>down) return new int[]{mid,maxcol};
            if(up>mat[mid][maxcol]) high=mid-1;
            else low=mid+1;
        }

        return new int[] {-1,-1};
    }

    public int findmax(int[][] mat, int idx){
        int size = mat[idx].length;
        int maxidx=0;
        for(int i=0;i<size;i++){
            if(mat[idx][i]>mat[idx][maxidx]) maxidx=i;
        }
        return maxidx;
    }
}