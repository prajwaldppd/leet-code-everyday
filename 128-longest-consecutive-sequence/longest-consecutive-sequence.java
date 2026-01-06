class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n==0) return 0;
        int longest =1;

        HashSet<Integer> set =new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int x:set){
            if(!set.contains(x-1)){
                int count =1;
                int tp=x;
                while(set.contains(tp+1)){
                    count++;
                    tp++;
                }
                longest=Math.max(count,longest);
            }
        }




        return longest;

    }
}