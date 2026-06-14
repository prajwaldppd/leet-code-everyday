class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(nums1[a.i]+nums2[a.j])-(nums1[b.i]+nums2[b.j]));

        for(int i=0; i<Math.min(nums1.length,k); i++){
            pq.offer(new Pair(i,0));
        }

        while(k>0 && !pq.isEmpty()){
            Pair cur = pq.poll();
            res.add(Arrays.asList(nums1[cur.i],nums2[cur.j]));
            if(cur.j+1<nums2.length) pq.offer(new Pair(cur.i,cur.j+1));
            k--;
        }

        return res;
    }
}