class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0;i<n;i++){
            int j = lowerBound(arr,nums[i]);
            if(j==arr.size()) arr.add(nums[i]);
            else arr.set(j,nums[i]);
        }
        return arr.size();
    }
    private int lowerBound(ArrayList<Integer> arr,int a){
        int left =0,  right =arr.size();
        int res = arr.size();
        while(left<right){
            int mid = left +(right-left)/2;
            if(arr.get(mid)<a) {left=mid+1;}
            else{
                res=mid;
                right=mid;
            }
        }
        return res;
    }
}