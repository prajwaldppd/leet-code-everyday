class Solution {
    int len,idx;
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if (solve(s,i,j)){
                    if(j-i+1 > len){
                        len=j-i+1;
                        idx=i;
                    }
                }
            }
        }
        return s.substring(idx,idx+len);
    }

    public boolean solve(String s, int i, int j){
        if(i>=j) return true;
        if(s.charAt(i)==s.charAt(j)) return solve(s,i+1,j-1);
        return false;
    }
}