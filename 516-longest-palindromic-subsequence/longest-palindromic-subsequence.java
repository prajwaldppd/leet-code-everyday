class Solution {
    int[][] t;
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        t = new int[n+1][n+1];

        for(int len =1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j = i+len-1;
                if(i==j) t[i][j]=1;
                else if(i+1==j) t[i][j]=(s.charAt(i)==s.charAt(j))?2:1;
                else t[i][j]=(s.charAt(i)==s.charAt(j))?2+t[i+1][j-1]:Math.max(t[i+1][j],t[i][j-1]);
            }
        }

        return t[0][n-1];
    }
}