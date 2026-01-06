class Solution {
    public int subarraySum(int[] nums, int k) {
        int res =0;
        int sum =0;
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(sum==k){
                res++;
            }

            if(map.containsKey(sum-k)){
                res=res+map.get(sum-k);
            }
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }


        return res;
    }
}