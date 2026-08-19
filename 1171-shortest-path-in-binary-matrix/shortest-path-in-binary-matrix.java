class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 0 to m-1 and 0 to n-1
        if(grid[0][0]==1) return -1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        int count =0;
        grid[0][0]=1;

        while(!q.isEmpty()){
            int size=q.size();
            count++;
            for(int k=0;k<size;k++){
                int[] cur = q.poll();
                int i=cur[0];
                int j = cur[1];
                if(i==m-1 && j==n-1) return count;
                if(i+1<m && grid[i+1][j]==0){
                    q.offer(new int[]{i+1,j});
                    grid[i+1][j]=1;
                }
                if(j+1<n && grid[i][j+1]==0){
                    q.offer(new int[]{i,j+1});
                    grid[i][j+1]=1;
                }
                if(i+1<m && j+1<n && grid[i+1][j+1]==0){
                    q.offer(new int[]{i+1,j+1});
                    grid[i+1][j+1]=1;
                }
                if(i-1>=0 && grid[i-1][j]==0){
                    q.offer(new int[]{i-1,j});
                    grid[i-1][j]=1;
                }
                if(j-1>=0 && grid[i][j-1]==0){
                    q.offer(new int[]{i,j-1});
                    grid[i][j-1]=1;
                }
                if(i-1>=0 && j-1>=0 && grid[i-1][j-1]==0){
                    q.offer(new int[]{i-1,j-1});
                    grid[i-1][j-1]=1;
                }
                if(i-1>=0 && j+1<n && grid[i-1][j+1]==0){
                    q.offer(new int[]{i-1,j+1});
                    grid[i-1][j+1]=1;
                }
                if(i+1<m && j-1>=0 && grid[i+1][j-1]==0){
                    q.offer(new int[]{i+1,j-1});
                    grid[i+1][j-1]=1;
                }
                
            }
            

        }
        return -1;

    }
}