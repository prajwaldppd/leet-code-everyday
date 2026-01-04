class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] pos = new int[n/2];
        int[] neg = new int[n/2];

        int j=0; int k=0;

        for(int a:nums){
            if(a>0){
                pos[j]=a;
                j++;
            }else{
                neg[k]=a;
                k++;
            }
        }
        k=0;
        for(int i=0; i<pos.length;i++){
            nums[k++]=pos[i];
            nums[k++]=neg[i];
        }


        return nums;
    }
}