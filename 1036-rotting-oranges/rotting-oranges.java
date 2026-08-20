class Solution {
    int m;
    int n;
    int ans=0;
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int freshcount=0;

        Queue<int[]> q = new LinkedList<>();


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    freshcount++;
                }else if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
            }
        }
        if(freshcount==0) return 0;
        int mins=0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!q.isEmpty()){
            int flag=0;
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] cur = q.poll();
                int x=cur[0];
                int y = cur[1];
                for(int[] dir:directions){
                    int nx=x+dir[0];
                    int ny = y+dir[1];
                    if(nx>=0 && nx<m && ny>=0 && ny<n && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        freshcount--;
                        q.offer(new int[]{nx,ny});
                        flag=1;
                    }
                }
            }
            
            if(flag==1){
                mins++;
            }
        }

        return freshcount==0?mins:-1;
    }
}