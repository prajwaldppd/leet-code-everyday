class Solution {
    int len,idx;
    int [][] t= new int [1001][1001];
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int[] row:t) Arrays.fill(row,-1);
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if (solve(s,i,j)==1){
                    if(j-i+1 > len){
                        len=j-i+1;
                        idx=i;
                    }
                }
            }
        }
        return s.substring(idx,idx+len);
    }

    public int solve(String s, int i, int j){
        if(i>=j) return 1;
        if(t[i][j]!=-1) return t[i][j];
        if(s.charAt(i)==s.charAt(j)) return t[i][j]= solve(s,i+1,j-1);
        return 0;
    }
}