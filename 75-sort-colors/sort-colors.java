class Solution {

    public void swap(int[] nums, int a , int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public void sortColors(int[] nums) {

        int n = nums.length;

        int zero =0;
        int one =0;
        int two = n-1;

        while(one<=two){
            if(nums[one]==0)
           {
            swap(nums,one, zero);
            zero++;
            one++;
           }
            else if(nums[one]==1)
            {
            one++;
           }
           else{
            swap(nums,one,two);
            two--;
           }
        }
        
    }
}