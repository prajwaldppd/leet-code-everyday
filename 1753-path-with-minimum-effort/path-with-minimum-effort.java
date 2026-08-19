class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] dirs = {{1,0},{0,1},{0,-1},{-1,0}};
        
        int[][] res = new int[m][n];
        for(int[] a:res) Arrays.fill(a,Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        res[0][0]=0;
        pq.offer(new int[]{0,0,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dt = cur[0];
            int x=cur[1];
            int y = cur[2];
            if(x==m-1 && y==n-1) return dt;
            if(dt>res[x][y]) continue;

            for(int[] d:dirs){
                int nx=x+d[0];
                int ny = y+d[1];

                if(nx>=0 && nx<m && ny>=0 && ny<n){
                    int nexteff= Math.max(dt,Math.abs(heights[x][y]-heights[nx][ny]));
                    if(nexteff<res[nx][ny]){
                        res[nx][ny]=nexteff;
                        pq.offer(new int[]{nexteff,nx,ny});
                    }
                }
            }


        }

        return res[m-1][n-1];
    }
}