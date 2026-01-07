class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> s = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            Set<Integer> map = new HashSet<>();
            for(int j=i+1; j<nums.length;j++){
                int third = -(nums[i]+nums[j]);

                if(map.contains(third)){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(third);
                    Collections.sort(list);
                    s.add(list);
                }
                map.add(nums[j]);
            }
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> a: s){
            ans.add(a);
        }

        return ans;
    }
}