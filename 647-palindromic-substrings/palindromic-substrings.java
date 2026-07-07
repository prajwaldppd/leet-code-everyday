class Solution {
    int[][] t = new int [1001][1001];
    public int countSubstrings(String s) {
        for(int [] row:t) Arrays.fill(row,-1);
        int n = s.length();
        int ans =0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(i,j,s)==1) ans++;
            }
        }
        return ans;
    }
    private int isPalindrome(int i,int j,String s){
        if(i>=j) return 1;
        if(t[i][j]!=-1) return t[i][j];
        if(s.charAt(i)==s.charAt(j)) return t[i][j]=isPalindrome(i+1,j-1,s);
        return t[i][j]=0;
    }
}