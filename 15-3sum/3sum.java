class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i-1]==nums[i]) continue;

            int j=i+1;
            int k= n-1;

            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum ==0){
                    List<Integer> a= new ArrayList<>();
                    a.add(nums[i]);
                    a.add(nums[j]);
                    a.add(nums[k]);
                    ans.add(a);
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }else if(sum >0){
                    k--;
                }else{
                    j++;
                }
            }
        }

        return ans;
    }
}