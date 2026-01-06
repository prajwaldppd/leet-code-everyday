class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot=-1;

        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                pivot=i;
                break;
            }
        }


        if(pivot!=-1){
            
            for(int j=n-1;j>pivot;j--){
                if(nums[j]>nums[pivot]){
                    swap(nums,pivot,j);
                    break;
                }
            }

        }

        reverse(nums,pivot+1,n-1);
        
    }

    public void swap(int[] nums, int a, int b){
        int temp = nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public void reverse(int[] nums, int l, int r){
        while(l<r){
            swap(nums,l,r);
            l++;
            r--;
        }
    }


}