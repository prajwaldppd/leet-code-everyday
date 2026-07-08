class Solution {
    int len, idx;
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] t = new boolean[n+1][n+1];
        for(int l=1;l<=n;l++){
            for(int i=0;i+l-1<n;i++){
                int j = i+l-1;
                if(i==j) t[i][j]=true;
                else if(i+1==j) t[i][j]=s.charAt(i)==s.charAt(j);
                else t[i][j]=(s.charAt(i)==s.charAt(j)) && t[i+1][j-1];

                if(t[i][j]){
                    if(j-i+1>len){
                        len=j-i+1;
                        idx=i;
                    }
                }
            }
        }

        return s.substring(idx,idx+len);
    }
}