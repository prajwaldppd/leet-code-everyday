class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<=n-4;i++)
        {
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<=n-3;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int k = j+1;
                int l = n-1;
                while(k<l)
                {
                    long sum = (long) nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target){
                        List<Integer> a = new ArrayList<>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[k]);
                        a.add(nums[l]);
                        ans.add(a);
                        k++;
                        l--;
                        while(k<l && nums[k-1]==nums[k]) k++;
                        while(k<l && nums[l]==nums[l+1]) l--;
                    }else if(sum>target){
                        l--;
                    }else{
                        k++;
                    }
                }
                
            }
        }


        return ans;
    }
}