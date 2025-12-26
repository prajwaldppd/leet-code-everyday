class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int i=0;
        for(int j=1;j<n;j++){
            if(nums[i]!=nums[j]){
                // swap i+1 with j and j++
                int tp = nums[i+1];
                nums[i+1]=nums[j];
                nums[j]=tp;
                i++;
            }
        }
    return i+1;
    }
}