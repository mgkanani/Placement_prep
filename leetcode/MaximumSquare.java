public class MaximumSquare {
    public int maximalSquare(char[][] arr) {
        int m,n;
        m = arr.length;
        if(m==0)
            return 0;
        n = arr[0].length;
        int[][] dp = new int[m][n];
        int i,j,k,cnt=0;
        int max=0;
        for(i=0;i<m;i++){
            dp[i][0] = arr[i][0]-'0';
            max = Math.max(max,dp[i][0]);
        }
        for(i=0;i<n;i++){
            dp[0][i] = arr[0][i]-'0';
            max = Math.max(max,dp[0][i]);
        }
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(arr[i][j]=='1')
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max,dp[i][j]);
            }
        }
        return max*max;
    }
}