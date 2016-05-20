/*
Dynamic Programming:-
Unique Paths
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class UniquePaths {
    int dp[][];
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        return process(m,n);
        //return dp[m-1][n-1];
    }
    public int process(int m, int n){
        if(m==1 || n==1){
            return 1;
        }else if(dp[m-1][n-1]!=0){
            return dp[m-1][n-1];
        }else{
            dp[m-1][n-1] = process(m-1,n)+process(m,n-1);
            return dp[m-1][n-1];
        }
    }
}