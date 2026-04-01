class Solution {
    int countStrings(int n) {
        // code here
        if(n==1) return 2;
        if(n==2) return 3;
        if(n==3) return 5;
        
        int[] arr = new int[n+1];
        
        arr[0]=0;
        arr[1]=2;
        arr[2]=3;
        arr[3]=5;
        
        for(int i=4;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        
        return arr[n];
    }
}