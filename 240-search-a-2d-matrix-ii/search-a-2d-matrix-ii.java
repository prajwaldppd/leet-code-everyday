class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length;
        int m = matrix.length;

        int row =0;
        int col = n-1;

        while(row<m && col>=0){
            // System.out.println(row+", "+ col);
            int ele= matrix[row][col];
            if(ele ==target) return true;
            if(ele>target) col--;
            else row++;
        }

        return false;
    }
}