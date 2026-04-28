class Solution {
    public int[] productExceptSelf(int[] nums) {
           // 1, 2, 3, 4, 5
// prefix =>  1, 1, 2, 6, 24  => res after first loop.
// suffix =>   ,  , 20 , 5,  1
// product=>   ,  ,  , 30,  24
        int n = nums.length;
        int[] res = new int[n];
        int left=1, right=1;

        res[0]=left;

        for(int i=1;i<n;i++){
            res[i]= res[i-1]*nums[i-1];
        }

        res[n-1]=res[n-1]*right;

        for(int i=n-2;i>=0;i--){
            right=right*nums[i+1];
            res[i]=res[i]*right;
        }

        return res;
    }
}