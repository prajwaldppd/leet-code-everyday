class Solution {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int a: nums) list.add(a);
        int count=0;

        while(!isSorted(list)){
            int min = Integer.MAX_VALUE;
            int idx =-1;
            for(int i=0;i<list.size()-1;i++){
                int sum = list.get(i)+list.get(i+1);
                if(sum<min){
                    min=sum;
                    idx=i;
                }
            }

            list.set(idx,min);
            list.remove(idx+1);
            count++;
        }

        return count;
    }

    public boolean isSorted(ArrayList<Integer> list){
        for(int i=1;i<list.size();i++){
            if(list.get(i-1)>list.get(i)) return false;
        }
        return true;
    }

}