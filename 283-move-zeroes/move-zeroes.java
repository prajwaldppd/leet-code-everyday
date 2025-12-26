class Solution {
    public void moveZeroes(int[] nums) {
        // j=> index which moves forward 
        // i => always points towards the first xero

        int i=0;
        while(i<nums.length && nums[i]!=0){
            i++;
        }

        for(int j=i+1; j<nums.length ; j++){
            if(nums[j]!=0){
                int tp = nums[j];
                nums[j]=nums[i];
                nums[i]=tp;
                i++;
            }
        }
    }
}