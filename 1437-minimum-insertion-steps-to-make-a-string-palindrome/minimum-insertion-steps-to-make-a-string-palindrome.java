class Solution {
int [][] t;
    private int solve(String s, int i, int j){
        if(i>j) return 0;
        if(t[i][j]!=-1) return t[i][j];
        if(s.charAt(i)==s.charAt(j)) return t[i][j]= solve(s,i+1,j-1);
        return t[i][j]= 1+ Math.min(solve(s,i+1,j),solve(s,i,j-1));
    }
    public int minInsertions(String s) {
        t = new int[501][501];
        for(int[]row: t) Arrays.fill(row,-1);
        return solve(s,0,s.length()-1);
    }
}



// mbadm
// if i> j 0 end

// if char at i== j => i+1,j-1;

// if char at i not equal to char at j 
// choice 1 => i insert j character at ith place so i,j-1;
// else i insert ith character at jth place so i+1,j;

