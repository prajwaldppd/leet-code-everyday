class Solution {
    void reverse(int[] nums, int start, int end){
        while(start<=end){
            int tp = nums[start];
            nums[start]= nums[end];
            nums[end]=tp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        k=n-k;
        reverse(nums, 0,k-1);
        reverse(nums,k,n-1);
        reverse(nums,0,n-1);
    }
}