class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int low = 0;
        int high = (m*n)-1;

        while(low<=high){
            int mid = low+(high-low)/2;
            int ele = matrix[mid/m][mid%m];
            if(ele==target){
                return true;
            }else if(ele>target){
                high=mid-1;
            }else{
                low=mid+1;
                }

        }
        return false;
    }
}