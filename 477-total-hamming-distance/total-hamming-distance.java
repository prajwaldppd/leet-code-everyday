class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int xor = nums[i]^nums[j];
                count+=Integer.bitCount(xor);
            }
        }

        return count;
    }
}