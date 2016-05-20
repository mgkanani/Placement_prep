public class LargestSubSquare {
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
            dp[i][0] = arr[i][0]=='O'?0:1;
            max = Math.max(max,dp[i][0]);
        }
        for(i=0;i<n;i++){
            dp[0][i] = arr[0][i]=='O'?0:1;
            max = Math.max(max,dp[0][i]);
        }
        for(i=1;i<m;i++){
            for(j=1;j<n;j++){
                if(arr[i][j]=='X')
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j])) + 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max,dp[i][j]);
            }
        }
/*        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }        
*/        return max;
/*        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(hori[i][j]+" ");
            }
            System.out.println();
        }
        for(i=0;i<m;i++){
            for(j=0;j<n;j++){
                System.out.print(vert[i][j]+" ");
            }
            System.out.println();
        }        
*/        
    }

    public static void main(String[] args) {
        char mat[][] =  {{'X', 'O', 'X', 'X', 'X', 'X'},
                     {'X', 'O', 'X', 'X', 'O', 'X'},
                     {'X', 'X', 'X', 'O', 'O', 'X'},
                     {'X', 'X', 'X', 'X', 'X', 'X'},
                     {'X', 'X', 'X', 'O', 'X', 'O'},
                    };
        LargestSubSquare obj = new LargestSubSquare();
        System.out.println(obj.maximalSquare(mat));
    }
}

/*



Given a matrix of ‘O’ and ‘X’, find the largest subsquare surrounded by ‘X’

Given a matrix where every element is either ‘O’ or ‘X’, find the largest subsquare surrounded by ‘X’.

In the below article, it is assumed that the given matrix is also square matrix. The code given below can be easily extended for rectangular matrices.



*/