class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0) return 1.0/helper(1.0, x, -N);
        return helper(1.0, x, N);
    }

    public double helper(double ans, double x, long n){
        if(n==0) return ans;
        if(n%2==1) return helper(ans*x, x, n-1);
        return helper(ans, x*x, n/2);
    }
}