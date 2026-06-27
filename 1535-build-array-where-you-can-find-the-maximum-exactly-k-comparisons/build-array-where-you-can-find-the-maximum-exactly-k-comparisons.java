class Solution {
    int N, M, K;
    int[][][] dp;
    int MOD = 1_000_000_007;

    private int solve(int idx, int cost, int max){
        if(cost>K) return 0;
        if(idx>=N) return (cost==K)?1:0;

        if(dp[idx][cost][max+1]!=-1) return dp[idx][cost][max+1];

        long res =0;
        for(int i=1;i<=M;i++){
            if(i>max) res+=solve(idx+1,cost+1,i)%MOD;
            else res+=solve(idx+1,cost,max)%MOD;
        }
        return dp[idx][cost][max + 1] = (int) (res % MOD);
    }
    public int numOfArrays(int n, int m, int k) {
        N=n;
        M=m;
        K=k;
        dp = new int[n+1][k+1][m+2];
        for(int[][] arr:dp){
            for(int[]row:arr){
                Arrays.fill(row,-1);
            }
        }
        return solve(0,0,-1);
    }
}