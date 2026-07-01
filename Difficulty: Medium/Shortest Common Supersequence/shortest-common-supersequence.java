class Solution {
    private static int solve(String s1, String s2, int i, int j, int[][] dp){
        if(i>=s1.length() && j>=s2.length()) return 0;
        if(i>=s1.length()) return s2.length()-j;
        if(j>=s2.length()) return s1.length()-i;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1+solve(s1,s2,i+1,j+1,dp);
        return dp[i][j]= 1+Math.min(solve(s1,s2,i+1,j,dp),solve(s1,s2,i,j+1,dp));
    }
    public static int minSuperSeq(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length()][s2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(s1,s2,0,0,dp);
    }
}