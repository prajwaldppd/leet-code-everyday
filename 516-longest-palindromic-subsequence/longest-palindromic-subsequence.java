class Solution {
    int[][] t;
    private int solve(String s, int i, int j){
        if(i>j) return 0;
        if(i==j) return 1;
        if(t[i][j]!=-1) return t[i][j];
        if(s.charAt(i)==s.charAt(j)) return t[i][j]=2 + solve(s,i+1,j-1);
        return t[i][j]= Math.max(solve(s,i+1,j),solve(s,i,j-1));
    }
    public int longestPalindromeSubseq(String s) {
        t=new int[1001][1001];
        for(int[] row:t) Arrays.fill(row,-1);
        return solve(s,0,s.length()-1);
    }
}