class Solution {
    private int solve(String s1, String s2, int i, int j, int[][] dp){
        if(j==s2.length()) return s1.length()-i;
        if(i==s1.length()) return s2.length()-j;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]= solve(s1,s2,i+1,j+1,dp);
        int del = 1+solve(s1,s2,i+1,j,dp);
        int insert = 1+solve(s1,s2,i,j+1,dp);
        int replace = 1+solve(s1,s2,i+1,j+1,dp);
        return dp[i][j]=Math.min(del,Math.min(insert,replace));
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(word1,word2,0,0,dp);
    }
}