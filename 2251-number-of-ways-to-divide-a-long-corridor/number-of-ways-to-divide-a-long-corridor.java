class Solution {
    public int numberOfWays(String corridor) {
        int MOD = 1_000_000_007;
        int count =0;
        int prefix =0;
        int ans=1;

        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                prefix++;
            }
            if(prefix==2){
                count++;
            }
            if(prefix==3){
               ans = (int)((ans * 1L * count) % MOD);
                count=0;
                prefix=1;
            }
        }
        if(prefix!=2){
            return 0;
        }

        return ans;

    }
}