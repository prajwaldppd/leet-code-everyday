class Solution {

    public List<Integer> generateRow(int r){
        long ans=1;
        List<Integer> lis = new ArrayList<>();
        lis.add(1);

        for(int i=1; i<r;i++){
            ans = ans * (r-i);
            ans = ans/i;
            lis.add((int)ans);
        }

        return lis;

    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=1;i<=numRows;i++){
            list.add(generateRow(i));
        }

        return list;
    }
}