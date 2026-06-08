class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int i=0;
        int j = n-1;
        int k = 0;
        int l = n-1;
        int[] res = new int[n];
        while(i<n && j>=0){
            if(nums[i]<pivot) res[k++]=nums[i];
            if(nums[j]>pivot) res[l--]=nums[j];
            i++;
            j--;
        }

        while(k<=l){
            res[k]=pivot;
            k++;
        }
        return res;

    }
}