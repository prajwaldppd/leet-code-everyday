class Solution {
    static class Node {
        long sum;
        int idx;
        Node(long s, int i) {
            sum = s;
            idx = i;
        }
    }

    public int minimumPairRemoval(int[] arr) {
        TreeSet<Node> set = new TreeSet<>((a, b) -> {
            int cmp = Long.compare(a.sum, b.sum);
            if (cmp != 0) return cmp;
            return Integer.compare(a.idx, b.idx);
        });

        long nums[] = new long[arr.length];
        for(int i=0;i<arr.length;i++) nums[i]=arr[i];

        int op = 0;
        int badpair = 0;
        int n = nums.length;

        int[] previdx = new int[n];
        int[] nextidx = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) badpair++;
            set.add(new Node( nums[i - 1] + nums[i], i - 1));
        }

        for (int i = 0; i < n; i++) {
            previdx[i] = i - 1;
            nextidx[i] = i + 1;
        }

        while (badpair > 0) {

            Node min = set.first();
            set.remove(min);

            int first = min.idx;
            int second = nextidx[first];

            int first_left = previdx[first];
            int second_right = nextidx[second];

            if (nums[first] > nums[second]) badpair--;

            long sum =  nums[first] + nums[second];

            if (first_left >= 0) {
                if (nums[first_left] > nums[first] && nums[first_left] <= sum) badpair--;
                else if (nums[first_left] <= nums[first] && nums[first_left] > sum) badpair++;
            }

            if (second_right < n) {
                if (nums[second] > nums[second_right] && sum <= nums[second_right]) badpair--;
                else if (nums[second] <= nums[second_right] && sum > nums[second_right]) badpair++; 
            }

            if(first_left >= 0){
                set.remove(new Node( nums[first_left] + nums[first], first_left));
                 set.add(new Node( nums[first_left] + sum, first_left));
            }
            if(second_right < n){
                set.remove(new Node(nums[second] + nums[second_right], second));
                set.add(new Node( sum + nums[second_right], first));
                previdx[second_right] = first;
            }

            nextidx[first] = second_right;
            nums[first] = sum;
            op++;
        }

        return op;
    }
}
