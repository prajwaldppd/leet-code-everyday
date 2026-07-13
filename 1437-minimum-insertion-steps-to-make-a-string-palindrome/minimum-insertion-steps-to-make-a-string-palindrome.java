class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int [][] t = new int[n][n];
        for(int len=1;len<=n;len++){
            for(int i=0;i+len-1<n;i++){
                int j = i+len-1;
                if(i==j) t[i][j]=0;
                else if(s.charAt(i)==s.charAt(j)) t[i][j]= t[i+1][j-1];
                else t[i][j]=1+Math.min(t[i+1][j],t[i][j-1]);
            }
        }

        return t[0][n-1];
    }
}


// t[i][j] = no of characters req to insert from s(i,j);
// for s it will be t[0,n-1];
//need t[n][n] array
// if i==j no need to insert anything 0;
// if i+1 =j then check if same need to insert 1 and _ _ a b _ _ i insert 1 character then need to check 
// i+1,j and i,j-1 min of them 
// 