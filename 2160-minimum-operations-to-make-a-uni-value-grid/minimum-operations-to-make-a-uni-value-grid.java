class Solution {
    public int minOperations(int[][] grid, int x) {
        int n = grid.length;
        int m = grid[0].length;
        int[] arr = new int[m*n];
        int j=0;

        int rem = grid[0][0]%x;

        for(int[] row: grid){
            for(int val: row){
                if(val%x!=rem) return -1;
                arr[j++]=val;
            }
        }

        Arrays.sort(arr);

        int median = arr[(m*n)/2];
        int count =0;

        for(int a: arr){
            count+= Math.abs((median-a)/x);
        }

       return count;

    }
}