class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // using dijsktras
        //[[1,1],[0,1],[1,0],[-1,-1],[0,-1],[-1,0],[1,-1],[-1,1]] 
        int[][] dirs = {{1, 1}, {0, 1}, {1, 0}, {-1, -1}, {0, -1}, {-1, 0}, {1, -1}, {-1, 1}};
        int m = grid.length;
        int n = grid[0].length;
        if(m==0 || n==0 || grid[0][0]==1) return -1;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        int[][] result = new int[m][n];
        for(int[] a:result) Arrays.fill(a,Integer.MAX_VALUE);
        result[0][0]=1;
        pq.offer(new int[]{1,0,0});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int dt = cur[0];
            int x = cur[1];
            int y = cur[2];

            if(x==m-1 && y==n-1) return dt;
            if(dt>result[x][y]) continue;

            for(int[] d:dirs){ // all possilbe cases
                int x_= x+d[0];
                int y_= y+d[1];
                if(x_>=0 && x_<m && y_>=0 && y_<n && grid[x_][y_]==0){
                    if(1+dt<result[x_][y_]){
                        result[x_][y_]=1+dt;
                        pq.offer(new int[]{result[x_][y_],x_,y_});
                        grid[x_][y_]=1;
                    }
                }
            }
        }

        return -1;
    }
}