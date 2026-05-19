class Solution {
    static int solve(int bt[]) {
        // code here
        Arrays.sort(bt);
        int curtime =0;
        int waitTime=0;
        
        for(int a: bt){
            waitTime+= curtime;
            curtime+=a;
        }
        
        return waitTime/bt.length;
    }
}
