class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int top =0;
        int left=0;
        int right = matrix[0].length-1;
        int bottom = matrix.length-1;
        List<Integer> lis = new ArrayList<>();

        while(top<=bottom && left <= right){
            // 1. from left to right 
            for(int i = left; i<=right; i++){
                lis.add(matrix[top][i]);
            }
            top++;

            // 2. now add top to bottom 
            for(int i=top; i<=bottom; i++){
                lis.add(matrix[i][right]);
            }
            right--;

            // 3. add right to left 

            if(top<=bottom){
                for(int i=right; i>=left; i--){
                    lis.add(matrix[bottom][i]);
                }
            }
            bottom--;

            // 4. bottom to top.
            if(left<=right){
                for(int i=bottom; i>=top;i--){
                    lis.add(matrix[i][left]);
                }
            }
            left++;
        }


        return lis;
    }
}