class Solution {
    private boolean isPredecessor(String worda, String wordb){
        if(worda.length()+1!=wordb.length()) return false;
        int i=0,j=0;
        while(i<worda.length() && j<wordb.length()){
            if(worda.charAt(i)==wordb.charAt(j)) i++;
            j++;
        }
        return i==worda.length();
    }
    private int solve(String[] words, int i, int prev, int[][]dp){
        if(i>=words.length) return 0;
        if(dp[i][prev+1]!=-1) return dp[i][prev+1];
        int skip = solve(words, i+1,prev,dp);
        int take =0;
        if(prev==-1 || isPredecessor(words[prev],words[i])){
            take = 1+ solve(words,i+1,i,dp);
        }
        dp[i][prev+1]= Math.max(skip,take);
        return dp[i][prev+1];
    }
    public int longestStrChain(String[] words) {
        Arrays.sort(words,(a,b)->Integer.compare(a.length(),b.length()));
        int n = words.length;
        int[][] dp = new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        return solve(words,0,-1,dp);
    }
}