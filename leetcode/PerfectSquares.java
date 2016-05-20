public class PerfectSquares {
    int dp[];
    public int numSquares(int n) {
        dp = new int[n+1];
        return proc(n);
    }
    public int proc(int n){
        if(n<=0)
            return 0;
        if(n==1)
            return 1;
        if(dp[n]==0){
            int min = Integer.MAX_VALUE;
            for(int i=1;i*i<=n;i++)
                min = Math.min(min,1+proc(n-i*i));
            dp[n] = min;
        }
        return dp[n];
    }
}
/*
Perfect Squares
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
*/